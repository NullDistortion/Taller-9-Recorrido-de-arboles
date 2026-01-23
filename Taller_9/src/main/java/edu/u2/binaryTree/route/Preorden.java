package edu.u2.binaryTree.route;

import edu.u2.binaryTree.model.Node;

public class Preorden {
    public void traverse(Node node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        traverse(node.getLeft());
        traverse(node.getRight());
    }
}