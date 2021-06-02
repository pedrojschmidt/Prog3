package BinaryTree;

public class Ej17a { // devolver el arbol reflejado FUNCIONA BIEN

    public static void main(String[] args) {

        BinaryTree<Integer> a = new BinaryTree(3, new BinaryTree<>(1), new BinaryTree<>(2));
        BinaryTree<Integer> b = new BinaryTree(6, new BinaryTree<>(4), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(8, a, b);
        TreeApi<Integer> treeApi = new TreeApi<Integer>();

        treeApi.inorder(tree);
        treeApi.postOrder(tree);
        System.out.println("\n\n");

        BinaryTree<Integer> reflexedTree = reflex(tree);

        treeApi.inorder(reflexedTree);
        treeApi.postOrder(reflexedTree);
    }

    public static BinaryTree<Integer> reflex(BinaryTree<Integer> tree){
        if (tree.isEmpty()) {
            return new BinaryTree<Integer>();
        }
        BinaryTree<Integer> aux = new BinaryTree<Integer>(tree.getRoot(), reflex(tree.getLeft()), reflex(tree.getRight()));
        return aux;
    }

}