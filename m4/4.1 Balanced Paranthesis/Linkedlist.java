import java.util.Scanner;
class Node {
	Node() {

	}
	int item;
	Node address = null;
	public Node(int item) {
		this.item = item;
	}
	public void setAddress(Node t) {
		address = t;
	}
}
class list{
	Node head;
	Node tail;
	public void insert(int ele) {
		Node n = new Node(ele);
		if(head == null) {
			head = n;
			tail = n;
		} else {
			tail.address = n;
			tail = n;
		}
	}
	public void delend() {
		Node temp = head;
		while(temp.address!= tail) {
			temp = temp.address;
		}
		temp.address = null;
		tail = temp;
	}
	public void delbeg() {
		head = head.address;
	}
	public void delloc(int data) {
		Node temp = head;
		while(temp.address.item != data) {
			temp = temp.address;
		}
		temp.address = temp.address.address;

	}
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.item);
			temp = temp.address;
		}
	}
}
class Linkedlist {
	public static void main(String[] args) {
		list l = new list();
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.print();
		System.out.println("++++++++++++++====");
		l.delend();
		l.print();
		l.delbeg();
		System.out.println("+++++++++++++++++++======");
		l.print();
		l.insert(5);
		l.insert(6);
		l.insert(9);
		l.delloc(6);
		System.out.println("@@@@@@@@@@@");
		l.print();
	}
}