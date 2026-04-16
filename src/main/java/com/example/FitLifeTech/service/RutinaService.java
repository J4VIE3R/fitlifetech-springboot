package com.example.FitLifeTech.service;

import com.example.FitLifeTech.model.Rutina;
import com.example.FitLifeTech.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    //.Guardar
    public void obtenerGuardarRutina(Rutina r){
        //! Regla 1: No queremos rutinas con nombres repetidos
        rutinaRepository.buscarRutinaNombre(r.getNombre())
                .ifPresent(rutinaEncontrada -> {throw new RuntimeException("No se puede crear: Ya existe una rutina llamada '" + r.getNombre() + "'.");
        //  Metodo".ifPresent()"= exclusiva de Optional,donde valida el resultado y entrega una ejecucion si se cumple que es que encuentra alguna coincidencia funciona como un if donde si cumple ingresa {} sino sigue su camino
        //  Palabra reservada "throw"= detiene por completo la ejectucion del metodo y puedes agreagr un mensaje de error
                });
        rutinaRepository.guardarRutina(r);
    }

    //.Listar
    public List<Rutina> obtenerListaRutina(){
        return rutinaRepository.listaRutina();
    }


    //.Buscar(id)
    public Rutina obtenerBuscarRutinaId(Long id){
        return rutinaRepository.buscarRutinaId(id)
                .orElseThrow(() -> new RuntimeException("Error: La rutina con " + id + "no existe en el sistema" ));
        //  Metodo".orElseThrow()"= exclusiva de Optional donde valida el resultado y entrega una ejecucion si se cumple que es te vacio (.orElseThrow() lo que hace es ver si el resultado de rutinaRepository.buscarRutinaId(id) es cero con la condicion de () hace lo siguiente y ahi se activa el RuntimeException con el mensaje de error)
        //  Clase" RuntimeException()"= creacion de un mensaje de error controlado
    }

    //.Buscar(nombre)
    public Rutina obtenerBuscarRutinaNombre(String nombre){
        return rutinaRepository.buscarRutinaNombre(nombre)
                .orElseThrow(()-> new RuntimeException("Error: La rutina con"  + nombre + "no existe en el sistema"));
    }

    //.Buscar(nivel)
    public List<Rutina> obtenerBuscarRutinaNivel(Long nivel){
        return rutinaRepository.buscarRutinaNivel(nivel);

    }
    //.Buscar(tipo)
    public List<Rutina> obtenerBuscarRutinaTipo(String tipo) {
        return rutinaRepository.buscarRutinaTipo(tipo);
    }

    //.Buscar(duracion)
    public List<Rutina> obtenerBuscarRutinaDuracion(String duracion) {
        return rutinaRepository.buscarRutinaDuracion(duracion);
    }

    //.Eliminar
    public void obtenerEliminarRutina(Long id){
        rutinaRepository.buscarRutinaId(id).orElseThrow(()-> new RuntimeException("El id a eliminar nose encuentra"));

        rutinaRepository.eliminarRutina(id);
    }

    //.Actualizar
    public void obtenerActualizarRutina(Long id, Rutina rutinaActualizada) {
        Rutina existente = rutinaRepository.buscarRutinaId(id)
                .orElseThrow(() -> new RuntimeException("Error: La rutina con ID " + id + " no existe."));

        rutinaActualizada.setId(existente.getId());

        rutinaRepository.actualizarRutina(rutinaActualizada);
    }
}
