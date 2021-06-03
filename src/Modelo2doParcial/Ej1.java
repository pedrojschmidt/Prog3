package Modelo2doParcial;

/*
Por cada provincia se dispone de un número de provincia
(1: Buenos Aires, 2: Santa Fe, etc.) y de 12 cifras de lluvias mensuales.
Se recibe un archivo RandomAccesFile con dicha información.
Cada registro del archivo contiene el número de la provincia
y los 12 números que corresponden a las lluvias mensuales.
Escribir una aplicación que muestre un listado de las provincias
en orden de la cantidad de lluvia total anual de la más baja a la más alta.
 */

import Listas.Campus.OrderedList;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class Ej1 {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Pedro\\Desktop\\Folder\\Austral\\Java\\Lluvias.txt");
        RandomAccessFile raf = writeFile(new RandomAccessFile(file, "rw"));
        HashMap<Integer, String> hashMap = fillHashmap(new HashMap());
        OrderedList<Provincia> list = new OrderedList<>();

        raf.seek(0);

        for (int i = 1; i < 24; i++) {
            int numeroDeProv = raf.readInt();
            int lluvias = 0;
            for (int j = 0; j < 12; j++) {
                lluvias += raf.readInt();
            }
            list.add(new Provincia(hashMap.get(numeroDeProv), lluvias));
        }
        printList(list);
    }

    public static RandomAccessFile writeFile(RandomAccessFile raf) throws IOException {
        for (int i = 1; i < 24; i++) {
            raf.writeInt(i);
            for (int j = 1; j < 13; j++) {
                raf.writeInt(i+j);
            }
        }
        return raf;
    }

    public static void printList(OrderedList list){
        list.first();
        for (int i = 0; i < list.size(); i++) {
            Provincia provincia = (Provincia)list.peekCurrent();
            System.out.println(provincia.getNombre() + "                          Lluvias: " + provincia.getSumaDeLluvias());
            list.next();
        }
    }

    public static HashMap<Integer, String> fillHashmap(HashMap<Integer, String> hashMap){
        hashMap.put(1, "Buenos Aires");
        hashMap.put(2, "Catamarca");
        hashMap.put(3, "Chaco");
        hashMap.put(4, "Chubut");
        hashMap.put(5, "Córdoba");
        hashMap.put(6, "Corrientes");
        hashMap.put(7, "Entre Ríos");
        hashMap.put(8, "Formosa");
        hashMap.put(9, "Jujuy");
        hashMap.put(10, "La Pampa");
        hashMap.put(11, "La Rioja");
        hashMap.put(12, "Mendoza");
        hashMap.put(13, "Misiones");
        hashMap.put(14, "Neuquén");
        hashMap.put(15, "Río Negro");
        hashMap.put(16, "Salta");
        hashMap.put(17, "San Juan");
        hashMap.put(18, "San Luis");
        hashMap.put(19, "Santa Cruz");
        hashMap.put(20, "Santa Fe");
        hashMap.put(21, "Santiago del Estero");
        hashMap.put(22, "Tierra del Fuego");
        hashMap.put(23, "Tucumán");
        return hashMap;
    }
}
