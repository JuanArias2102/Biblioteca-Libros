import Controlador.ControladorBiblioteca;
import Modelo.Clientes;
import Modelo.Inventario;
import Modelo.Libros;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // Método auxiliar para pedir enteros sin riesgo de colapso por NumberFormatException
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Inventario inventario = new Inventario();

        ControladorBiblioteca controlador = new ControladorBiblioteca(listaClientes, inventario);

        int opcion = 0;

        do {
            System.out.println("\n==================================================");
            System.out.println("       SISTEMA DE GESTIÓN DE BIBLIOTECA          ");
            System.out.println("==================================================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Editar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Registrar libro");
            System.out.println("6. Listar libros disponibles");
            System.out.println("7. Cambiar estado de un libro");
            System.out.println("8. Realizar préstamo");
            System.out.println("9. Realizar devolución");
            System.out.println("0. Salir");

            try {
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("--- REGISTRAR CLIENTE ---");
                    int doc = leerEntero(scanner, "Documento de identidad (número): ");
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();

                    Clientes nuevoCliente = new Clientes(doc, nombre, dir, tel);
                    if (controlador.registrarCliente(nuevoCliente)) {
                        System.out.println("Cliente registrado con éxito.");
                    } else {
                        System.out.println("Error: Ya existe un cliente registrado con ese número de documento.");
                    }
                    break;

                case 2:
                    System.out.println("--- BUSCAR CLIENTE ---");
                    int docBuscar = leerEntero(scanner, "Ingrese el documento a buscar: ");
                    Clientes clienteHallado = controlador.buscarCliente(docBuscar);
                    if (clienteHallado != null) {
                        System.out.println("Cliente encontrado:");
                        System.out.println("   Nombre: " + clienteHallado.getNombreCompleto());
                        System.out.println("   Documento: " + clienteHallado.getDocumentoIdentidad());
                        System.out.println("   Dirección: " + clienteHallado.getDireccion());
                        System.out.println("   Teléfono: " + clienteHallado.getTelefono());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("--- EDITAR CLIENTE ---");
                    int docEdit = leerEntero(scanner, "Documento del cliente a editar: ");
                    System.out.print("Nuevo nombre completo: ");
                    String nomEdit = scanner.nextLine();
                    System.out.print("Nueva dirección: ");
                    String dirEdit = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String telEdit = scanner.nextLine();

                    Clientes cEdit = new Clientes(docEdit, nomEdit, dirEdit, telEdit);
                    if (controlador.editarCliente(cEdit)) {
                        System.out.println("Datos del cliente actualizados correctamente.");
                    } else {
                        System.out.println("No existe un cliente con ese documento para editar.");
                    }
                    break;

                case 4:
                    System.out.println("--- ELIMINAR CLIENTE ---");
                    int docElim = leerEntero(scanner, "Documento del cliente a eliminar: ");
                    if (controlador.eliminarCliente(docElim)) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("No se pudo eliminar el cliente (no existe o tiene un libro prestado actualmente).");
                    }
                    break;

                case 5:
                    System.out.println("--- REGISTRAR LIBRO ---");
                    System.out.print("ID del libro (Ej. L001): ");
                    String idLibro = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Categoría (Literatura, Ciencia, Historia, Tecnología): ");
                    String cat = scanner.nextLine();

                    Libros nuevoLibro = new Libros(idLibro, titulo, autor, cat, "Disponible");
                    String resLibro = controlador.registrarLibro(nuevoLibro);
                    System.out.println(resLibro);
                    break;

                case 6:
                    System.out.println(controlador.listarLibrosDisponibles());
                    break;

                case 7:
                    System.out.println("--- CAMBIAR ESTADO DE LIBRO ---");
                    System.out.print("ID del libro: ");
                    String idCambio = scanner.nextLine();
                    System.out.print("Nuevo estado (Disponible, Prestado, Retirado): ");
                    String nuevoEst = scanner.nextLine();
                    System.out.println(controlador.cambiarEstadoLibro(idCambio, nuevoEst));
                    break;

                case 8:
                    System.out.println("--- REALIZAR PRÉSTAMO ---");
                    System.out.print("ID del libro a prestar: ");
                    String idPrest = scanner.nextLine();
                    int docPrest = leerEntero(scanner, "Documento del cliente: ");
                    controlador.realizarPrestamo(idPrest, docPrest);
                    break;

                case 9:
                    System.out.println("--- REALIZAR DEVOLUCIÓN ---");
                    int docDev = leerEntero(scanner, "Documento del cliente: ");
                    System.out.print("ID del libro a devolver: ");
                    String idDev = scanner.nextLine();
                    controlador.realizarDevolucion(docDev, idDev);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema de biblioteca... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
