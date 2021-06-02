package Modelo2doParcial;

public class Provincia implements Comparable<Provincia> {

    private String nombre;
    private int sumaDeLluvias;

    public Provincia(String nombre, int sumaDeLluvias) {
        this.nombre = nombre;
        this.sumaDeLluvias = sumaDeLluvias;
    }

    public int getSumaDeLluvias() {
        return sumaDeLluvias;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Provincia o) {
        if (sumaDeLluvias <= o.getSumaDeLluvias()) {
            return 1;
        }else{
            return -1;
        }
    }
}
