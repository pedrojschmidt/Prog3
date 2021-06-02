package BinaryTree;

import utils.DoubleNode;

import java.util.ArrayList;

public class TreeApi<T> {

    //Ejercicio 13
    // a) el peso
    public static <T> int size(BinaryTree<T> binaryTree) { //Calcula el peso
        if (binaryTree.isEmpty()) {
            return 0;
        } else {
            return 1 + size(binaryTree.getLeft()) + size(binaryTree.getRight());
        }
    }

    // b) el numero de hojas
    public int numberOfLeaves(BinaryTree<T> binaryTree) {
        int aux = 0;
        if (binaryTree.getRoot() != null) {
            if (binaryTree.getLeft().isEmpty() && binaryTree.getRight().isEmpty()) {
                aux++;
            }
            if (!binaryTree.getLeft().isEmpty()) {
                aux += numberOfLeaves(binaryTree.getLeft());
            }
            if (!binaryTree.getRight().isEmpty()) {
                aux += numberOfLeaves(binaryTree.getRight());
            }
        }
        return aux;
    }

    // c) el numero de veces que aparece un elemento dado
    public static <T> int numberOfOccurrences(BinaryTree<T> binaryTree, T element) {
        if (binaryTree.isEmpty()) {
            return 0;
        }
        if (binaryTree.getRoot().equals(element)) {
            return 1 + numberOfOccurrences(binaryTree.getLeft(), element) + numberOfOccurrences(binaryTree.getRight(), element);
        } else {
            return numberOfOccurrences(binaryTree.getLeft(), element) + numberOfOccurrences(binaryTree.getRight(), element);
        }
    }

    // d) el numero de elementos que tiene el árbol en un nivel dado
    public int elementsPerLevelAux(BinaryTree<T> binaryTree, int level, int aux) {
        int amount = 0;
        if (binaryTree.isEmpty()) {
            return 0;
        }
        if (aux == level && binaryTree.getRoot() != null) {
            amount += 1;
        }
        if (!binaryTree.getLeft().isEmpty()) {
            amount += elementsPerLevelAux(binaryTree.getLeft(), level, aux + 1);
        }
        if (!binaryTree.getRight().isEmpty()) {
            amount += elementsPerLevelAux(binaryTree.getRight(), level, aux + 1);
        }
        return amount;
    }

    public int elementsPerLevel(BinaryTree<T> binaryTree, int level) {
        return elementsPerLevelAux(binaryTree, level, 0);
    }


    // e) la altura
    public int height(BinaryTree<T> binaryTree) {
        if (binaryTree.isEmpty()) {
            return -1;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    //Ejercicio 14
    // a) Se dispone de un árbol binario de elementos de tipo entero. Escribir métodos que calculen:

    // i) la suma de sus elementos
    public int sumTreeElements(BinaryTree<Integer> binaryTree) {
        if (binaryTree.isEmpty()) {
            return 0;
        }

        int leftSum = sumTreeElements(binaryTree.getLeft());
        int rightSum = sumTreeElements(binaryTree.getRight());

        return binaryTree.getRoot() + leftSum + rightSum;
    }

    // ii) la suma de sus elementos que son múltiplos de 3.
    public int sumTreeElementsMultipleOfThree(BinaryTree<Integer> binaryTree) {
        if (binaryTree.isEmpty()) {
            return 0;
        }

        int leftSum = sumTreeElementsMultipleOfThree(binaryTree.getLeft());
        int rightSum = sumTreeElementsMultipleOfThree(binaryTree.getRight());

        if ((binaryTree.getRoot() % 3 == 0) && (leftSum % 3 == 0) && (rightSum % 3 == 0)) {
            return binaryTree.getRoot() + leftSum + rightSum;
        }
        if ((binaryTree.getRoot() % 3 == 0) && (leftSum % 3 == 0)) {
            return binaryTree.getRoot() + leftSum;
        }
        if ((binaryTree.getRoot() % 3 == 0) && (rightSum % 3 == 0)) {
            return binaryTree.getRoot() + rightSum;
        }
        if ((leftSum % 3 == 0) && (rightSum % 3 == 0)) {
            return leftSum + rightSum;
        }
        return 0;
    }

    // b) i)
    public boolean sameTree(BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2) {
        if (binaryTree1.isEmpty() && binaryTree2.isEmpty()) {
            return true;
        } else if ((!binaryTree1.isEmpty() && binaryTree2.isEmpty()) || (!binaryTree2.isEmpty() && binaryTree1.isEmpty())) {
            return false;
        }

        if (binaryTree1.getRoot().equals(binaryTree2.getRoot())) {
            return sameTree(binaryTree1.getLeft(), binaryTree2.getLeft()) && sameTree(binaryTree1.getRight(), binaryTree2.getRight());
        } else {
            return false;
        }
    }

    //b) ii)
    public boolean isomorphic(BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2) {
        if (binaryTree1.isEmpty() && binaryTree2.isEmpty()) {
            return true;
        } else if ((!binaryTree1.isEmpty() && binaryTree2.isEmpty()) || (!binaryTree2.isEmpty() && binaryTree1.isEmpty())) {
            return false;
        }

        return isomorphic(binaryTree1.getLeft(), binaryTree2.getLeft()) && isomorphic(binaryTree1.getRight(), binaryTree2.getRight());
    }

    //b) iii)
    public boolean similar(BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2) {
        if (size(binaryTree1) != size(binaryTree2)) {
            return false;
        } else {
            return occurs(binaryTree1, binaryTree2);
        }
    }

    //b) iv)
    public boolean isComplete(BinaryTree<T> binaryTree) {
        if (binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getLeft().isEmpty() && binaryTree.getRight().isEmpty()) {
            return true;
        }
        if (binaryTree.getLeft().isEmpty() || binaryTree.getRight().isEmpty()) {
            return false;
        }
        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    //b) v)
    public boolean isFull(BinaryTree<T> binaryTree) {
        if (isComplete(binaryTree) && (height(binaryTree.getLeft()) == height(binaryTree.getRight()))) {
            return true;
        } else {
            return false;
        }
    }

    //b) vi)
    public boolean isStable(BinaryTree<Integer> binaryTree) {
        if (binaryTree.isEmpty()) {
            return true;
        } else if (size(binaryTree) == 1) {
            return true;
        }

        //Caso: Árbol izquierdo vacío
        if (binaryTree.getLeft().isEmpty()) {
            if (binaryTree.getRoot() > binaryTree.getRight().getRoot()) {
                return isStable(binaryTree.getRight());
            } else {
                return false;
            }
        }

        //Caso: Árbol derecho vacío
        if (binaryTree.getRight().isEmpty()) {
            if (binaryTree.getRoot() > binaryTree.getLeft().getRoot()) {
                return isStable(binaryTree.getLeft());
            }
        }

        //Caso: ninguno de los anteriores
        if (binaryTree.getRoot() > binaryTree.getLeft().getRoot() && binaryTree.getRoot() > binaryTree.getRight().getRoot()) {
            return isStable(binaryTree.getLeft()) && isStable(binaryTree.getRight());
        } else {
            return false;
        }
    }


    //b) vii)
    //Devuelve true si todos los valores de binaryTree1 se encuentran en binaryTree2
    public boolean occurs(BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2) {
        if (binaryTree1.isEmpty()) {
            return true;
        }
        if (numberOfOccurrences(binaryTree2, binaryTree1.getRoot()) == 1) {
            return occurs(binaryTree1.getLeft(), binaryTree2) && occurs(binaryTree1.getRight(), binaryTree2);
        } else {
            return false;
        }
    }

    //b) viii)
    public void showBorder(BinaryTree<T> binaryTree) {
        if (!binaryTree.isEmpty()) {
            if (binaryTree.getRight().isEmpty() && binaryTree.getLeft().isEmpty()) {
                System.out.print(binaryTree.getRoot() + " ");
            }
            if (!binaryTree.getRight().isEmpty()) {
                showBorder(binaryTree.getRight());
            }
            if (!binaryTree.getLeft().isEmpty()) {
                showBorder(binaryTree.getLeft());
            }
        }
    }

    //b) ix)
    public ArrayList<T> border(BinaryTree<T> binaryTree, ArrayList<T> array) {
        if (!binaryTree.isEmpty()) {
            if (binaryTree.getRight().isEmpty() && binaryTree.getLeft().isEmpty()) {
                array.add(binaryTree.getRoot());
            }
            if (!binaryTree.getRight().isEmpty()) {
                border(binaryTree.getRight(), array);
            }
            if (!binaryTree.getLeft().isEmpty()) {
                border(binaryTree.getLeft(), array);
            }
        }
        return array;
    }


    //RECORRIDO PRE-ORDEN: raíz - hijo izquierdo - hijo derecho
    public void preOrder(BinaryTree<T> binaryTree) {
        System.out.print("[ ");
        preOrderRecursive(binaryTree);
        System.out.print("]");
    }

    private void preOrderRecursive(BinaryTree<T> binaryTree) {
        if (!binaryTree.isEmpty()) {
            DoubleNode<T> node = new DoubleNode<>(binaryTree.getRoot());
            System.out.print(node.getDato() + " ");
            preOrderRecursive(binaryTree.getRight());
            preOrderRecursive(binaryTree.getLeft());
        }
    }

    //RECORRIDO INORDEN: hijo izquierdo - raíz - hijo derecho
    public void inorder(BinaryTree<T> binaryTree) {
        System.out.print("[ ");
        inorderRecursive(binaryTree);
        System.out.print("]");
    }

    private void inorderRecursive(BinaryTree<T> binaryTree) {
        if (!binaryTree.isEmpty()) {
            DoubleNode<T> node = new DoubleNode<>(binaryTree.getRoot());
            inorderRecursive(binaryTree.getRight());
            System.out.print(node.getDato() + " ");
            inorderRecursive(binaryTree.getLeft());
        }
    }

    //RECORRIDO POST-ORDEN: hijo izquierdo - hijo derecho - raíz
    public void postOrder(BinaryTree<T> binaryTree) {
        System.out.print("[ ");
        postOrderRecursive(binaryTree);
        System.out.print("]");
    }

    private void postOrderRecursive(BinaryTree<T> binaryTree) {
        if (!binaryTree.isEmpty()) {
            DoubleNode<T> node = new DoubleNode<>(binaryTree.getRoot());
            postOrderRecursive(binaryTree.getRight());
            postOrderRecursive(binaryTree.getLeft());
            System.out.print(node.getDato() + " ");
        }
    }

    //RECORRIDO POR NIVELES: visito cada nodo desde la raíz hacia las hojas y desde la izquierda a la derecha
    public void byLevels(BinaryTree<T> binaryTree) {
        System.out.print("[ ");
        byLevelsRecursive(binaryTree);
        System.out.print("]");
    }

    private void byLevelsRecursive(BinaryTree<T> binaryTree) {
        for (int i = 1; i <= height(binaryTree) + 1; i++) {
            printGivenLevel(binaryTree, i);
        }
    }

    private void printGivenLevel(BinaryTree<T> binaryTree, int level) {
        if (!binaryTree.isEmpty()) {
            if (level == 1) {
                System.out.print(binaryTree.getRoot() + " ");
            } else if (level > 1) {
                printGivenLevel(binaryTree.getRight(), level - 1);
                printGivenLevel(binaryTree.getLeft(), level - 1);
            }
        }
    }
}