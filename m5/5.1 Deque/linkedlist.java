class node{
	int data;
	node next;
	node(int data) {
		this.data = data;
	}
}
class linkedlist{
	node head = null;
	int size = 0;
	node tail;
	public void pushRight(int data) {
		node newnode = new node(data);
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
	public void pushLeft(int item) {
		node n = new node(item);
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
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;

	}
	public void popLeft() {
		if(size == 0) {
			System.out.println("Deck is empty");
			
			return;
		}
		node temp = head;
		head = head.next;
		size--;
		print();
	}
	public void popRight() {
		if(size == 0) {
			System.out.println("Deck is empty");
			
			return;
		}
		node temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		tail = temp;
		temp.next = null;
		size--;
		print();
	}
	public void print() {
		if(size == 0 ) {
			System.out.println("[]");
			return;
		}
		node temp = head;
		String str = "[";
		while(temp.next!=null) {
			str += temp.data+", ";
			temp = temp.next;
		}
		str += temp.data+"]";
		System.out.println(str);
	}
	public int size() {
		return size;
	}
}
