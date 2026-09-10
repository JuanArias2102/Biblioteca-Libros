public class gestion_clientes {
    int documento_identidad;
    String nombreCompleto;
    String telefono;
    String direccion;
    int libroPrestado;

    public gestion_clientes(int documento_identidad, String nombreCompleto, String telefono, String direccion, int libroPrestado) {
        this.documento_identidad = documento_identidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.libroPrestado = libroPrestado;
    }
public void setDocumento_identidad(int documento_identidad) {
        this.documento_identidad = documento_identidad;
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

    public int getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(int libroPrestado) {
        this.libroPrestado = libroPrestado;
    }
    
}
