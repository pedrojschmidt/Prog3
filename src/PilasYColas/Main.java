package PilasYColas;

import PilasYColas.Estaticas.StaticQueue;

public class Main {

    public static void main(String[] args) throws IsEmptyException {

        StaticQueue<Integer> cola = new StaticQueue<>();

        System.out.println("\n" + cola.size() + "\n");

        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        cola.enqueue(6);
        cola.enqueue(7);
        cola.enqueue(8);
        cola.enqueue(9);
        cola.enqueue(10);
        cola.enqueue(11);
        cola.enqueue(12);
        cola.enqueue(13);
        cola.enqueue(14);
        cola.enqueue(15);
        cola.enqueue(16);
        cola.enqueue(17);
        cola.enqueue(18);
        cola.enqueue(19);
        cola.enqueue(20);

        cola.enqueue(21);
        cola.enqueue(22);
        cola.enqueue(23);
        cola.enqueue(24);
        cola.enqueue(25);
        cola.enqueue(26);
        cola.enqueue(27);
        cola.enqueue(28);
        cola.enqueue(29);
        cola.enqueue(30);
        System.out.println("\n" + cola.size() + "\n");
       // System.out.println(cola.size());

        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());

        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());

        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());

       // System.out.println(cola.size());

        /*
        DynamicQueue<Integer> cola = new DynamicQueue<>();

        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);


        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());*/
        System.out.println("\n" + cola.size() + "\n");
    }
}
