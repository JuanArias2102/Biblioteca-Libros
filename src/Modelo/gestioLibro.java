package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class gestioLibro {

    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private String estado;
    private int anioPublicacaion;

    public gestioLibro(String id, String titulo, String autor, String editorial, String categoria, String estado, int anioPublicacaion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
        this.estado = "disponible";
        this.anioPublicacaion = anioPublicacaion;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Estado: " + estado);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAnioPublicacaion() {
        return anioPublicacaion;
    }

    public void setAnioPublicacaion(int anioPublicacaion) {
        this.anioPublicacaion = anioPublicacaion;
    }

}
