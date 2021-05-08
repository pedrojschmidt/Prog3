package NumerosRomanos;

import java.util.Scanner;

public class Ej4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("escriba un numero romano: ");
        int a = sc.nextInt();
        System.out.println(toRomans(a));
    }

    public static String toRomans(int a){

        String numFinal="";

        while(a!=0){
            String numI= ""+ a;

            if (a>=100){
                int cen = Integer.parseInt(String.valueOf(numI.charAt(0)));
                switch (cen){
                    case 1:
                        numFinal+="C";
                        a-=100;
                        break;
                    case 2:
                        numFinal+="CC";
                        a-=200;
                        break;
                    case 3:
                        numFinal+= "CCC";
                        a-=300;
                        break;
                    case 4:
                        numFinal+= "CD";
                        a-=400;
                        break;
                    case 5:
                        numFinal+="D";
                        a-=500;
                        break;
                    case 6:
                        numFinal+="DC";
                        a-= 600;
                        break;
                    case 7:
                        numFinal+="DCC";
                        a-= 700;
                        break;
                    case 8:
                        numFinal+="DCCC";
                        a-= 800;
                        break;
                    case 9:
                        numFinal+="CM";
                        a-= 900;
                        break;
                }
                numI = "" + a;
            }
            if (a<100&&a>=10){
                int ten = Integer.parseInt(String.valueOf(numI.charAt(0)));
                switch (ten){

                    case 1:
                        numFinal+="X";
                        a-=10;
                        break;
                    case 2:
                        numFinal+="XX";
                        a-=20;
                        break;
                    case 3:
                        numFinal+= "XXX";
                        a-=30;
                        break;
                    case 4:
                        numFinal+= "XL";
                        a-=40;
                        break;
                    case 5:
                        numFinal+="L";
                        a-=50;
                        break;
                    case 6:
                        numFinal+="LX";
                        a-= 60;
                        break;
                    case 7:
                        numFinal+="LXX";
                        a-= 70;
                        break;
                    case 8:
                        numFinal+="LXXX";
                        a-= 80;
                        break;
                    case 9:
                        numFinal+="XC";
                        a-= 90;
                        break;
                }
                numI = "" + a;
            }
            if (a<10){
                int one = Integer.parseInt(String.valueOf(numI.charAt(0)));
                switch (one){

                    case 1:
                        numFinal+="I";
                        a-=1;
                        break;
                    case 2:
                        numFinal+="II";
                        a-=2;
                        break;
                    case 3:
                        numFinal+= "III";
                        a-=3;
                        break;
                    case 4:
                        numFinal+= "IV";
                        a-=4;
                        break;
                    case 5:
                        numFinal+="V";
                        a-=5;
                        break;
                    case 6:
                        numFinal+="VI";
                        a-= 6;
                        break;
                    case 7:
                        numFinal+="VII";
                        a-= 7;
                        break;
                    case 8:
                        numFinal+="VIII";
                        a-= 8;
                        break;
                    case 9:
                        numFinal+="IX";
                        a-= 9;
                        break;
                }
                numI = "" + a;
            }


        }
        return numFinal;
    }

}

