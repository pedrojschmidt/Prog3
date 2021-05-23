package SimulacroParcial;

import PilasYColas.Dinamicas.DynamicStack;

public class Publicacion implements Comparable<Publicacion> {

    private DynamicStack<Ejemplar> pilaDeEjemplares;
    private String nombre;
    private int numeroDePublicacion;

    public Publicacion(int cantidadDeEjemplares, int numeroDePublicacion) {
        this.nombre = NewNombre();
        pilaDeEjemplares = new DynamicStack<>();
        for (int i = 0; i < cantidadDeEjemplares; i++) {
            pilaDeEjemplares.stack(new Ejemplar(numeroDePublicacion));
        }
        this.numeroDePublicacion = numeroDePublicacion;
    }

    public int getEjemplaresDisponibles() {
        return pilaDeEjemplares.size();
    }

    public DynamicStack<Ejemplar> getPilaDeEjemplares() {
        return pilaDeEjemplares;
    }

    public String getNombre() {
        return nombre;
    }

    public static String NewNombre(){
        return "aaaa";
    }

    @Override
    public int compareTo(Publicacion o) {
        if (o.getNombre().compareTo(nombre) == 1) {
            return 1;
        }
        return 0;
    }
}
