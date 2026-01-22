package edu.u2.sorting;

public class  Recorrido_Postorden{
    TreeNode root;

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

}
