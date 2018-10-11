import java.util.Scanner;
class Book {
	private String name;
	private String author;
	private Double price;
	Book(String n, String a, double p) {
		name = n;
		author = a;
		price = p;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public Double getPrice() {
		return price;
	}
}


class Node<Value> {
	private Node left = null;
	private Book book;
	private Value qty;
	private Node right = null;
	Node(Book b, Value q) {
		qty = q;
		book = b;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public Value getQty() {
		return qty;
	}
	public Book getBook() {
		return book;
	}

	public void setRight(Node n) {
		right = n;
	}

	public void setLeft(Node n) {
		left = n;
	}
	public void setQty(Value q) {
		qty = q;
	}
}

class BinarySearchTree<Value> {
	Node head = null;
	public void put(Book key, int value) {
		Node<Integer> n = new Node<Integer>(key, value);
		if(head == null) {
			head = n;
			return;
		} else {
			Node temp = head;
			while(temp!=null) {
				int check = n.getBook().getName().compareTo(temp.getBook().getName());
				if(check > 0) {
					if(temp.getRight() == null) {
						temp.setRight(n);
						return;
					}
					temp = temp.getRight();
				} else if(check < 0) {
					if(temp.getLeft() == null){
						temp.setLeft(n); 
						return;	
					} 
					temp = temp.getLeft();
				} else {
					temp.setQty(n.getQty());
					return;
				}	
			}
		}
	}
	public Value get(Book b) {
		Node temp = head;
		while(temp!=null) {
			int check = b.getName().compareTo(temp.getBook().getName());
			if(check < 0) {
				temp = temp.getLeft();
			} else if(check > 0) {
				temp = temp.getRight();
			} else {
				return (Value)temp.getQty();
			}
		}
		return null;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();
		while(sc.hasNext()) {
			String[] line = sc.nextLine().split(",");
			switch(line[0]){
				case "put":
				Book b = new Book(line[1], line[2], Double.parseDouble(line[3]));
				btree.put(b, Integer.parseInt(line[4]));
				break;
				case "get":
				Book newbook = new Book(line[1], line[2], Double.parseDouble(line[3]));
				System.out.println(btree.get(newbook));
				break;
			}
		}
	}
}