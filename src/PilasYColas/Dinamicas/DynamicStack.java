package PilasYColas.Dinamicas;

import PilasYColas.IsEmptyException;
import PilasYColas.Node;
import PilasYColas.StackInterface;

public class DynamicStack <T> implements StackInterface<T> {

    Node top;
    int size;

    public DynamicStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T peek() {
        return (T) top.dato;
    }

    @Override
    public void pop() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        } else if (size > 1){
            top = top.next;
        }else{
            top = null;
        }
        size -= 1;
    }

    @Override
    public void stack(T element) {
        Node aux = new Node(element);
        aux.next = top;
        top = aux;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        top = null;
        size = 0;
    }
}
