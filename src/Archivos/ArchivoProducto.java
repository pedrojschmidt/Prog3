package Archivos;

import java.io.*;

public class ArchivoProducto {

    private File f;
    private RandomAccessFile raf;
    private int sizeReg = 15;

    public ArchivoProducto(String nombre)throws FileNotFoundException {
        f = new File(nombre);
        raf = new RandomAccessFile(f,"rw");

    }

    public void cerrar()  throws IOException {
        raf.close();
    }

    // Para saber la cantidad de registros
    public long cantReg() throws IOException {
        return raf.length()/sizeReg;
    }

    // posiciona el puntero en la primera posicion
    public void inicio() throws IOException{
        raf.seek(0);
    }

    // posiciona el puntero en la ultima posicion
    public void fin() throws IOException{
        raf.seek(raf.length());
    }

    // busqueda secuencial
    public Producto buscar (int codigo) throws Exception{
        long cant = cantReg();
        inicio(); // se pone el puntero al inicio del archivo
        Producto p;
        for (int i =0 ; i < cant;i++){
            p = leer();
            if(p.isActivo() && (p.getCodigo()==codigo))
                return p;
        }
        throw new Exception("Código erróneo");
    }

    public boolean eliminar(int codigo) throws IOException{
        try{
            Producto p = buscar(codigo);
            raf.seek(raf.getFilePointer()-sizeReg); // mueve el puntero al inicio del registro anterior
            p.setActivo(false);
            escribir(p);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void borrar() throws IOException {
        f.delete();
    }

    public void renombrar(String nombre) throws IOException {
        File file = new File (nombre);
        f.renameTo(file);
    }

    public void escribir(Producto p)  throws IOException {
        raf.writeInt(p.getCodigo());
        raf.writeUTF(p.getDescripcion());
        raf.writeDouble(p.getPrecio());
        raf.writeChar(p.getTipo());
        raf.writeBoolean(p.isActivo());
    }

    // Leer el Producto - Notar que está en el mismo orden en el que se escribió
    public Producto leer() throws IOException{
        return new Producto(raf.readInt(), raf.readUTF(), raf.readDouble(), raf.readChar(),raf.readBoolean());
    }
}
