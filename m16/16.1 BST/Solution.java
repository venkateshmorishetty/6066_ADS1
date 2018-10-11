import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
    /**
     * { name of the book }.
     */
    private String name;
    /**
     * { author name }.
     */
    private String author;
    /**
     * { price of the book }.
     */
    private Double price;
    /**
     * Constructs the object.
     *
     * @param      n     { name }
     * @param      a     { author }
     * @param      p     { price }
     */
    Book(final String n, final String a, final double p) {
        name = n;
        author = a;
        price = p;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public Double getPrice() {
        return price;
    }
}
/**
 * Class for node.
 *
 * @param      <Value>  The value
 */
class Node<Value> {
    /**
     * { left node address }.
     */
    private Node left = null;
    /**
     * { book key }.
     */
    private Book book;
    /**
     * { qty value }.
     */
    private Value qty;
    /**
     * { right node address }.
     */
    private Node right = null;
    /**
     * Constructs the object.
     *
     * @param      b     { key }
     * @param      q     { value }
     */
    Node(final Book b, final Value q) {
        qty = q;
        book = b;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Gets the qty.
     *
     * @return     The qty.
     */
    public Value getQty() {
        return qty;
    }
    /**
     * Gets the book.
     *
     * @return     The book.
     */
    public Book getBook() {
        return book;
    }
    /**
     * Sets the right.
     *
     * @param      n     { set the right node address }
     */
    public void setRight(final Node n) {
        right = n;
    }
    /**
     * Sets the left.
     *
     * @param      n     { set left node address }
     */
    public void setLeft(final Node n) {
        left = n;
    }
    /**
     * Sets the qty.
     *
     * @param      q     The quarter
     */
    public void setQty(final Value q) {
        qty = q;
    }
}
/**
 * Class for binary search tree.
 *
 * @param      <Value>  The value
 */
class BinarySearchTree<Value> {
    /**
     * { head of bst }.
     */
    private Node head = null;
    /**
     * { put the element into bst }.
     * { time complexity to put a node in bst is O(n) because
     *  in the ascending order the tree will grow only on one
     *  side that is the worst case }
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final int value) {
        Node<Integer> n = new Node<Integer>(key, value);
        if (head == null) {
            head = n;
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                int check = n.getBook().getName().compareTo(
                    temp.getBook().getName());
                if (check > 0) {
                    if (temp.getRight() == null) {
                        temp.setRight(n);
                        return;
                    }
                    temp = temp.getRight();
                } else if (check < 0) {
                    if (temp.getLeft() == null) {
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
    /**
     * { get the qty of book }.
     * { time complexity to get an element from bst in worst case
     *  is O(n) because in worst case tree will grows only in one
     *  so if the rquired node is last node than it will take O(n)}
     * @param      b     { given book }
     *
     * @return     { qty of the given book }
     */
    public Value get(final Book b) {
        Node temp = head;
        while (temp != null) {
            int check = b.getName().compareTo(
                temp.getBook().getName());
            if (check < 0) {
                temp = temp.getLeft();
            } else if (check > 0) {
                temp = temp.getRight();
            } else {
                return (Value) temp.getQty();
            }
        }
        return null;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Integer> btree = new
        BinarySearchTree<Integer>();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            switch (line[0]) {
                case "put":
                Book b = new Book(line[1], line[2],
                    Double.parseDouble(line[2 + 1]));
                btree.put(b, Integer.parseInt(line[2 + 2]));
                break;
                case "get":
                Book newbook = new Book(line[1], line[2],
                    Double.parseDouble(line[2 + 1]));
                System.out.println(btree.get(newbook));
                break;
                default:
                break;
            }
        }
    }
}
