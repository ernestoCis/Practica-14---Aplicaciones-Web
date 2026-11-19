package com.jesus.cisneros.pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio y no puede estar vacio.")
    @Size(min = 2, max = 50, message = "El nombre debete tener entre 2 a 50 caracteres.")
    private String nombre;

    @NotBlank(message = "El tipo de pokemon es obligatorio.")
    private String tipo;

    @NotNull(message = "El nivel es obligatorio")
    @Min(value = 1, message = "El nivel minimo es 1")
    @Max(value = 100, message = "El nivel maximo es de 100")
    private Integer nivel;

    @Min(value = 0, message = "El ataque no puede ser negativo")
    @Positive(message = "El ataque no puede ser negativo")
    private Integer ataque;

    @Min(value = 0, message = "La defensa no puede ser negativo")
    private Integer defensa;

    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;

    @URL(message = "La imagen debe ser quna URL valida")
    private String imagenUrl;

    @PastOrPresent(message = "La fecha de captura no puede ser en el futuro")
    private LocalDate fechaCaptura;

}
