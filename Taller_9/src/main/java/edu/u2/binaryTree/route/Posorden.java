package edu.u2.binaryTree.route;

import edu.u2.binaryTree.model.Node;

public class Posorden {
    public void traverse(Node node) {
        if (node == null) return;
        traverse(node.getLeft());
        traverse(node.getRight());
        System.out.print(node.getValue() + " ");
    }
}