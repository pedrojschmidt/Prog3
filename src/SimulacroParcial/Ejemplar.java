package SimulacroParcial;

public class Ejemplar {

    private int numeroDeSerie;
    private boolean disponible;
    private int tiempoDeUso;
    private int numeroDePublicacion;

    public Ejemplar(int numeroDePublicacion) {
        numeroDeSerie = (int) (100 + 899*Math.random());
        disponible = true;
        this.numeroDePublicacion = numeroDePublicacion;
        tiempoDeUso = 0;
    }

    public void modificarDisponibilidad(boolean b){
        setDisponible(b);
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void agregarTiempoDeUso(int minutos){
        tiempoDeUso += minutos;
    }

    public int getNumeroDePublicacion() {
        return numeroDePublicacion;
    }

    public int getTiempoDeUso() {
        return tiempoDeUso;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }
}
