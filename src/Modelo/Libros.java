package Modelo;

public class Libros {
    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private String categoria;
    private String estado;

    public Libros(String id, String titulo, String autor, String editorial, int anioPublicacion, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
        this.estado = "Disponible";
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String mostrarInformacion() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor
                + " | Editorial: " + editorial + " | Año: " + anioPublicacion
            + " | Categoría: " + categoria + " | Estado: " + estado;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

}
















    











