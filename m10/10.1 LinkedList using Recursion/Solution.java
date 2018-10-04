import java.util.Scanner;
class Linkedlist {
	Node head,temp;
	int size = 0;
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	public void insertAt(int index, int item) throws Exception {
		if(index > size || index < 0) {
			throw new Exception("Can't insert at this position");
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
	public void reverse(Node curr, Node prev) throws Exception {
		if(size == 0) {
			throw new Exception("No elements to reverse");
		}
		if(curr.next == null) {
			head = curr;
			head.next = prev;
			return;
		}
		Node temp = curr.next;
		curr.next = prev;
		reverse(temp, curr);
	}

	public void display() {
		temp = head;
		while(temp.next!=null){
			System.out.print(temp.data +", ");
			temp = temp.next;
		} System.out.print(temp.data);
		System.out.println();
		temp = head;
	}
}


class Solution {
	public static void main(String[] args) {
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