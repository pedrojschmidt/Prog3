package SimulacroParcial;

import Listas.Campus.List;
import Listas.Campus.OrderedList;
import PilasYColas.Dinamicas.DynamicStack;
import PilasYColas.IsEmptyException;

import java.util.HashMap;

public class Mostrador {

    private OrderedList<Publicacion> publicaciones;
    private DynamicStack<Publicacion> publicacionesSinEjemplares;
    private List<Persona> personasConEjemplares;
    private Persona[] top5;

    public Mostrador(int cantidadDePublicaciones) {
        publicaciones = new OrderedList<>();
        for (int i = 0; i < cantidadDePublicaciones; i++) {
            publicaciones.add(new Publicacion(1 + (int) (15*Math.random()), i));
        }
        publicacionesSinEjemplares = new DynamicStack<>();
        personasConEjemplares = new List<>();
        top5 = new Persona[5];
    }

    public void atenderPersona() throws Exception {
        int random = (int) (10*Math.random());
        if (random < 5) {
            atenderPedido();
        }else{
            atenderDevolucion();
        }
    }

    public void atenderPedido() throws IsEmptyException {
        Persona persona = new Persona();
        Publicacion publicacion = (Publicacion) eleccionAleatoria(publicaciones);
        if (publicacion.getEjemplaresDisponibles() == 0) {
            publicacionesSinEjemplares.stack(publicacion);
        }else{
            personasConEjemplares.addAfter(persona);
            persona.obtenerEjemplar(publicacion.getPilaDeEjemplares().peek());
            publicacion.getPilaDeEjemplares().pop();
        }
    }

    private Object eleccionAleatoria(List lista){
        int indiceAleatorio = (int) (lista.size()*Math.random()); // elige una posicion al azar de la lista
        return eleccion(lista, indiceAleatorio);
    }

    private Object eleccion(List lista, int indice){
        lista.first(); // pone la ventana en la posicion cero de la lista
        for (int i = 0; i < indice; i++) { // si el indiceAleatorio es cero el for no se ejecuta
            lista.next();
        }
        return lista.peekCurrent(); // devuelve el T de la posicion seleccionada al azar
    }

    public void atenderDevolucion() throws Exception {
        if (personasConEjemplares.size() > 0) {
            Persona persona = (Persona) eleccionAleatoria(personasConEjemplares);
            personasConEjemplares.delete();
            int tiempoConElEjemplar = (int) ((System.currentTimeMillis() - persona.getHoraAlObtenerUnEjemplar()) / 1000) / 60;
            Ejemplar ejemplar = persona.devolverEjemplar();
            ejemplar.agregarTiempoDeUso(tiempoConElEjemplar);
            Publicacion publicacion = (Publicacion) eleccion(publicaciones, ejemplar.getNumeroDePublicacion());
            publicacion.getPilaDeEjemplares().stack(ejemplar);
            // falta guardar el DNI con el tiempo de uso del ejemplar
            /*for (int i = 0; i < 5; i++) {
                int a = top5[i].compareTo(persona);
                if (a == 0) {

                }
            }*/
        }
    }

    public void devolverTodosLosEjemplares() throws Exception {
        if (personasConEjemplares.size() > 0) {
            for (int i = 0; i < personasConEjemplares.size(); i++) {
                atenderDevolucion();
            }
        }
    }

    public void mostrarPublicacionesSinEjemplares() throws IsEmptyException {
        System.out.println("Publicaciones que no tenian ejemplares disponibles en el momento del pedido: ");
        for (int i = 0; i < publicacionesSinEjemplares.size(); i++) {
            System.out.println(" - " + publicacionesSinEjemplares.peek().getNombre());
            publicacionesSinEjemplares.pop();
        }
    }

    public void mostrar5DNIconMayorTiempo(){
        System.out.println("\n Top 5 DNI: ");
        for (int i = 0; i < 5; i++) {
            if (top5[i] != null) {
                System.out.println(" DNI: " + top5[i].getDni());
            }
        }
    }


    public void mostrarInfoDeEjemplaresPedidos() throws IsEmptyException {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Info de publicaciones: \n");
        publicaciones.first();
        for (int i = 0; i < publicaciones.size(); i++) {
            Publicacion publicacion = publicaciones.peekCurrent();
            System.out.println("    Nombre de la publicacion: " + publicacion.getNombre());
            DynamicStack<Ejemplar>  pila = publicacion.getPilaDeEjemplares();
            for (int j = 0; j < pila.size(); j++) {
                Ejemplar ejemplar = pila.peek();
                pila.pop();
                if (ejemplar.getTiempoDeUso() > 0) {
                    System.out.println("       Ejemplar " + ejemplar.getNumeroDeSerie() + ":        " + ejemplar.getTiempoDeUso()  + " minutos usado.");
                }
            }
            publicaciones.next();
        }
    }
}
