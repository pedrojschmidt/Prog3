package Archivos;

import java.io.IOException;
import java.util.Scanner;

public class IO {

    private Scanner lector ;
    private String nombreArchivo = "C:\\Users\\Pedro\\Desktop\\Folder\\Austral\\Java\\El Super.txt";

    public IO(){
        lector = new Scanner(System.in);
        int opcion = menu();
        while (opcion < 8){
            switch(opcion){
                case 1: alta();
                    break;
                //case 2: tamaño();
                //    break;
                case 3: listar();
                    break;
                //case 4: cantAlmacen();
                //    break;
                case 5: buscar();
                    break;
                case 6: eliminar();
                    break;
                case 7: compactar();
                    break;
            }
            opcion = menu();
        }
    }

    public int menu(){
        System.out.println("1. Alta");
        System.out.println("2. Cantidad de Productos");
        System.out.println("3. Listar todos los productos");
        System.out.println("4. Cantidad de Productos de Almacen");
        System.out.println("5. Buscar");
        System.out.println("6. Eliminar");
        System.out.println("7. Compactar");
        System.out.println("8. Fin");
        System.out.println("Opcion: ");
        String opc = lector.nextLine();
        int opcion = Integer.parseInt(opc);
        return opcion;
    }

    // Este es el "procesar"
    public void listar() {
        Producto p;
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            long cant = archP.cantReg();
            for (long i = 0; i < cant ; i++){
                p = archP.leer();
                if(p.isActivo())
                    System.out.println(p.toString());
            }
            archP.cerrar();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*
    // alta provisoria
    public void alta(){
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            archP.escribir(new Producto(111, 12.3,'A',true));
            archP.escribir(new Producto(222, 13.3,'F',true));
            archP.escribir(new Producto(125, 15.3,'C',true));
            archP.escribir(new Producto(333, 22.3,'L',true));
            archP.escribir(new Producto(131, 27.3,'A',true));
            archP.escribir(new Producto(141, 32.3,'A',true));
            archP.escribir(new Producto(511, 12.3,'L',true));
            archP.escribir(new Producto(711, 12.3,'A',true));
            archP.cerrar();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void alta2(){ // "pisaría" los tres primeros productos - Para agregar más productos sin sobrescribir los que ya existen, debo llevar el puntero al length del archivo. Para hacer eso java tiene un método llamado seek()
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            archP.escribir(new Producto(100, 13.3,'F',true));
            archP.escribir(new Producto(200, 15.3,'C',true));
            archP.escribir(new Producto(300, 22.3,'L',true));
            archP.cerrar();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // se agrega el fin() para que no se sobreescriban los registros
    public void alta3(){
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            archP.fin();
            archP.escribir(new Producto(100, 13.3,'F',true));
            archP.escribir(new Producto(200, 15.3,'C',true));
            archP.escribir(new Producto(300, 22.3,'L',true));
            archP.cerrar();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    */

    public void alta() {
        int codigo;
        String descripcion;
        double precio;
        char tipo;
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            archP.fin();
            System.out.println("Codigo: ");
            codigo = Integer.parseInt(lector.nextLine());
            while (codigo != 0) {
                System.out.println("Descripcion: ");
                descripcion = lector.nextLine();
                System.out.println("precio: ");
                precio = Double.parseDouble(lector.nextLine());
                System.out.println("Tipo: ");
                tipo = lector.nextLine().charAt(0);
                archP.escribir(new Producto(codigo, descripcion, precio, tipo, true));
                System.out.println("Codigo: ");
                codigo = Integer.parseInt(lector.nextLine());
            }
            archP.cerrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscar() {
        try {
            Producto p;
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            System.out.println("Codigo: ");
            int codigo = Integer.parseInt(lector.nextLine());
            p = archP.buscar(codigo);
            System.out.println(p.toString());
            archP.cerrar();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            System.out.println("Codigo: ");
            int codigo = Integer.parseInt(lector.nextLine());
            if (archP.eliminar(codigo))
                System.out.println("La eliminacion fue exitosa");
            else
                System.out.println("Código erroneo");
            archP.cerrar();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void compactar(){
        try{
            ArchivoProducto archP = new ArchivoProducto(nombreArchivo);
            ArchivoProducto archT = new ArchivoProducto("temporal");
            Producto p;
            long cant = archP.cantReg();
            for (long i = 0; i < cant ; i++){
                p = archP.leer();
                if(p.isActivo())
                    archT.escribir(p);
            // acá se puede mostar el nro de registro o una barra de progreso
            }
            archP.cerrar();
            archT.cerrar();
            archP.borrar();
            archT.renombrar(nombreArchivo);
        }
        catch (IOException e){
        }
    }

}
