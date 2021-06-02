package Parcial2015;

public class Person {

    private Ticket ticket;
    private long arrivalTime, intoDarkroomTime;
    private int timeInQueueSeconds, timeInDarkroomSeconds;

    public Person() {
        ticket = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void calculateTimeInQueue() {
        timeInQueueSeconds = (int) ((System.currentTimeMillis() - arrivalTime)/1000);
    }

    public void calculateTimeInDarkroom() {
        timeInDarkroomSeconds = (int) ((System.currentTimeMillis() - intoDarkroomTime)/1000);
    }

    public void setIntoDarkroomTime(long intoDarkroomTime) {
        this.intoDarkroomTime = intoDarkroomTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getIntoDarkroomTime() {
        return intoDarkroomTime;
    }

    public int getTimeInQueueSeconds() {
        return timeInQueueSeconds;
    }

    public int getTimeInDarkroomSeconds() {
        return timeInDarkroomSeconds;
    }
}
