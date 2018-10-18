import java.util.Scanner;
/**
 * Class for Node.
 */
class Node {
	/**
	 * { data }.
	 */
	protected int data;
	/**
	 * { next node address }.
	 */
	protected Node next;
	/**
	 * Constructs the object.
	 *
	 * @param      d     { data }.
	 */
	Node(final int d) {
		data = d;
	}
}
/**
 * Class for Linkedlist.
 */
class Linkedlist {
	/**
	 * { size }.
	 */
	private int size;
	/**
	 * { count }.
	 */
	private int count;
	/**
	 * { head and tail }.
	 */
	private Node head, tail;
	/**
	 * { result }.
	 */
	private String result = "";
	/**
	 * Constructs the object.
	 *
	 * @param      s     { size of list }
	 * @param      c     { count }
	 */
	Linkedlist(final int s, final int c) {
		size = s;
		count = c;
	}
	/**
	 * { josphProblem }.
	 */
	public void josephProblem() {
		Node newnode = new Node(0);
		head = newnode;
		tail = newnode;
		for (int i = 1; i < size; i++) {
			Node n = new Node(i);
			tail.next = n;
			tail = n;
		}
		int c;
		Node temp;
		while (size != 1) {
			for (c = 1; c < count; c++) {
				temp = head;
				head = head.next;
				tail.next = temp;
				tail = temp;
			}
			result += head.data + " ";
			head = head.next;
			c = 1;
			size--;
		}
		result += head.data;
		System.out.println(result);
	}
}