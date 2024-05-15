import java.util.LinkedList;


class MergeSortedList {
	public static LinkedList<Integer> mergeSortedLists(Node l1, Node l2) {
		LinkedList<Integer> mergedList = new LinkedList<>();
		Node curr1 = l1, curr2 = l2;

		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				mergedList.add(curr1.val);
				curr1 = curr1.next;
			} else if (curr1.val == curr2.val) {
				mergedList.add(curr1.val);
				mergedList.add(curr2.val);
				curr1 = curr1.next;
				curr2 = curr2.next;
			} else {
				mergedList.add(curr2.val);
				curr2 = curr2.next;
			}
		}

		// Add remaining nodes
		while (curr1 != null) {
			mergedList.add(curr1.val);
			curr1 = curr1.next;
		}

		while (curr2 != null) {
			mergedList.add(curr2.val);
			curr2 = curr2.next;
		}

		return mergedList;
	}

	public static void main(String[] args) {
		Node l1 = new Node(1);
		l1.next = new Node(2);
		l1.next.next = new Node(4);

		Node l2 = new Node(1);
		l2.next = new Node(3);
		l2.next.next = new Node(4);

		LinkedList<Integer> ml = MergeSortedList.mergeSortedLists(l1, l2);

		// Display the merged list
		System.out.println("Merged List:");
		for (Integer val : ml) {
			System.out.print(val + " -> ");
		}
		System.out.println("null");
	}
}
