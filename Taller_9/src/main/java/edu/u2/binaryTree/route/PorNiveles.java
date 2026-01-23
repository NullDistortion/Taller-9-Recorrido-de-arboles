package edu.u2.binaryTree.route;

import edu.u2.binaryTree.model.Node;
import java.util.LinkedList;
import java.util.Queue;

public class PorNiveles {
    public void traverse(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getValue() + " ");

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }
}