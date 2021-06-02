package Modelo2doParcial;

/*
Usando solamente las primitivas de BinaryTree desarrollar y
probar un método que recibe un árbol binario de números enteros y
devuelve un árbol isomorfo en el cual cada nodo contiene la suma
de él junto con todos sus descendientes siempre que sean pares.
 */

import BinaryTree.*;

public class Ej2 { // Arboles isomorfos FUNCIONA BIEN

    public static void main(String[] args) {

        BinaryTree<Integer> uno = new BinaryTree(3, new BinaryTree<>(1), new BinaryTree<>());
        BinaryTree<Integer> dos = new BinaryTree(6, new BinaryTree<>(), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(7, uno, dos);
        TreeApi<Integer> treeApi = new TreeApi<Integer>();

        treeApi.inorder(tree);
        treeApi.postOrder(tree);
        System.out.println("\n\n");

        BinaryTree<Integer> isomorphTree = getAnIsomorph(tree);

        treeApi.inorder(isomorphTree);
        treeApi.postOrder(isomorphTree);
    }

    public static BinaryTree<Integer> getAnIsomorph(BinaryTree<Integer> tree){
        if (tree.isEmpty()) {
            return new BinaryTree<Integer>();
        }
        Integer newNumber = tree.getRoot() + (int) (Math.random()*30);
        BinaryTree<Integer> aux = new BinaryTree<Integer>(newNumber, getAnIsomorph(tree.getLeft()), getAnIsomorph(tree.getRight()));
        return aux;
    }
}
