import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
	/**
	 * { head node }.
	 */
	Node head,temp;
	/**
	 * { size variable }.
	 */
	int size = 0;
	/**
	 * Class for node.
	 */
	class Node {
		/**
		 * { data }.
		 */
		int data;
		/**
		 * { next node address }.
		 */
		Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      data  The data
		 */
		public Node(int data) {
			this.data = data;
		}
	}
	/**
	 * { inserts at given position }.
	 *
	 * @param      index      The index
	 * @param      item       The item
	 *
	 * @throws     Exception  { if index is less then size
	 * or 0 throws exception }.
	 */
	public void insertAt(final int index, final int item) throws Exception {
		if(index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
		}
		if(size == 0) {
			Node newnode = new Node(item);
			head = newnode;
			temp = head;
			size++;
			return;
		} else if(size >= 1) {
			Node newnode = new Node(item);
			if(index == 0) {
				newnode.next = head;
				head = newnode;
				temp = head;
				size++;
				return;
			} else if(index == 1) {
				newnode.next = temp.next;
				temp.next = newnode;
				size++;
				temp = head;
				return;
			} else {
				temp = temp.next;
				insertAt(index - 1, item);
			}
		}
	}
	/**
	 * { revers the given linked list }.
	 *
	 * @param      curr       The curr
	 * @param      prev       The previous
	 *
	 * @throws     Exception  { if there are no elements throws exception }.
	 */
	public void reverse(Node curr, Node prev) throws Exception {
		if(size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if(curr.next == null) {
			head = curr;
			head.next = prev;
			temp = head;
			return;
		}
		Node temp = curr.next;
		curr.next = prev;
		reverse(temp, curr);
	}
	/**
	 * { print the entire list }.
	 */
	public void display() {
		while(temp.next!=null){
			System.out.print(temp.data +", ");
			temp = temp.next;
		} System.out.print(temp.data);
		System.out.println();
		temp = head;
	}
}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Linkedlist l = new Linkedlist();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] arr = sc.nextLine().split(" ");
			if(arr[0].equals("insertAt")) {
				try{
					l.insertAt(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
					l.display();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if(arr[0].equals("reverse")) {
				try{
					l.reverse(l.head, null);
					l.display();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}
}