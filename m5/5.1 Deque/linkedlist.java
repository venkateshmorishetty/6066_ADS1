/**
 * Class for Node.
 */
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}
/**
 * Class for Linkedlist.
 */
class Linkedlist {
	Node head = null;
	int size = 0;
	Node tail;
	/**
	 * Pushes a right.
	 *
	 * @param      data  The data
	 */
	public void pushRight(final int data) {
		Node newnode = new Node(data);
		newnode.next = null;
		if (head == null) {
			head = newnode;
			tail = newnode;
			print();
		}
		else{
			tail.next = newnode;
			tail = newnode;
		}
		size++;
		print();		
	}
	/**
	 * Pushes a left.
	 *
	 * @param      item  The item
	 */
	public void pushLeft(int item) {
		Node n = new Node(item);
		n.next = null;
		if(head == null) {
			head = n;
			tail = n;
		} else{
			n.next = head;
			head = n;
		}
		size++;
		print();
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;

	}
	/**
	 * { pop the first element from left }.
	 */
	public void popLeft() {
		if(size == 0) {
			System.out.println("Deck is empty");
			
			return;
		}
		Node temp = head;
		head = head.next;
		size--;
		print();
	}
	/**
	 * { pop the last element }..
	 */
	public void popRight() {
		if(size == 0) {
			System.out.println("Deck is empty");
			
			return;
		}
		Node temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		tail = temp;
		temp.next = null;
		size--;
		print();
	}
	/**
	 * { print the entire linked list }.
	 */
	public void print() {
		if(size == 0 ) {
			System.out.println("[]");
			return;
		}
		Node temp = head;
		String str = "[";
		while(temp.next!=null) {
			str += temp.data+", ";
			temp = temp.next;
		}
		str += temp.data+"]";
		System.out.println(str);
	}
	/**
	 * { return the size of linked list }.
	 *
	 * @return     { size of linked list }
	 */
	public int size() {
		return size;
	}
}
