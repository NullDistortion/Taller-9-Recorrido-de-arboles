package main.java.edu.u2.sorting;

public class ArbolBinario {
    TreeNode root;

    public ArbolBinario() {
        this.root = null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void inOrden() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
        } else {
            inOrdenRecursivo(root);
            System.out.println(); // Salto de línea al final
        }
    }

    private void inOrdenRecursivo(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrdenRecursivo(node.left);
        System.out.print(node.value + " ");
        inOrdenRecursivo(node.right);
    }
}