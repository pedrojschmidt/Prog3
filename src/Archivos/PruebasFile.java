package Archivos;

import java.io.File;

public class PruebasFile {

    public static void main(String[] args) {

        // Prueba 1
        File file1 = new File ("Algoritmos.txt"); // al poner el path de esta manera lo que hace es buscarlo en la carpeta src del proyecto
        if (file1.exists())
            System.out.println("Archivo existe");
        else
            System.out.println("Archivo NO existe");


        // Prueba 2
        File file2 = new File ("C:\\Users\\Pedro\\Desktop\\Folder\\Austral\\Java\\Algoritmos.txt"); // lo busca en ese path
        if (file2.exists())
            System.out.println("Archivo existe");
        else
            System.out.println("Archivo NO existe");

    }
}
