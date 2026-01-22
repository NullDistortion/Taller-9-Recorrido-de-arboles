package main.java.edu.u2.sorting;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Recorrido Preorden: Raíz - Izquierda - Derecha
    public void preorden(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preorden(node.left);
        preorden(node.right);
    }
}
