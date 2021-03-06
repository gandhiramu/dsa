package dsa.annotated;
/**
 * Linked list implementation
 * 
 * @author asantana
 * 
 */
public class LinkedList {
	Node head;
	Node tail;

	public void add(Node n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public void print() {
		System.out.println(toString());
	}

	public boolean contains(Node n) {
		if (head == null || n == null)
			return false;
		if (head.equals(n))
			return true;

		Node next = head.next;
		while (next != null && !next.equals(n)) {
			next = next.next;
		}
		if (next == null)
			return false;
		return true;
	}

	public boolean delete(Node n) {
		// case 1
		if (head == null)
			return false;

		if (head.equals(n)) {
			// case 2
			if (head.equals(tail)) {
				head = null;
				tail = null;
			} else {
				// case 3
				Node newHead = head.next;
				head.next = null;
				head = newHead;
			}
			return true;
		}
		Node temp = head;
		while (temp.next != null && !temp.next.equals(n))
			temp = temp.next;
		if (temp.next != null) {
			if (temp.next.equals(tail)) {
				// case 4
				tail = temp;
			}
			// case 5
			temp.next = temp.next.next;
			return true;
		}
		// case 6
		return false;
	}

	@Override
	public String toString() {
		if (head == null)
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(head.value);
		Node next = head.next;
		while (next != null) {
			sb.append("," + next.value);
			next = next.next;
		}
		return sb.toString();
	}

	public String toStringReverse() {
		if (tail == null)
			return "";
		Node right = tail;
		Node left = head;
		StringBuffer sb = new StringBuffer();
		sb.append(tail.value);
		while (!right.equals(head)) {
			while (!left.next.equals(right)) {
				left = left.next;
			}
			sb.append("," + left.value);
			right = left;
			left = head;
		}
		return sb.toString();
	}
	
	public void reverse() {
		Node previous = null;
		Node temp = null;
		Node current = head;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head = previous;
	}
	
	public void printReverse(Node node) {
		if (node == null)
			return;
		printReverse(node.next);
		System.out.println(node.value);
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.printReverse(ll.head);
	}
}
