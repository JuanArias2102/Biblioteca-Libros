package Modelo;


public class Clientes {

    private int documentoIdentidad;
    private String nombreCompleto;
    private String telefono;
    private String direccion;
    private boolean libroPrestado;
    private String idLibroPrestado;

    public Clientes(int documentoIdentidad, String nombreCompleto, String telefono, String direccion, boolean libroPrestado, String idLibroPrestado) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.libroPrestado = libroPrestado;
        this.idLibroPrestado = idLibroPrestado;
    }

    public void prestarLibro(String idLibro) {
        libroPrestado = true;
        idLibroPrestado = idLibro;
    }

    public boolean recibirLibro(String idlibroDevuelto) {
        if (idLibroPrestado == null || !idLibroPrestado.equalsIgnoreCase(idlibroDevuelto)) {
            System.out.println("Error el id del libro es incorrecto" + idlibroDevuelto);
            return false;
        }
        libroPrestado = false;
        idLibroPrestado = null;
        return true;
    }
    public void mostrarInformacion() {
        System.out.println("Documento: " + documentoIdentidad);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("Tiene libro prestado: " + (libroPrestado ? "SÍ (ID Libro: " + idLibroPrestado + ")" : "NO"));
    }

    public String getIdLibroPrestado() {
        return idLibroPrestado;
    }

    public void setIdLibroPrestado(String idLibroPrestado) {
        this.idLibroPrestado = idLibroPrestado;
    }

    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

}
