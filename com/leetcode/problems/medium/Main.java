package com.leetcode.problems.medium;

import java.util.Scanner;

class BstNode {
    int data;
    BstNode left, right;

    public BstNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    // Function to create a new Node
    public BstNode insert(BstNode root, int data) {
        if (root == null) {
            root = new BstNode(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // To search an element in BST, returns true if element is found
    public boolean search(BstNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data <= root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BstNode root = null;
        BinarySearchTree bst = new BinarySearchTree();

        root = bst.insert(root, 15);
        root = bst.insert(root, 10);
        root = bst.insert(root, 20);
        root = bst.insert(root, 25);
        root = bst.insert(root, 8);
        root = bst.insert(root, 12);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to be searched:");
        int number = scanner.nextInt();
        scanner.close();

        if (bst.search(root, number)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
