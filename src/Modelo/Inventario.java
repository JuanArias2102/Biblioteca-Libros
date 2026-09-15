package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Libros> libros;

    public Inventario() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libros libro) {
        this.libros.add(libro);
    }

    public List<Libros> obtenerTodosLosLibros() {
        return this.libros;
    }

    public List<Libros> obtenerLibrosDisponibles() {
        List<Libros> disponibles = new ArrayList<>();

        for (Libros libro : libros) {
            if ("Disponible".equals(libro.getEstado())) {
                disponibles.add(libro);
            }
        }

        return disponibles;
    }
}
