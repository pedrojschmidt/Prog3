package BinaryTree;

import utils.DoubleNode;

public class BinaryTree<T> {

    private DoubleNode<T> root;

    //Crea un árbol vacío.
    public BinaryTree() {
        root = null;
    }

    //Crea un árbol con un único elemento.
    public BinaryTree(T element) {
        root = new DoubleNode<>(element);
    }

    public BinaryTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new DoubleNode<T>(element, leftTree.root, rightTree.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.getDato();
    }

    public void setRoot(T element) {
        root.setDato(element);
    }

    public BinaryTree<T> getRight() {
        BinaryTree<T> binaryTree = new BinaryTree<T>();
        binaryTree.root = root.getLeft();
        return binaryTree;
    }

    public BinaryTree<T> getLeft() {
        BinaryTree<T> binaryTree = new BinaryTree<T>();
        binaryTree.root = root.getRight();
        return binaryTree;
    }
}
