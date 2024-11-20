package com.leetcode.problems.extra;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Stack;

class ListNode{
      int val;
    ListNode next;
      public ListNode(int val) {
          this.val =val;
          this.next = null;
      }
  }
public class ReverseLinkedList {

    // Iterative approach
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        ListNode reverse = new ReverseLinkedList().reverse(head);
        printList(reverse);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
