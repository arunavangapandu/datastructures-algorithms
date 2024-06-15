class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseLinkedListRecursive {
    public static ListNode reverseList(ListNode curr) {
        // Base case: if the list is empty or has only one node
        if (curr == null || curr.next == null) {
            return curr;
        } else {
            ListNode nextNode = curr.next;
            curr.next = null;
            ListNode rest = reverseList(nextNode);
            nextNode.next = curr;
            return rest;
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + "  ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample Linked List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(56);
        head.next.next.next.next = new ListNode(60);

        System.out.println("Original List: ");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);
        System.out.println("Reversed List: ");
        printList(head);
    }

}

