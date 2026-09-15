import Modelo.Inventario;
import Modelo.Libros;

import java.util.List;

public class ControladorLibros {
    private Inventario inventario;

    public ControladorLibros(Inventario inventario) {
        this.inventario = inventario;
    }

    public String registrarLibro(String id, String titulo, String autor, String editorial, int anioPublicacion, String categoria) {
        boolean categoriaValida = false;

        switch (categoria) {
            case "Literatura":
                categoriaValida = true;
                break;
            case "Ciencia":
                categoriaValida = true;
                break;
            case "Historia":
                categoriaValida = true;
                break;
            case "Tecnología":
                categoriaValida = true;
                break;
        }

        if (!categoriaValida) {
            return "Error: Categoría inválida. Debe ser Literatura, Ciencia, Historia o Tecnología.";
        }

        Libros nuevoLibro = new Libros(id, titulo, autor, editorial, anioPublicacion, categoria);
        inventario.agregarLibro(nuevoLibro);

        return "Éxito: Libro registrado correctamente.";
    }

    public String listarLibrosDisponibles() {
        List<Libros> disponibles = inventario.obtenerLibrosDisponibles();

        if (disponibles.isEmpty()) {
            return "No hay libros disponibles en este momento.";
        }

        String listado = "--- Libros Disponibles ---\n";

        for (Libros libro : disponibles) {
            listado = listado + libro.mostrarInformacion() + "\n";
        }

        return listado; // Se retorna el String directamente
    }
}
