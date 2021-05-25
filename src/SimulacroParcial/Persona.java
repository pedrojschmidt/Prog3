package SimulacroParcial;

public class Persona implements Comparable<Persona>{

    private String dni;
    private boolean tieneEjemplar; //funciona tambien para saber si tiene el DNI
    private Ejemplar ejemplarObtenido;
    private long horaAlObtenerUnEjemplar;

    public Persona() {
        int dniAux = (int) (10000000 + 30000000*Math.random());
        dni = String.valueOf(dniAux);
        ejemplarObtenido = null;
        tieneEjemplar = false;
    }

    public void obtenerEjemplar(Ejemplar ejemplar){
        ejemplarObtenido = ejemplar;
        horaAlObtenerUnEjemplar = System.currentTimeMillis();
        ejemplar.setDisponible(false);
        tieneEjemplar = true;
    }

    public Ejemplar devolverEjemplar() throws Exception {
        if (tieneEjemplar) {
            Ejemplar aux = ejemplarObtenido;
            ejemplarObtenido = null;
            return aux;
        }else {
            throw new Exception("No tiene ningun ejemplar");
        }
    }

    public Ejemplar getEjemplarObtenido() {
        return ejemplarObtenido;
    }

    public long getHoraAlObtenerUnEjemplar(){
        return horaAlObtenerUnEjemplar;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public int compareTo(Persona o) {
        /*if () {
        }*/
        return 0;
    }
}
