package Parcial2015;

import PilasYColas.Dinamicas.DynamicQueue;
import PilasYColas.Dinamicas.DynamicStack;
import PilasYColas.IsEmptyException;

public class Table {

    private DarkRoom darkroom;
    private DynamicQueue<Person> persons;
    private DynamicStack<Integer> queueTimes, darkroomTimes;
    private DynamicStack<Ticket> urna;

    public Table() {
        darkroom = new DarkRoom();
        persons = new DynamicQueue<>();
        queueTimes = new DynamicStack();
        darkroomTimes = new DynamicStack<>();
        urna = new DynamicStack<>();
    }

    public void refillTickets(){
        darkroom.refillTickets();
    }

    public void personArrives() {
        Person person = new Person();
        person.setArrivalTime(System.currentTimeMillis());
        persons.enqueue(person);
    }

    public void personIntoDarkroom() throws Exception {
        if (persons.size() == 0) {
            System.out.println("\nNo hay personas en la cola.");
        }else if (darkroom.getPersonInside() == null) {
            Person person = persons.dequeue();
            person.setIntoDarkroomTime(System.currentTimeMillis());
            person.calculateTimeInQueue();
            queueTimes.stack(person.getTimeInQueueSeconds());
            darkroom.letPersonIn(person);
        }else{
            System.out.println("\nEl cuarto oscuro está ocupado.");
        }
    }

    public void personOutOfDarkroom() {
        if (darkroom.getPersonInside() != null) {
            Person person = darkroom.getPersonInside();
            person.calculateTimeInDarkroom();
            darkroomTimes.stack(person.getTimeInDarkroomSeconds());
            darkroom.letPersonOut();
            urna.stack(person.getTicket());
        }else{
            System.out.println("\nNo hay nadie dentro del cuarto oscuro.");
        }
    }

    public void showAverageWaitingTime() throws IsEmptyException {
        int n = queueTimes.size(); // MUY IMPORTANTE DEJAR GUARDADO EL SIZE FUERA DE LA DECLARACION DEL FOR PORQUE DESPUES EL SIZE VA DISMINUYENDO
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += queueTimes.peek();
            queueTimes.pop();
        }
        System.out.println("\nTiempo de espera promedio en la fila: " + (sum/n) + " segundos");
    }

    public void showWinningParty() {
        darkroom.showWinningParty();
    }

    public void showLast10Tickets() throws IsEmptyException {
        DynamicStack<Ticket> urnaAux = urna;
        System.out.println("\nUltimas 10 boletas: ");
        int amount = 10;
        if (urna.size() < 10) {
            amount = urnaAux.size();
        }
        for (int i = 0; i < amount; i++) {
            System.out.println("    Partido: " + urnaAux.peek().getParty() + "          Nro de boleta: " + urnaAux.peek().getId());
            urnaAux.pop();
        }
    }

    public void showAverageTimeInsideDarkroom() throws IsEmptyException {
        int n = darkroomTimes.size(); // MUY IMPORTANTE DEJAR GUARDADO EL SIZE FUERA DE LA DECLARACION DEL FOR PORQUE DESPUES EL SIZE VA DISMINUYENDO
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += darkroomTimes.peek();
            darkroomTimes.pop();
        }
        System.out.println("\nTiempo de espera promedio en el cuarto oscuro: " + (sum/n) + " segundos");
    }
}
