package utils;

public class DoubleNode<T> {
    public T dato;
    public DoubleNode<T> left, right;

    public DoubleNode(){

    }

    public DoubleNode(T element) {
        dato = element;
    }

    public DoubleNode(T element, DoubleNode<T> left, DoubleNode<T> right) {
        dato = element;
        this.right = right;
        this.left = left;
    }

    public T getDato() {
        return dato;
    }

    public DoubleNode<T> getLeft() {
        return left;
    }

    public DoubleNode<T> getRight() {
        return right;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}