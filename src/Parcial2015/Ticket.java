package Parcial2015;

public class Ticket {

    int id;
    String party;

    public Ticket(String partyName) {
        id = (int) (Math.random()*(99999-10000)+10000);
        party = partyName;
    }

    public int getId() {
        return id;
    }

    public String getParty() {
        return party;
    }
}
