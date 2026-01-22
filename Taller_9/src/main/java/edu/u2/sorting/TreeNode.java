package main.java.edu.u2.sorting;

public class TreeNode {
    int id;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int id, int value) {
        this.id = id;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value) {
        this.value = value;
        this.id = -1;
        this.left = null;
        this.right = null;
    }
}