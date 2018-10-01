import java.util.Scanner;
/**
 * List of linkeds.
 */
class LinkedList {
	/**
	 * { head }.
	 */
	private Node head = null;
	/**
	 * { tail }.
	 */
	private Node tail = null;
	/**
	 * Class for node.
	 */
	final class Node {
		/**
		 * { data value }.
		 */
		private int data;
		/**
		 * { next node address }.
		 */
		private Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      d     { set the data to a node }.
		 */
		private Node(final int d) {
			data = d;
		}
		/**
		 * Gets the data.
		 *
		 * @return     The data.
		 */
		public int getData() {
			return data;
		}
		/**
		 * Gets the next.
		 *
		 * @return     The next.
		 */
		public Node getNext() {
			return next;
		}
		/**
		 * Sets the next.
		 *
		 * @param      address  The address
		 */
		public void setNext(final Node address) {
			this.next = address;
		}
	}
	/**
	 * Makes a listempty.
	 */
	public void makeListempty() {
		head = null;
		tail = null;
	}
	/**
	 * { this method will push element into steque }.
	 *
	 * @param      data  The data
	 */
	public void push(final int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			tail = newnode;
		} else {
			newnode.setNext(head);
			head = newnode;
		}
		print();
	}
	/**
	 * { this method will enqueue the element into steque }.
	 *
	 * @param      data  The data
	 */
	public void enqueue(final int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			tail = newnode;
		} else {
			tail.setNext(newnode);
			tail = newnode;
		}
		print();
	}
	/**
	 * { this will pop the element from steque }.
	 */
	public void pop() {
		if (head == null) {
			System.out.println("Steque is empty.");
			return;
		}
		head = head.next;
		print();
	}
	/**
	 * { this will print steque }.
	 */
	public void print() {
		Node temp = head;
		String result = "";
		if (head == null) {
			System.out.println("Steque is empty.");
			return;

		}
		while (temp.next != null) {
			result += temp.getData() + ", ";
			temp = temp.getNext();
		}
		result = result + temp.data;
		System.out.println(result);
	}

}
/**
 * { Solution class }.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//constructor.
	}
	/**
	 * { main method }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		LinkedList l = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i <= testcases; i++) {
			while (sc.hasNext()) {
			String input = sc.nextLine();
			if (input.length() == 0) {
				System.out.println();
				break;
			}
			String[] line = input.split(" ");
				switch (line[0]) {
				case "push":
				l.push(Integer.parseInt(line[1]));
				break;
				case "enqueue":
				l.enqueue(Integer.parseInt(line[1]));
				break;
				case "pop":
				l.pop();
				break;
				default:
				break;
				}
			}
			l.makeListempty();
		}
	}
}