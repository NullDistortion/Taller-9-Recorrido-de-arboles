package edu.u2.binaryTree.route;

import edu.u2.binaryTree.model.Node;

public class Inorden {
    public void traverse(Node node) {
        if (node == null) return;
        traverse(node.getLeft());
        System.out.print(node.getValue() + " ");
        traverse(node.getRight());
    }
}