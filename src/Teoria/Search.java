package Teoria;

public class Search {

    //Busca en un conjunto, no necesariamente ordenado, de numeros enteros
    public boolean SeqSearch(int a[], int k) {
        for (int i = 0; i < a.length; i++) {
            if(k == a[i]){
                return true;
            }
        }
        return false;
    }

    //busqueda en un conjunto ordenado de numeros enteros
    public boolean BinarySearch(int a[], int k){
        int min = 0;
        int max = a.length - 1;
        int middle = (min+max)/2;

        while (min <= max){
            if (k == a[middle]) {
                return true;
            } else if (k < a[middle]) {
                max = middle - 1;
            }else{
                min = middle + 1;
                middle = (min+max)/2;
            }
        }
        return false;
    }

    //Problema similar con un conjunto de palabras
    public boolean StringSeqSearch(String a[], String k){
        for (int i = 0; i < a.length; i++) {
            if (k.compareTo(a[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    //Problema similar con un conjunto de palabras
    public boolean StringBinarySearch(String a[], String k){
        int min = 0;
        int max = a.length - 1;
        int middle = (min+max)/2;

        while (min <= max){
            if (k.compareTo(a[middle]) == 0) {
                return true;
            } else if (k.compareTo(a[middle]) < 0) {
                max = middle - 1;
            }else{
                min = middle + 1;
                middle = (min+max)/2;
            }
        }
        return false;
    }

    //Lo mismo en GENERICS
    public <T> boolean BinarySearch(Comparable<T> a[], Comparable<T> k){
        int min = 0;
        int max = a.length - 1;
        int middle = (min+max)/2;

        while (min <= max){
            if (k.compareTo((T)a[middle]) == 0) {
                return true;
            } else if (k.compareTo((T)a[middle]) < 0) {
                max = middle - 1;
            }else{
                min = middle + 1;
                middle = (min+max)/2;
            }
        }
        return false;
    }
}
