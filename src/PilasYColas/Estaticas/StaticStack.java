package PilasYColas.Estaticas;

import PilasYColas.IsEmptyException;
import PilasYColas.StackInterface;

public class StaticStack<T> implements StackInterface<T> {  //implementacion estatica

    T[] data;
    int size;

    public StaticStack() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public void stack(T element){ //push
        if (data[data.length-1] == null) {
            data[size] = element;
            size++;
        }
        else if (data[data.length-1] != null) {
            data = expandArray(data);
            data[data.length-10] = element;
            size++;
        }
    }

    private T[] expandArray(T[] data){
        T[] extendedData = (T[]) new Object[data.length+10];
        for (int i = 0; i < data.length; i++) {
            extendedData[i] = data[i];
        }
        return extendedData;
    }

    public int size(){
        return size;
    }

    public void pop() throws IsEmptyException {
        if (size > 0) {
            size--;
        }else{
            throw new IsEmptyException();
        }

    }

    public T peek(){
        if (size > 0) {
            return data[size-1];
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void empty() {
        size = 0;
    }
}
