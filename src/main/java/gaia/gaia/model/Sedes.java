package gaia.gaia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "sedes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sedes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sede;

    private String descripcion_sede;

    private String direccion_sede;

    private String estado;

}
