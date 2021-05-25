package SimulacroParcial;

import PilasYColas.IsEmptyException;

import java.util.Scanner;

public class Simulacion {

    static Mostrador mostrador;

    public static void main(String[] args) throws Exception {
        int amount = 20 + (int) (10*Math.random()); //20 + (int) (4981*Math.random())
        mostrador = new Mostrador(amount);

        System.out.println(amount);

        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        while (!stop){
            System.out.println("********************************");
            System.out.println("          Hemeroteca");
            System.out.println("********************************");
            System.out.println("Opciones: \n");
            System.out.println(" 1- Atender pedido o devolucion");
            System.out.println(" 2- Terminar simulacion");
            System.out.println("\n Ingrese una opcion: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    mostrador.atenderPersona();
                    break;
                case 2:
                    mostrador.devolverTodosLosEjemplares();
                    mostrador.mostrarPublicacionesSinEjemplares();
                    mostrador.mostrar5DNIconMayorTiempo();
                    mostrador.mostrarInfoDeEjemplaresPedidos();
                    stop = true;
                    break;
                default:
                    System.out.println("  !La opcion ingresada es inexistente!");
                    break;
            }

        }
    }

}
