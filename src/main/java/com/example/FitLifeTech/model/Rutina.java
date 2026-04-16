package com.example.FitLifeTech.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rutina {
    @NotNull(message = "El id de la rutina es obligatorio")
        // @NotNull asegura que no venga nulo, se usa en Long, Integer/Double/Date
    private Long id;

    @NotBlank(message = "El nombre de la rutina es obligatorio")
        // @NotBlank asegura que no venga nulo y que no sean puros espacios en blanco se usa Textos/Strings
    private String nombre;

    @NotNull(message = "El nivel de la rutina es obligatorio")
    @Min(value = 1, message = "El nivel más bajo es 1 (Principiante)")
    @Max(value = 5, message = "El nivel más alto es 5 (Élite).")
        //@Min y @Max controlan los rangos numericos
    private Long nivel;

    @NotBlank(message = "La duracion de la rutina es obligatorio")
    @Pattern(regexp = "^[0-9]+ (min|hora)$",
            message = "La duración debe tener el formato '45 min' o '1 hora'")
    //Pattern ^ (El ancla de inicio): Significa "El texto debe empezar estrictamente aquí".
    //[0-9]+ (Los números): * [0-9] significa "cualquier número del 0 al 9" El + significa "puede ser uno o varios números seguidos" (así permite "5", "45", o "120").
    // (El espacio): Obliga a que haya exactamente un espacio en blanco después de los números.
    //(min|hora) (Las opciones): El símbolo | significa "O". Aquí le decimos que después del espacio debe decir exactamente "min", "hora" u "horas"todo en minúsculas
    //$ (El ancla del final): Significa "El texto debe terminar estrictamente aquí" (así evitamos que escriban "45 minutos extras").
    private String duracion;


    @NotBlank(message = "El tipo de la rutina es obligatorio")
    @Size(min = 4, max = 20, message = "El tipo debe tener entre 4 y 20 letras")
        // @Size controla la longitud de los textos
    private String tipo;

    @NotBlank(message = "El entrenador de la rutina es obligatorio")
    private String entrenador;
}
