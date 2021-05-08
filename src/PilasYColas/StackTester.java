package PilasYColas;

import PilasYColas.Estaticas.StaticStack;

import java.util.Scanner;

/**
 * Created by Ignacio on 29/4/16.
 */

public class StackTester {
    public static void main(String[] Args) throws IsEmptyException {

        StaticStack<String> mystack = new StaticStack<>();

        mystack.stack("hola");
        int option=0;
        Scanner scanner = new Scanner(System.in);

        while(option!=4){
            System.out.println("Stack tester");
            System.out.println("1. Press 1 to add a value to the stack");
            System.out.println("1. Press 2 to show the top value of the stack");
            System.out.println("1. Press 3 to remove the top value of the stack");
            System.out.println("1. Press 4 to exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el valor que quiere agregar: ");
                    String str = scanner.next();
                    mystack.stack(str);
                    break;
                case 2:
                    System.out.println("El valor del tope es: " + mystack.peek());
                    break;
                case 3:
                    System.out.println("tope: " + mystack.peek());
                    mystack.pop();
                    System.out.println("nuevo tope: " + mystack.peek());
                    break;

            }
        }

    }
}
