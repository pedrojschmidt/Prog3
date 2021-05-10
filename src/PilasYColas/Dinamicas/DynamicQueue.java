package PilasYColas.Dinamicas;

import PilasYColas.IsEmptyException;
import PilasYColas.Node;
import PilasYColas.QueueInterface;

public class DynamicQueue <T> implements QueueInterface<T> {

    Node front, back;
    int size;

    public DynamicQueue() {
        front =  null;
        back =  null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (front == null) {
            front = new Node(element);
            back = front;
        }else{
            Node aux = new Node(element);
            back.next = aux;
            back = aux;
        }
        size += 1;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }
        T aux = (T) front.dato;
        front = front.next;
        size -= 1;
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }
    /*public DynamicQueue() {
        front =  new Node(null);
        back =  new Node(null);
        front.next = back;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (front.dato == null) {
            front.dato = element;
            back = front;
        }else{
            Node aux = new Node(element);
            back.next = aux;
            back = aux;
        }
        size += 1;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        }
        T aux = (T) front.dato;
        front = front.next;
        size -= 1;
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return front.dato == null;
    }

    @Override
    public int size() {
        return size;
    }*/
}
