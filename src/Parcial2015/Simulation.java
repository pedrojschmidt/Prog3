package Parcial2015;

import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Table table = new Table();

        boolean stop = false;
        while (!stop){
            System.out.println("\n********************************");
            System.out.println("        Mesas Electorales");
            System.out.println("********************************");
            System.out.println("Opciones: ");
            System.out.println(" 1- Ingresar persona a la mesa");
            System.out.println(" 2- Ingresar persona al cuarto oscuro");
            System.out.println(" 3- Sacar persona del cuarto oscuro");
            System.out.println(" 4- Reponer boletas");
            System.out.println(" 5- Finalizar simulacion");
            System.out.println("\n Ingrese una opcion: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    table.personArrives();
                    break;
                case 2:
                    table.personIntoDarkroom();
                    break;
                case 3:
                    table.personOutOfDarkroom();
                    break;
                case 4:
                    table.refillTickets();
                    break;
                case 5:
                    table.showAverageWaitingTime();
                    table.showWinningParty();
                    table.showLast10Tickets();
                    table.showAverageTimeInsideDarkroom();
                    stop = true;
                    break;
                default:
                    System.out.println("  !La opcion ingresada es inexistente!");
                    break;
            }
        }
    }
}
