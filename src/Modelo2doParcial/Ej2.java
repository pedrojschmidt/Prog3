package Modelo2doParcial;

/*
Usando solamente las primitivas de BinaryTree desarrollar y
probar un método que recibe un árbol binario de números enteros y
devuelve un árbol isomorfo en el cual cada nodo contiene la suma
de él junto con todos sus descendientes siempre que sean pares.
 */

import BinaryTree.*;

public class Ej2 { // Arboles isomorfos

    public static void main(String[] args) {

        BinaryTree<Integer> uno = new BinaryTree(3, new BinaryTree<>(2), new BinaryTree<>(12));
        BinaryTree<Integer> dos = new BinaryTree(6, new BinaryTree<>(4), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(7, uno, dos);
        TreeApi<Integer> treeApi = new TreeApi<Integer>();

        treeApi.inorder(tree);
        treeApi.postOrder(tree);
        System.out.println("\n\n");

        BinaryTree<Integer> isomorphTree = getAnIsomorph(tree);

        treeApi.inorder(isomorphTree);
        treeApi.postOrder(isomorphTree);
    }

    public static BinaryTree<Integer> getAnIsomorph(BinaryTree<Integer> tree) {
        if (tree.isEmpty()) {
            return new BinaryTree<Integer>();
        }
        Integer newNumber = sum(tree, 0);
        BinaryTree<Integer> aux = new BinaryTree<Integer>(newNumber, getAnIsomorph(tree.getRight()), getAnIsomorph(tree.getLeft()));
        return aux;
    }

    public static int sum(BinaryTree<Integer> tree, int aux) {
        if (!tree.isEmpty()) {
            if (tree.getRoot() % 2 == 0) {
                return tree.getRoot() + sum(tree.getLeft(), aux) + sum(tree.getRight(), aux);
            } else {
                return sum(tree.getLeft(), aux) + sum(tree.getRight(), aux);
            }
        }
        return aux;
    }
}
