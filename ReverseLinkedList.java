class Node {
    int val;
    Node next;
    Node(int val){
        this.val =val;
    }
}
public class ReverseLinkedList {

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next =  current.next; // Store the next node
            current.next = prev; // Reverese the current node's pointer
            prev = current; // Move prev to current
            current = next; // Move current to next
        }
        return prev;
    }

    // method to print the linkedlist

    public static void printList(Node head) {
        Node current = head;
        while(current != null){
            System.out.print(current.val + "  ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample Linked List
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List: ");
        printList(head);

        // Reverse the linked list
        head = reverse(head);
        System.out.println("Reversed List: ");
        printList(head);
    }

}
