package Libreria;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class TextManager {
   private ArrayList<Libro> libros = new ArrayList();
   private ArrayList<Autor> autores = new ArrayList();
   private int idUsados=0;

   public TextManager() {
      this.cargarArchivo("autores");
      this.cargarArchivo("libros");
   }

   public ArrayList<Libro> getLibros() {
      return this.libros;
   }

   public ArrayList<Autor> getAutores() {
      return this.autores;
   }

    public int getIdUsados() {
        return idUsados;
    }
   
   public void listarLibros() {
       for (Libro libro : libros) {
           System.out.println(libro.toString());
       }
   }

   private void readFromInputStream(InputStream inputStream, String archivo) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

      String linea;
      while((linea = br.readLine()) != null) {
         StringTokenizer st = new StringTokenizer(linea, ",");
         byte var7 = -1;
         switch(archivo.hashCode()) {
         case -1103016655:
            if (archivo.equals("libros")) {
               var7 = 0;
            }
            break;
         case -646297455:
            if (archivo.equals("autores")) {
               var7 = 1;
            }
         }

         switch(var7) {
         case 0:
            this.crearLibro(st);
            break;
         case 1:
            this.crearAutor(st);
         }
      }

      br.close();
   }

   private void crearLibro(StringTokenizer st) {
      String idLibro = st.nextToken().trim();
      String titulo = st.nextToken().trim();
      String idAutor = st.nextToken().trim();
      boolean fueLeido = Boolean.getBoolean(st.nextToken().trim());
      boolean fueAdquirido = Boolean.getBoolean(st.nextToken().trim());
      Iterator var7 = this.autores.iterator();

      while(var7.hasNext()) {
         Autor a = (Autor)var7.next();
         if (a.getIdAutor().equals(idAutor)) {
            Libro libro = new Libro(idLibro, titulo, a, fueLeido, fueAdquirido);
            this.libros.add(libro);
            break;
         }
      }

   }

   private void crearAutor(StringTokenizer st) {
      String idAutor = st.nextToken().trim();
      String nombre = st.nextToken().trim();
      Autor autor = new Autor(idAutor, nombre);
      this.autores.add(autor);
      idUsados++;
   }

   private void cargarArchivo(String nombre) {
      try {
         File file = new File("./src/main/java/" + nombre + ".txt");
         Class<TextManager> clazz = TextManager.class;
         InputStream inputStream = clazz.getResourceAsStream("/" + nombre + ".txt");
         if (file.exists()) {
            this.readFromInputStream(inputStream, nombre);
         } else {
            JOptionPane.showMessageDialog((Component)null, "El archivo " + nombre + ".txt no existe");
         }
      } catch (Exception var5) {
         JOptionPane.showMessageDialog((Component)null, "Se produjo un error= " + String.valueOf(var5));
      }

   }

   public void agregarAutor(String nombre) {
    try {
        File file = new File("./target/classes/autores.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(idUsados + ", " + nombre);
        pw.close();
        Autor autor = new Autor(String.valueOf(idUsados), nombre);
        this.autores.add(autor);
        this.listarLibros();
        idUsados++;
    } catch (Exception var7) {
        System.out.println("Error");
    }
   }

   public void agregarLibro(String idLibro, String titulo, Autor autor, boolean fueLeido, boolean fueAdquirido) {
      try {
          System.out.println("ok");
         File file = new File("./target/classes/libros.txt");
         FileWriter fw = new FileWriter(file, true);
         PrintWriter pw = new PrintWriter(fw);
         pw.println(idLibro + ", " + titulo + ", " + autor.getIdAutor() + ", " + fueLeido + ", " + fueAdquirido);
         pw.close();
         Libro libro = new Libro(idLibro, titulo, autor, fueLeido, fueAdquirido);
         this.libros.add(libro);
         this.listarLibros();
      } catch (Exception var10) {
          System.out.println("Error");
      }

   }
}