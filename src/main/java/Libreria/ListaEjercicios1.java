/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Libreria;

import java.util.ArrayList;

/**
 *
 * @author RedStar
 */
public class ListaEjercicios1 {

    public static void main(String[] args) {
        TextManager txtManager=new TextManager();
        txtManager.listarLibros();
        ArrayList<Autor> autores=txtManager.getAutores();
        
        //txtManager.agregarLibro("1", "El Libro Troll del Rubius", autores.get(0), true, true);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearLibro(txtManager).setVisible(true);
            }
        });
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarLibro(txtManager).setVisible(true);
            }
        });*/
    }
}
