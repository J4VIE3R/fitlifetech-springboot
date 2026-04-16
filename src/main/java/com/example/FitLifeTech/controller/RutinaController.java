package com.example.FitLifeTech.controller;


import com.example.FitLifeTech.model.Rutina;
import com.example.FitLifeTech.service.RutinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rutinas")

public class RutinaController {

    @Autowired
    private  RutinaService rutinaService;

    //.Guardar
    @PostMapping
    public void crearRutina(@Valid @RequestBody Rutina rutinaNueva){
        rutinaService.obtenerGuardarRutina(rutinaNueva);
    }

    //.Listar
    @GetMapping
    public List<Rutina> obtenerTodas(){
        return rutinaService.obtenerListaRutina();
    }

    //.Buscar(id)
    @GetMapping("/id/{id}")
    public Rutina obtenerBuscarId(@PathVariable Long id){
        return rutinaService.obtenerBuscarRutinaId(id);
    }

    //.Buscar(nombre)
    @GetMapping("/nombre/{nombre}")
    public Rutina obtenerBuscarNombre(@PathVariable String nombre){
        return rutinaService.obtenerBuscarRutinaNombre(nombre);
    }

    //.Buscar(nivel)
    @GetMapping("/nivel/{nivel}")
    public List<Rutina>obtenerBuscarNivel(@PathVariable Long nivel){
        return rutinaService.obtenerBuscarRutinaNivel(nivel);
    }

    //.Buscar(tipo)
    @GetMapping("/tipo/{tipo}")
    public List<Rutina>obtenerBuscarNivel(@PathVariable String tipo){
        return rutinaService.obtenerBuscarRutinaTipo(tipo);
    }
    //.Buscar(duracion)
    @GetMapping("/duracion/{duracion}")
    public List<Rutina>obtenerBuscarDuracion(@PathVariable String duracion){
        return rutinaService.obtenerBuscarRutinaDuracion(duracion);
    }

    //.Eliminar
    @DeleteMapping("/{id}")
    public void eliminarRutina(@PathVariable Long id){
        rutinaService.obtenerEliminarRutina(id);

    }

    //.Actualizar
    @PutMapping("/{id}")
    public void actulizarRutina(@PathVariable Long id, @Valid @RequestBody Rutina rutinaActualizada){
        rutinaService.obtenerActualizarRutina(id,rutinaActualizada);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manejarErroresValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }
        return errores;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> manejarErroresDeLogica(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    

}


