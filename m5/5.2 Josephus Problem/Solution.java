import java.util.Scanner;
class node {
	int data;
	node next;
	node(int d) {
		data = d;
	}
}
class linkedlist {
	int size;
	int count;
	node head,tail;
	String result ="";
	linkedlist(int s, int c) {
		size = s;
		count = c;
	}

	public void josephproblem() {
		node newnode = new node(0);
		head = newnode;
		tail = newnode;
		for(int i = 1; i < size; i++) {
			node n = new node(i);
			tail.next = n;
			tail = n;
		}
		int c;
		node temp;
		while(size != 1) {
			for(c = 1; c < count; c++) {
				temp = head;
				head = head.next;
				tail.next = temp;
				tail = temp;
			}
			result += head.data+" ";
			head = head.next;
			c = 1;
			size--;
		}
		result += head.data;
		System.out.println(result);
	}
}
class Solution{
	public static void main(String[] args) {
		linkedlist l;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(" ");
			l = new linkedlist(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			l.josephproblem();
		}
	}
	
}