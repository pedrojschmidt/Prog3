package NumerosRomanos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Converter convertidor = new Converter();

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero romano del I al CMXCIX: ");
        String romanNumber = sc.next();

        System.out.println(romanNumber + " es igual a " + convertidor.convert(romanNumber));
    }
}
