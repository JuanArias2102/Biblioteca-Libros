import Modelo.Inventario;
import Modelo.Libros;

import java.util.List;

public class ControladorLibros {
    private Inventario inventario;

    public ControladorLibros(Inventario inventario) {
        this.inventario = inventario;
    }

    
    public String registrarLibro(String id, String titulo, String autor, String editorial, int anio, String categoria) {
        
        
        boolean categoriaValida = false;
        switch (categoria) {
            case "Literatura": categoriaValida = true; 
            break;
            case "Ciencia": categoriaValida = true; 
            break;
            case "Historia": categoriaValida = true; 
            break;
            case "Tecnología": categoriaValida = true; 
            break;
        }

        if (categoriaValida == false) {
            return "Error: La categoría debe ser Literatura, Ciencia, Historia o Tecnología.";
        }

        
        List<Libros> libros = inventario.obtenerLibros();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().compareTo(id) == 0) {
                return "Error: Ya existe un ejemplar con ese identificador único.";
            }
        }

        Libros nuevoLibro = new Libros(id, titulo, autor, editorial, anio, categoria);
        inventario.agregarLibro(nuevoLibro);

        return "Éxito: Libro registrado correctamente.";
    }

    
    public String listarLibrosDisponibles() {
        List<Libros> libros = inventario.obtenerLibros();
        String listado = "--- Libros Disponibles ---\n";
        boolean hayLibros = false;

        for (int i = 0; i < libros.size(); i++) {
            Libros libro = libros.get(i);
            
            
            if (libro.getEstado().compareTo("Disponible") == 0) {
                listado = listado + libro.mostrarInformacion() + "\n";
                hayLibros = true;
            }
        }

        if (hayLibros == false) {
            return "No hay libros disponibles en este momento.";
        }

        return listado;
    }
}
