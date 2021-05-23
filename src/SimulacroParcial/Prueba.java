package SimulacroParcial;

import Listas.Campus.List;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {

            long time = 0;

            boolean stop = false;
            Scanner sc = new Scanner(System.in);
            while (!stop){
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        time = System.currentTimeMillis();
                        break;
                    case 2:
                        System.out.println(((System.currentTimeMillis()-time)/1000)/60);
                        stop = true;
                        break;
                    default:
                        System.out.println("  !La opcion ingresada es inexistente!");
                        break;
                }
        }

    }
}
