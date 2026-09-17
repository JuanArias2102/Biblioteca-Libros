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

    public List<Libros> obtenerLibros() {
        return this.libros;
    }

    public Libros buscarPorId(String id) {
        for (Libros libro : libros) {
            if (libro.getId().equalsIgnoreCase(id)) {
                return libro;
            }
        }
        return null;
    }
}
