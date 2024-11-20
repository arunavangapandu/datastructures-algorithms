package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public Node reverseList(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextCurrent = current.next; // Store the next node
            current.next = previous;             // Reverse the current node's pointer
            previous = current;                  // Move the previous pointer forward
            current = nextCurrent;               // Move the current pointer forward
        }

        return previous; // Previous will be the new head after the loop ends
    }
}

 class ListUtils {
    public static Node createLinkedList(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static int[] linkedListToArray(Node head) {
        List<Integer> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}

 class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] input1 = {0, 1, 2, 3};
        Node head1 = ListUtils.createLinkedList(input1);
        Node reversedHead1 = solution.reverseList(head1);
        int[] output1 = ListUtils.linkedListToArray(reversedHead1);
        System.out.println(Arrays.toString(output1)); // Output: [3, 2, 1, 0]
        
        // Test case 2
        int[] input2 = {};
        Node head2 = ListUtils.createLinkedList(input2);
        Node reversedHead2 = solution.reverseList(head2);
        int[] output2 = ListUtils.linkedListToArray(reversedHead2);
        System.out.println(Arrays.toString(output2)); // Output: []
    }
}
