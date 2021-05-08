package Teoria;

public class ComparableEjemplo implements Comparable<ComparableEjemplo>{

    private String modelo;
    private String patente;
    private String color;
    private int año;

    public ComparableEjemplo(String modelo,String patente, String color, int año) {
        this.modelo = modelo;
        this.patente = patente;
        this.color = color;
        this.año = año;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPatente() {
        return patente;
    }

    public String getColor() {
        return color;
    }

    public int getAño() {
        return año;
    }

    @Override
    public int compareTo(ComparableEjemplo auto2) {
        return this.año- auto2.getAño();
    }
}
