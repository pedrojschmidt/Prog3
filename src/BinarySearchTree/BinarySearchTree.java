package BinarySearchTree;

import utils.DoubleNode;

public class BinarySearchTree<T> {
    // Implementacion de un arbol binario de busqueda no balanceado
    // Autor Alicia Gioia

    private DoubleNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    // CREADO POR NOSOTROS
    public DoubleNode<T> getRealRoot(){
        return root;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable<T> x) {
        if (!exists(x)) {
            root = insert(root, x);
        } else {
            throw new RuntimeException("El elemento a insertar no debe pertenecer al árbol");
        }
    }


    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable<T> x) {
        if (exists(x)) {
            root = delete(root, x);
        } else {
            throw new RuntimeException("El elemento a eliminar debe pertenece al árbol");
        }
    }

    // precondicion: árbol distinto de vacío
    public T getMin() {
        if (!isEmpty()) {
            return getMin(root).dato;
        } else {
            throw new RuntimeException("El árbol no debe ser vacío");
        }
    }

    // precondicion: árbol distinto de vacío
    public T getMax() {
        if (!isEmpty()) {
            return getMax(root).dato;
        } else {
            throw new RuntimeException("El árbol no debe ser vacío");
        }
    }

    // precondicion: elemento a buscar pertenece al arbol
    public T search(Comparable<T> x) {
        if (exists(x)) {
            return search(root, x).dato;
        } else {
            throw new RuntimeException("El elemento a buscar debe pertenecer al arbol");
        }
    }

    // precondicion: -
    public boolean exists(Comparable<T> x) {
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty() {
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot() {
        if (!isEmpty()) {
            return root.dato;
        } else {
            throw new RuntimeException("El arbol no debe ser vacio");
        }
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getLeft() {
        if (!isEmpty()) {
            BinarySearchTree<T> t = new BinarySearchTree<T>();
            t.root = root.left;
            return t;
        } else {
            throw new RuntimeException("El arbol no debe ser vacio");
        }
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getRight() {
        if (!isEmpty()) {
            BinarySearchTree<T> t = new BinarySearchTree<T>();
            t.root = root.right;
            return t;
        } else {
            throw new RuntimeException("El arbol no debe ser vacio");
        }
    }


    // METODOS PRIVADOS
    private DoubleNode<T> getMax(DoubleNode<T> t) {
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    private DoubleNode<T> getMin(DoubleNode<T> t) {
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNode<T> search(DoubleNode<T> t, Comparable<T> x) {
        if (x.compareTo(t.dato) == 0)
            return t;
        else if (x.compareTo(t.dato) < 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }

    private boolean exists(DoubleNode<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.dato) == 0)
            return true;
        else if (x.compareTo(t.dato) < 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }

    private DoubleNode<T> insert(DoubleNode<T> t, Comparable<T> x) {
        if (t == null) {
            t = new DoubleNode<T>();
            t.dato = (T) x;

        } else if (x.compareTo(t.dato) < 0)
            t.left = insert(t.left, x);
        else
            t.right = insert(t.right, x);
        return t;
    }


    private DoubleNode<T> delete(DoubleNode<T> t, Comparable<T> x) {
        if (x.compareTo(t.dato) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.dato) > 0)
            t.right = delete(t.right, x);
        else if (t.left != null && t.right != null) {
            t.dato = getMin(t.right).dato;
            t.right = deleteMin(t.right);
        } else if (t.left != null)
            t = t.left;
        else
            t = t.right;
        return t;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t) {
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }
}