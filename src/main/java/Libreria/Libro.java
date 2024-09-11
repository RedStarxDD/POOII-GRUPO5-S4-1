/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author RedStar
 */
public class Libro {
    private String idLibro, titulo;
    private Autor autor;
    private boolean fueLeido, fueAdquirido;

    public Libro(String idLibro, String titulo, Autor autor, boolean fueLeido, boolean fueAdquirido) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.fueLeido = fueLeido;
        this.fueAdquirido = fueAdquirido;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isFueLeido() {
        return fueLeido;
    }

    public void setFueLeido(boolean fueLeido) {
        this.fueLeido = fueLeido;
    }

    public boolean isFueAdquirido() {
        return fueAdquirido;
    }

    public void setFueAdquirido(boolean fueAdquirido) {
        this.fueAdquirido = fueAdquirido;
    }
}
