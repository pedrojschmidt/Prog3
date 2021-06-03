package Modelo2doParcial;

/*   El departamento de estadística de una empresa telefónica recibe un archivo de con las llamadas que se
     hicieron al exterior durante un determinado mes. El archivo contiene un número de 1 a 50 que representa
     un país y el tiempo en minutos y segundos de la llamada. Cada dato está separado por punto y coma. Se pide:


   a.     La cantidad de llamadas que se hicieron a cada país
   b.     Cuantas llamadas duraron más de 7 minutos.

     */

import BinarySearchTree.BinarySearchTree;
import BinaryTree.BinaryTree;
import java.util.ArrayList;

public class Parcial2020<T> {

    public static void main(String[] args) {
        Parcial2020<Integer> a = new Parcial2020<>();

        BinaryTree<Integer> uno = new BinaryTree(3, new BinaryTree<>(2), new BinaryTree<>(12));
        BinaryTree<Integer> dos = new BinaryTree(6, new BinaryTree<>(4), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(7, uno, dos);

        BinarySearchTree<Integer> bst = a.transform(tree);
        a.inorden(bst);
    }

    /*
    Usando solamente las primitivas de BinaryTree y SearchBinaryTree
    escribir un método que recibe un árbol binario y con sus elementos construya un árbol binario de búsqueda.
    */
    public BinarySearchTree<T> transform(BinaryTree<T> tree){
        BinarySearchTree<T> searchTree = new BinarySearchTree<T>();
        ArrayList<T> arrayList = listElements(tree, new ArrayList<>());
        for (int i = 0; i < arrayList.size(); i++) {
            searchTree.insert((Comparable<T>) arrayList.get(i));
        }
        return searchTree;
    }

    private ArrayList<T> listElements(BinaryTree<T> binaryTree, ArrayList<T> elements){
        if (!binaryTree.isEmpty()){
            elements.add(binaryTree.getRoot());
            listElements(binaryTree.getLeft(), elements);
            listElements(binaryTree.getRight(), elements);
        }
        return elements;
    }

    public void inorden(BinarySearchTree<T> binarySearchTree)  {
        if (!binarySearchTree.isEmpty()){
            inorden(binarySearchTree.getLeft());
            System.out.print(binarySearchTree.getRoot() + " ");
            inorden(binarySearchTree.getRight());
        }
    }
}
