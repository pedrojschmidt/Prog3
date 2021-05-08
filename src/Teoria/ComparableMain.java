package Teoria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparableMain {

    public static void main(String[] args) {

        ComparableEjemplo corvette = new ComparableEjemplo("Corvette", "AA111AA", "azul", 2021);
        ComparableEjemplo corvette2 = new ComparableEjemplo("Corvette", "AA111AA", "azul", 2020);
        ComparableEjemplo f488gtb = new ComparableEjemplo("458 gtb", "AA111AA", "azul", 2021);
        ComparableEjemplo f488gtb2 = new ComparableEjemplo("458 gtb", "AA111AB", "azul", 2019);
        ComparableEjemplo f488gtb3 = new ComparableEjemplo("458 gtb", "AA111AA", "rojo", 2021);

        ArrayList<ComparableEjemplo> arr = new ArrayList<>();
        arr.add(corvette);
        arr.add(corvette2);
        arr.add(f488gtb);
        arr.add(f488gtb2);
        arr.add(f488gtb3);
/*
        int a = corvette.compareTo(corvette2);
        int b = corvette.compareTo(f488gtb);
        int c = corvette.compareTo(f488gtb2);
        int d = f488gtb.compareTo(f488gtb);
        int e = f488gtb.compareTo(f488gtb2);
        int f = f488gtb.compareTo(f488gtb3);
        int g = f488gtb2.compareTo(f488gtb3);*/


        for (int i = 0; i < 5; i++) {
            System.out.println(arr.get(i).getModelo() + arr.get(i).getAño());
        }

        System.out.println("");

        Collections.sort(arr);

        for (int i = 0; i < 5; i++) {
            System.out.println(arr.get(i).getModelo() + arr.get(i).getAño());
        }

    }
}
