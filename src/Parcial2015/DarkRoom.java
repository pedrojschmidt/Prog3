package Parcial2015;

import PilasYColas.Dinamicas.DynamicStack;
import PilasYColas.IsEmptyException;

public class DarkRoom {

    DynamicStack<Ticket>[] stacks;
    private final int AMOUNT_OF_PARTIES = 5;
    private final int CAPACITY_OF_STACKS = 300;
    Person personInside;
    private int[] ticketsPerParty;

    public DarkRoom() {
        stacks = new DynamicStack[AMOUNT_OF_PARTIES];
        initializeStacks();
        personInside = null;
        ticketsPerParty = new int[AMOUNT_OF_PARTIES];
    }

    private void initializeStacks(){
        for (int i = 0; i < AMOUNT_OF_PARTIES; i++) {
            stacks[i] = new DynamicStack<>();
            for (int j = 0; j < CAPACITY_OF_STACKS; j++) {
                stacks[i].stack(new Ticket("Partido" + (i+1)));
            }
        }
    }

    public void refillTickets(){
        if (personInside == null) {
            int[] array = new int[AMOUNT_OF_PARTIES];
            for (int i = 0; i < AMOUNT_OF_PARTIES; i++) {
                int remainingAmount = stacks[i].size();
                array[i] = CAPACITY_OF_STACKS-remainingAmount;
                for (int j = 0; j < (CAPACITY_OF_STACKS-remainingAmount); j++) {
                    String partyName = stacks[i].peek().getParty();
                    stacks[i].stack(new Ticket(partyName));
                }
            }
            showRefilledTickets(array);
        }else{
            System.out.println("\nNo se puede rellenar las boletas porque hay una persona en el cuarto oscuro.");
        }
    }

    private void showRefilledTickets(int[] array){
        for (int i = 0; i < AMOUNT_OF_PARTIES; i++) {
            System.out.println(array[i] + " boletas del " + stacks[i].peek().getParty() + " agregadas.");
        }
    }

    public void letPersonIn(Person person) throws Exception {
        personInside = person;
        person.setTicket(chooseTicket(0));
    }

    private Ticket chooseTicket(int counter) throws Exception {
        int randomIndex = (int) (Math.random()*AMOUNT_OF_PARTIES);
        if(counter <= 10) {
            if (stacks[randomIndex].size() != 0) {
                Ticket ticket = stacks[randomIndex].peek();
                stacks[randomIndex].pop();
                return ticket;
            } else {
                return chooseTicket(counter + 1);
            }
        }else{
            throw new Exception("No quedan boletas.");
        }
    }

    public Person letPersonOut(){
        Person person = personInside;
        personInside = null;
        return person;
    }

    public DynamicStack<Ticket>[] getStacks() {
        return stacks;
    }

    public Person getPersonInside() {
        return personInside;
    }

    public void showWinningParty() {

    }
}
