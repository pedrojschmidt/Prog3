package PilasYColas.Estaticas;

import PilasYColas.IsEmptyException;
import PilasYColas.QueueInterface;

public class StaticQueue<T> implements QueueInterface<T> {

    private T[] data;
    private int front, back, size;

    public StaticQueue(){
        data = (T[]) new Object[10];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element){
        if (size < data.length) {
            back++;
            data[back] = element;
        }else{
            data = expandArray(data);
            size += 1;
        }
    }

    private T[] expandArray(T[] data){
        T[] extendedData = (T[]) new Object[data.length+10];
        for (int i=0; i < data.length; i++) {
            T aux = dequeueAux(data);
            extendedData[i] = aux;
        }
        return extendedData;
    }

 /*   @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException("La cola está vacía.");
        }
        T aux = data[front];
        if (front < data.length-1){
            front += 1;
        }else{
            front = 0;
        }
        return aux;
    }*/

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }
        return dequeueAux(data);
    }

    private T dequeueAux(T[] data){
        T aux = data[front];
        if (front < data.length-1){
            front += 1;
        }else{
            front = 0;
        }
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
