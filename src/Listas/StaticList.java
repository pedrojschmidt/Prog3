package Listas;

public class StaticList<T> implements GeneralList<T>{

    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int window;
    private int size;
    private final int capacity;

    public StaticList(int capacity) {
        data = (T[]) new Object[capacity];
        window = 0;
        size = 0;
        this.capacity = capacity;
    }

    private StaticList(int window, int size, int capacity, Object[] data) {
        this.data = (T[]) data;
        this.window = window;
        this.size = size;
        this.capacity = capacity;
    }


    @Override
    public void remove() {
        data[window] = null;
    }

    @Override
    public void goNext() {

    }

    @Override
    public void goPrevious() {

    }

    @Override
    public void goTo(int n) {

    }

    @Override
    public T getActual() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isVoid() {
        return false;
    }

    @Override
    public boolean endList() {
        return false;
    }

    @Override
    public GeneralList<T> clone() {
        return null;
    }
}
