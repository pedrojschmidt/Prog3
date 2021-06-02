package Archivos;

public class Utilidades {
    public static String convertir(String s, int cant){
        String r = s;
        if (s.length()> cant)
            r = s.substring(0, cant);
        else
            for (int i = s.length(); i < cant; i++)
                r = r + " ";
        return r;
    }
}

