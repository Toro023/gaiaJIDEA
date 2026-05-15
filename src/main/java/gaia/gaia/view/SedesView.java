package gaia.gaia.view;

import gaia.gaia.controller.SedesController;
import gaia.gaia.model.Sedes;
import gaia.gaia.repository.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SedesView
{
    @Autowired
    private SedesRepository sedesRepository;

    @GetMapping("/view/sedes")
    public String lista(Model model)
    {
        model.addAttribute("sedes", sedesRepository.findAll());
        return "sedes/list";
    }

    @GetMapping("/view/sedes/form")
    public String form(Model model)
    {
        model.addAttribute("sedes", new Sedes());
        return "sedes/form";
    }

    @PostMapping("/view/sedes/save")
    public String save(@ModelAttribute Sedes sedes, RedirectAttributes ra)
    {
        sedesRepository.save(sedes);
        ra.addFlashAttribute("mensaje", "Sede guardado con exito");
        return "redirect:/view/sedes";
    }

    @GetMapping("/view/sedes/edit/{id}")
    public String edit(@PathVariable Long id_sede, Model model)
    {
        Sedes sedes = sedesRepository.findById(id_sede).orElse(null);
        model.addAttribute("sedes", sedes);
        return "sedes/form";
    }

    @PostMapping("/view/sedes/delete/{id}")
    public String delete(@PathVariable Long id_sede, RedirectAttributes ra)
    {
        sedesRepository.deleteById(id_sede);
        ra.addFlashAttribute("mensaje", "Sede eliminado con exito");
        return "redirect:/view/sedes";
    }

}
