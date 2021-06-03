package BinaryTree;

/*
ArBin podar (ArBin a)  Elimina del árbol a todas sus hojas
 */

public class Ej17c {

    public static void main(String[] args) {

        BinaryTree<Integer> a = new BinaryTree(3, new BinaryTree<>(1), new BinaryTree<>(2));
        BinaryTree<Integer> b = new BinaryTree(6, new BinaryTree<>(4), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(8, a, b);
        TreeApi<Integer> treeApi = new TreeApi<Integer>();

        treeApi.inorder(tree);
        podar(tree);
        treeApi.inorder(tree);
    }

    public static BinaryTree<Integer> podar(BinaryTree<Integer> tree){
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            tree.setRoot(null);
        }
        if (!tree.isEmpty()) {
            return podar(tree);
        }
        return tree;
    }
}
