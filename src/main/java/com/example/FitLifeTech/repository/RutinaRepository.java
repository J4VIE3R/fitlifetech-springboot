package com.example.FitLifeTech.repository;

import com.example.FitLifeTech.model.Rutina;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RutinaRepository {

    //.DB
    private List<Rutina> listaRutina = new ArrayList<>();

    public RutinaRepository (){
        listaRutina.add(new Rutina(1L, "Rutina Full Body", 1L, "30 min", "Anaerobico", "Carlos Perez"));
        listaRutina.add(new Rutina(2L, "Cardio Intenso", 2L, "45 min", "Aerobico", "Ana Lopez"));
        listaRutina.add(new Rutina(3L, "HIIT Express", 3L, "20 min", "Anaerobico", "Luis Torres"));
        listaRutina.add(new Rutina(4L, "Yoga Relajante", 1L, "1 hora", "Aerobico", "Maria Silva"));
        listaRutina.add(new Rutina(5L, "Piernas Pro", 4L, "50 min", "Anaerobico", "Jorge Rojas"));
        listaRutina.add(new Rutina(6L, "Espalda Fuerte", 3L, "40 min", "Anaerobico", "Camila Diaz"));
        listaRutina.add(new Rutina(7L, "Rutina Abdominal", 2L, "25 min", "Anaerobico", "Pedro Vega"));
        listaRutina.add(new Rutina(8L, "Boxeo Fitness", 4L, "1 hora", "Aerobico", "Ricardo Soto"));
        listaRutina.add(new Rutina(9L, "Entrenamiento Funcional", 3L, "45 min", "Anaerobico", "Valentina Cruz"));
        listaRutina.add(new Rutina(10L, "Rutina Crossfit", 5L, "1 hora", "Anaerobico", "Diego Morales"));
        listaRutina.add(new Rutina(11L, "Gluteos Intensos", 3L, "40 min", "Anaerobico", "Fernanda Reyes"));
        listaRutina.add(new Rutina(12L, "Rutina Pecho", 2L, "35 min", "Anaerobico", "Cristian Moya"));
        listaRutina.add(new Rutina(13L, "Rutina Brazos", 2L, "30 min", "Anaerobico", "Paula Herrera"));
        listaRutina.add(new Rutina(14L, "Resistencia Total", 4L, "50 min", "Aerobico", "Andres Castillo"));
        listaRutina.add(new Rutina(15L, "Pilates Basico", 1L, "45 min", "Aerobico", "Daniela Campos"));
        listaRutina.add(new Rutina(16L, "Rutina Avanzada", 5L, "1 hora", "Anaerobico", "Sebastian Fuentes"));
        listaRutina.add(new Rutina(17L, "Entrenamiento Militar", 5L, "1 hora", "Anaerobico", "Oscar Medina"));
        listaRutina.add(new Rutina(18L, "Circuito Quemagrasa", 3L, "40 min", "Aerobico", "Karla Pizarro"));
        listaRutina.add(new Rutina(19L, "Movilidad y Estiramiento", 1L, "30 min", "Aerobico", "Gabriel Araya"));
        listaRutina.add(new Rutina(20L, "Rutina Elite Total", 5L, "1 hora", "Anaerobico", "Ignacio Vera"));
    }
    //.Guardar
    public void guardarRutina(Rutina r){
        listaRutina.add(r);
    }

    //.Listar
    public List listaRutina(){
        return listaRutina;
    }

    //.Buscar(id)
    public Optional<Rutina> buscarRutinaId(Long id){
        return listaRutina.stream()
                .filter(rutina -> rutina.getId().equals(id))
                .findFirst();
                
        //  Clase "Optional<>"= "Clase contenedora de lista"  Obliga al programador a manejar el caso de que el auto no exista de forma segura
        //  Metodo".stream()"= Convierte tu lista estática en un flujo de datos
        //  Metodo".filter() filtro con Flecha Lambda instrucción de recorrer la lista
        //  Metodo".findFirst()"= Es la operación terminal. En cuanto el filtro deja pasar al primer auto que cumple la condición, findFirst() lo atrapa, lo mete dentro del Optional y detiene toda la cinta transportadora. No sigue buscando porque ya encontró lo que quería.

    }

    //.Buscar(nombre)
    public Optional<Rutina>buscarRutinaNombre(String nombre){
        return listaRutina.stream()
                .filter(rutina -> rutina.getNombre().equals(nombre))
                .findFirst();

    }

    //.Buscar(nivel)
    public List<Rutina>buscarRutinaNivel(Long nivel) {
        return listaRutina.stream()
                .filter(rutina -> rutina.getNivel().equals(nivel))
                .toList();
        //  Metedo".toList()"= Es la operación terminal. En cuanto el filtro deja pasar un dato que cumple la condición, .toList() lo atrapa, lo mete dentro de la lista pero no se detiene la busqueda hasta el ultimo dato de lista.
    }

    //.Buscar(tipo)
    public List<Rutina> buscarRutinaTipo(String tipo){
        return listaRutina.stream()
                .filter(rutina -> rutina.getTipo().equals(tipo))
                .toList();

    }

    //.Buscar(duracion)
    public List<Rutina>buscarRutinaDuracion(String duracion){
        return listaRutina.stream()
                .filter(rutina -> rutina.getDuracion().equals(duracion))
                .toList();
    }

    //.Eliminar
    public boolean eliminarRutina(Long id){
        return listaRutina.removeIf(rutina -> rutina.getId().equals(id));
        //  Metodo".removeIf()= remueve el dato que encontro y devuelve un booleano, return true: Si encontró al menos un auto que coincidía con el ID y lo borró con éxito return false: Si recorrió toda la lista, no encontró ningún auto con ese ID y, por lo tanto, no borró nada.

    }

    //.Actualizar
    public void actualizarRutina(Rutina r){
        listaRutina.replaceAll(rutina -> rutina.getId().equals(r.getId()) ? r : rutina);
        //  Metodo".replaceAll()"= sobreescribe los elementos de la lista original basandose en una condición

    }
}
