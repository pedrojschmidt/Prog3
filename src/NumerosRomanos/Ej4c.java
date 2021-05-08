package NumerosRomanos;

import java.util.Scanner;

public class Ej4c {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Ingrese un número");
        int n = myScanner.nextInt();
        while(n >= 1000 || n <= 0) {
            System.out.println("El número debe estar entre 1 y 999. Por favor, ingrese otro númerohgf");
            n = myScanner.nextInt();
        }
        System.out.println("El número " + n + " en romano es:\t" + toRomanNumber(n));

    }

    private static String toRomanNumber(int n) {

        String hundredsInRoman, tensInRoman, unitsInRoman;

        int hundreds = n/100;
        int tens = (n - hundreds*100)/10;
        int units = (n - hundreds*100 - tens*10);

        switch (hundreds) {
            case 1 :
                hundredsInRoman = "C";
                break;
            case 2 :
                hundredsInRoman = "CC";
                break;
            case 3 :
                hundredsInRoman = "CCC";
                break;
            case 4 :
                hundredsInRoman = "CD";
                break;
            case 5 :
                hundredsInRoman = "D";
                break;
            case 6 :
                hundredsInRoman = "DC";
                break;
            case 7 :
                hundredsInRoman = "DCC";
                break;
            case 8 :
                hundredsInRoman = "DCCC";
                break;
            case 9 :
                hundredsInRoman = "CM";
                break;
            default :
                hundredsInRoman = "";
        }

        switch (tens) {
            case 1 :
                tensInRoman = "X";
                break;
            case 2 :
                tensInRoman = "XX";
                break;
            case 3 :
                tensInRoman = "XXX";
                break;
            case 4 :
                tensInRoman = "XL";
                break;
            case 5 :
                tensInRoman = "L";
                break;
            case 6 :
                tensInRoman = "LX";
                break;
            case 7 :
                tensInRoman = "LXX";
                break;
            case 8 :
                tensInRoman = "LXXX";
                break;
            case 9 :
                tensInRoman = "XC";
                break;
            default :
                tensInRoman = "";
        }

        switch (units) {
            case 1 :
                unitsInRoman = "I";
                break;
            case 2 :
                unitsInRoman = "II";
                break;
            case 3 :
                unitsInRoman = "III";
                break;
            case 4 :
                unitsInRoman = "IV";
                break;
            case 5 :
                unitsInRoman = "V";
                break;
            case 6 :
                unitsInRoman = "VI";
                break;
            case 7 :
                unitsInRoman = "VII";
                break;
            case 8 :
                unitsInRoman = "VIII";
                break;
            case 9 :
                unitsInRoman = "IX";
                break;
            default :
                unitsInRoman = "";
        }

        return hundredsInRoman + tensInRoman + unitsInRoman;

    }

}
