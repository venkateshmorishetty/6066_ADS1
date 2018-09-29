import java.util.Scanner;
/**
 * Class for node.
 */
class node {
	int data;
	node next;
	node(int d) {
		data = d;
	}
}
/**
 * Class for linkedlist.
 */
class linkedlist {
	int size;
	int count;
	/**
	 * { head and tail }.
	 */
	private node head, tail;
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
	linkedlist(final int s, final int c) {
		size = s;
		count = c;
	}
	/**
	 * { josphproblem }.
	 */
	public void josephproblem() {
		node newnode = new node(0);
		head = newnode;
		tail = newnode;
		for (int i = 1; i < size; i++) {
			node n = new node(i);
			tail.next = n;
			tail = n;
		}
		int c;
		node temp;
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
/**
 * { solution class }.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//pass.
	}
	/**
	 * { main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		linkedlist l;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(" ");
			l = new linkedlist(Integer.parseInt(tokens[0]),
				Integer.parseInt(tokens[1]));
			l.josephproblem();
		}
	}
}