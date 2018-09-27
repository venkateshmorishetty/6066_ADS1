import java.uil.Scanner;
class Node {
	String item;
	Node address;
	public Node(String item) {
		this.item = item;
		adress = null;
	}
}
class Linkedlist {
	public static void main(String[] args) {
		Node n;
		Node head,tail;
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for(int i = 0; i < lines; i++) {
			String  line = sc.next();
			String[] arr = line.split("", line.length());
			for(int j = 0; j < arr.length; j++) {
				if(arr[j].equals("{") || arr[j].equals("[") || arr[j].equals("(")) {
					n = new Node(arr[j]);
					if(head.getAddress() == null) {
						head = n;
						tail = head;
					} else {
						
					}
				}
			}
		}
	}
}