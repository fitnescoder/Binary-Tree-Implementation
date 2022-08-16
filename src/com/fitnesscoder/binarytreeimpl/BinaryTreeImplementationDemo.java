package com.fitnesscoder.binarytreeimpl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeImplementationDemo {
    public static void main(String[] args) {
        Node root = null;

        root = buildTree(root);

        printTreeUsingLevelOrderTraversal(root);
    }

    private static void printTreeUsingLevelOrderTraversal(Node root) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(root);
        que.offer(new Node(-1));

        while (!que.isEmpty()) {
            Node temp = que.remove();

            if (temp.data == -1) {
                System.out.println();
                if (!que.isEmpty()) {
                    que.offer(new Node(-1));
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    que.offer(temp.left);
                }

                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }
        }
    }

    private static Node buildTree(Node root) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data :");
        int data = sc.nextInt();
        root = new Node(data);

        if (data == -1) {
            return null;
        }

        System.out.println("Updating left child of node having data :" + data);
        root.left = buildTree(root.left);
        System.out.println("Updating right child of node having data :" + data);
        root.right = buildTree(root.right);
        return root;
    }
}
