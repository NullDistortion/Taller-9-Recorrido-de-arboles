package edu.u2.sorting;

public class  Recorrido_Postorden{

    TreeNode_Orozco root;

    public void postOrder(TreeNode_Orozco node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
}