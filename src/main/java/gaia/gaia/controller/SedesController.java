package gaia.gaia.controller;

import gaia.gaia.model.Sedes;
import gaia.gaia.model.Usuarios;
import gaia.gaia.repository.SedesRepository;
import gaia.gaia.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedesController
{
    @Autowired
    private SedesRepository sedesRepository;

    @GetMapping
    public List<Sedes> getAll()
    {
        return sedesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sedes getById(Long id_sede)
    {
        return sedesRepository.findById(id_sede).orElse(null);
    }

    @PostMapping
    public Sedes create(@RequestBody Sedes sedes)
    {
        return sedesRepository.save(sedes);
    }

    @PutMapping("/{id}")
    public Sedes update(@PathVariable Long id_sede, @RequestBody Sedes sedes)
    {
        sedes.setId_sede(id_sede);
        return sedesRepository.save(sedes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id_sede)
    {
        sedesRepository.deleteById(id_sede);
    }

}
