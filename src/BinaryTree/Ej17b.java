package BinaryTree;

/*
void reemplazar ArBin (ArBin a, Objeto e1, Objeto e2) Reemplaza en el árbol a todas las ocurrencias del objeto e1 por el objeto e2
 */

public class Ej17b {

    public static void main(String[] args) {

        BinaryTree<Integer> a = new BinaryTree(3, new BinaryTree<>(1), new BinaryTree<>(2));
        BinaryTree<Integer> b = new BinaryTree(6, new BinaryTree<>(4), new BinaryTree<>(5));

        BinaryTree<Integer> tree = new BinaryTree(8, a, b);
        TreeApi<Integer> treeApi = new TreeApi<Integer>();

        treeApi.inorder(tree);
        replaceObject(tree, 8, 10);
        treeApi.inorder(tree);
    }

    public static void replaceObject(BinaryTree<Integer> tree, Integer a, Integer b){
        if (!tree.isEmpty()) {
            if (tree.getRoot().equals(a)) {
                tree.setRoot(b);
            }
            replaceObject(tree.getLeft(), a, b);
            replaceObject(tree.getRight(), a, b);
        }
    }
}
