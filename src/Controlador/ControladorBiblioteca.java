import Modelo.Clientes;
import Modelo.Libros;
import Modelo.Inventario;
import java.util.ArrayList;
import java.util.List;
public class ControladorBiblioteca {

    private ArrayList<Clientes> listaClientes;
    private Inventario inventario;

    public ControladorBiblioteca(ArrayList<Clientes> listaClientes, Inventario inventario) {
        this.listaClientes = listaClientes;
        this.inventario = inventario;
    }

    public boolean registrarCliente(Clientes clienteNuevo) {
        Clientes buscar = buscarCliente(clienteNuevo.getDocumentoIdentidad());
        if (buscar != null) {
            return false;
        }
        listaClientes.add(clienteNuevo);
        return true;
    }

    public Clientes buscarCliente(int documentoBuscar) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDocumentoIdentidad() == documentoBuscar) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    public boolean editarCliente(Clientes clienteEditado) {
        Clientes buscar = buscarCliente(clienteEditado.getDocumentoIdentidad());
        if (buscar != null) {
            buscar.setNombreCompleto(clienteEditado.getNombreCompleto());
            buscar.setDireccion(clienteEditado.getDireccion());
            buscar.setTelefono(clienteEditado.getTelefono());
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(int documento) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getDocumentoIdentidad() == documento) {
                if (listaClientes.get(i).isLibroPrestado()) {
                    return false;
                }
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public void realizarPrestamo(String idLibro, int documentoCliente) {
        Libros libro = inventario.buscarPorId(idLibro);
        Clientes cliente = buscarCliente(documentoCliente);

        if (libro == null) {
            System.out.println("El libro con ID '" + idLibro + "' no existe en el sistema.");
            return;
        }
        if (cliente == null) {
            System.out.println("El cliente con documento '" + documentoCliente + "' no existe en el sistema.");
            return;
        }

        if (!libro.getEstado().equalsIgnoreCase("DISPONIBLE")) {
            System.out.println("El libro no se puede prestar porque su estado actual es '" + libro.getEstado() + "'.");
            return;
        }

        if (cliente.isLibroPrestado()) {
            System.out.println("El cliente ya tiene un libro prestado actualmente ("
                    + cliente.getLibroPrestado().getTitulo() + ").");
            return;
        }

        libro.setEstado("PRESTADO");
        cliente.setLibroPrestado(libro);
        System.out.println("Préstamo registrado exitosamente a favor de " + cliente.getNombreCompleto() + "");
    }

    public void realizarDevolucion(int documentoCliente, String idLibroDevuelto) {
        Clientes cliente = buscarCliente(documentoCliente);

        if (cliente == null) {
            System.out.println("El cliente con documento '" + documentoCliente + "' no existe en el sistema.");
            return;
        }
        if (!cliente.isLibroPrestado()) {
            System.out.println("El cliente no figura con ningún libro en préstamo.");
            return;
        }
        Libros libro = cliente.getLibroPrestado();

        if (libro == null || !libro.getId().equalsIgnoreCase(idLibroDevuelto)) {
            System.out.println("El ID del libro entregado ('" + idLibroDevuelto
                    + "') no coincide con el libro prestado al cliente.");
            return;
        }

        cliente.recibirLibro(idLibroDevuelto);

        libro.setEstado("DISPONIBLE");
        cliente.setLibroPrestado(null);
        System.out.println("Devolución registrada con éxito. El libro '" + libro.getTitulo() + "' vuelve a estar DISPONIBLE.");
    }

    public String registrarLibro(Libros libroNuevo) {
        if (libroNuevo == null) {
            return "Error: Objeto libro no válido.";
        }
        String categoria = libroNuevo.getCategoria();
        boolean categoriaValida = false;
        if (categoria != null) {
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
    }

        if (!categoriaValida) {
            return "La categoría debe ser Literatura, Ciencia, Historia o Tecnología.";
        }

        List<Libros> libros = inventario.obtenerLibros();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().compareTo(libroNuevo.getId()) == 0) {
                return "Ya existe un ejemplar con ese identificador único.";
            }
        }

        inventario.agregarLibro(libroNuevo);

        return "Libro registrado correctamente.";
    }

    public String listarLibrosDisponibles() {
        List<Libros> libros = inventario.obtenerLibros();
        String listado = "--- Libros Disponibles ---\n";
        boolean hayLibros = false;

        for (int i = 0; i < libros.size(); i++) {
            Libros libro = libros.get(i);
            if (libro.getEstado().equalsIgnoreCase("Disponible")) {
                listado = listado + libro.mostrarInformacion() + "\n";
                hayLibros = true;
            }
        }

        if (!hayLibros) {
            return "No hay libros disponibles en este momento.";
        }

        return listado;
    }

    public String cambiarEstadoLibro(String id, String nuevoEstado) {

        boolean estadoValido = false;
        
        if (nuevoEstado != null) {
        switch (nuevoEstado) {
            case "Disponible":
                estadoValido = true;
                break;
            case "Prestado":
                estadoValido = true;
                break;
            case "Retirado":
                estadoValido = true;
                break;
        }
    }

        if (!estadoValido) {
            return "El estado solo puede ser Disponible, Prestado o Retirado.";
        }

        List<Libros> libros = inventario.obtenerLibros();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().compareTo(id) == 0) {
                libros.get(i).cambiarEstado(nuevoEstado);
                return "El estado del libro ha sido actualizado a " + nuevoEstado + ".";
            }
        }

        return "No se encontró ningún libro con ese identificador.";
    }

}
