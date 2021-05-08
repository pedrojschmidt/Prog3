package NumerosRomanos;

import java.util.Scanner;

public class Ej4d {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String number = s.next();


        if(number.length()==1 && Integer.parseInt(number)!=0){
            System.out.println(assignRoman(number.substring(0), 3));
        }else if(number.length()==2){
            System.out.println(assignRoman(number.substring(0,1), 2)+ assignRoman(number.substring(1), 3));
        }else{
            System.out.println(assignRoman(number.substring(0,1), 1)+ assignRoman(number.substring(1,2), 2)+ assignRoman(number.substring(2), 3));
        }
    }

    private static String assignRoman(String substring, int i) {
        String result = "";
        String car1 = "";
        String car2 = "";
        String car3 = "";
        switch (i){
            case 1:
                car1 = "C";
                car2 = "D";
                car3 = "M";
                break;
            case 2:
                car1 = "X";
                car2 = "L";
                car3 = "C";
                break;
            case 3:
                car1 = "I";
                car2 = "V";
                car3 = "X";
                break;
        }

        switch (Integer.parseInt(substring)){
            case 1:
                result = car1;
                break;
            case 2:
                result = car1+car1;
                break;
            case 3:
                result = car1+car1+car1;
                break;
            case 4:
                result = car1+car2;
                break;
            case 5:
                result = car2;
                break;
            case 6:
                result = car2+car1;
                break;
            case 7:
                result = car2+car1+car1;
                break;
            case 8:
                result = car2+car1+car1+car1;
                break;
            case 9:
                result = car1+car3;
                break;
        }
        return result;
    }

}

