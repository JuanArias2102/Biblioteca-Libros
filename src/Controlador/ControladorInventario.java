import java.util.List;

import Modelo.Inventario;
import Modelo.Libros;

public class ControladorInventario {
    private Inventario inventario;

    public ControladorInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    
    public String cambiarEstadoLibro(String id, String nuevoEstado) {
        
        boolean estadoValido = false;
        switch (nuevoEstado) {
            case "Disponible": estadoValido = true; break;
            case "Prestado": estadoValido = true; break;
            case "Retirado": estadoValido = true; break;
        }

        if (estadoValido == false) {
            return "Error: El estado solo puede ser Disponible, Prestado o Retirado.";
        }

        List<Libros> libros = inventario.obtenerLibros();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().compareTo(id) == 0) {
                libros.get(i).cambiarEstado(nuevoEstado);
                return "Éxito: El estado del libro ha sido actualizado a " + nuevoEstado + ".";
            }
        }

        return "Error: No se encontró ningún libro con ese identificador.";
    }

}
