package Archivos;

import java.io.*;

public class PruebasRandomAccesFile {

    public static void main(String[] args) {

        // Si no existe el archivo, RandomAccesFile lo crea en el path del File
        String fileName1 = "C:\\Users\\Pedro\\Desktop\\datos";
        File f1 = new File(fileName1);
        try {
            RandomAccessFile f11 = new RandomAccessFile(f1, "rw");
        }
        catch (IOException IOe){
            System.out.println("Se produjo un error");
        }


        // Si no existe el archivo, RandomAccesFile lo crea en la carpeta src de este proyecto
        String fileName2 = "datos";
        File f2 = new File(fileName2);
        try {
            RandomAccessFile f22 = new RandomAccessFile(f2, "rw");
        }
        catch (IOException IOe){
            System.out.println("Se produjo un error");
        }


        // Crea un archivo de texto
        String fileName3 = "datos.txt";
        File f3 = new File(fileName3);
        try {
            RandomAccessFile f33 = new RandomAccessFile(f3, "rw");
        }
        catch (IOException IOe){
            System.out.println("Se produjo un error");
        }
    }
}
