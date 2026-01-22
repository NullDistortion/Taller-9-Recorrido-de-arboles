package edu.u2.binaryTree.model;

public class Node {
    private final int id;
    private final int value;
    private Node left;
    private Node right;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}