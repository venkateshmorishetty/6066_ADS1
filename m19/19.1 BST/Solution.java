import java.util.Scanner;
/**
 * Class for book details.
 */
class Book implements Comparable {
    /**
     * book name.
     */
    private String name;
    /**
     * author name.
     */
    private String author;
    /**
     * price of the book.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      n     { name }
     * @param      a     { author name }
     * @param      p     { price }
     */
    Book(final String n,
                final String a, final float p) {
        name = n;
        author = a;
        price = p;
    }
    /**
     * gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * returns the author name.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * returns the price of book.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * compare to method.
     *
     * @param      object  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object object) {
        Book that = (Book) object;
        return this.name.compareTo(that.name);
    }
    /**
     * to string method.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * class for binary search tree.
 */
class BinarySearchTree {
    /**
     * root.
     */
    private Node root;
    /**
     * class for node.
     */
    private final class Node {
        /**.
         * key
         */
        private Book key;
        /**
         * val.
         */
        private int value;
        /**
         * leftchild.
         */
        private Node leftchild;
        /**
         * rightchild.
         */
        private Node rightchild;
        /**
         * size.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      k     { key }
         * @param      v     { value }
         * @param      s     { size }
         */
        private Node(final Book k, final int v, final int s) {
            this.key = k;
            this.value = v;
            this.size = s;
            leftchild = null;
            rightchild = null;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * {size method}.
     *
     * @return size.
     */
    public int size() {
        return size(root);
    }
    /**
     * {size function}.
     *
     * @param      x Node
     *
     * @return size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * { get function }.
     *
     * @param      key   The key
     *
     * @return     { returns value }
     */
     public int get(final Book key) {
        return get(root, key);
    }
    /**
     * { get function }.
     * { time complexity is log(n)}
     * @param      x     { root }
     * @param      key   The key
     *
     * @return     { value of given key }
     */
    private int get(final Node x, final  Book key) {
        if (x == null) {
            return -1;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
            return get(x.leftchild, key);
        } else if (cmp > 0) {
            return get(x.rightchild, key);
        } else {
            return x.value;
        }
    }
    /**
     * { put }.
     * time complexity is log(n)
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final int value) {
        root = put(root, key, value);
    }
    /**.
     * { put function }
     *
     * @param      x      { root }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { node }
     */
    private Node put(final Node x, final Book key, final int value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int check = key.compareTo(x.key);
        if (check < 0) {
            x.leftchild = put(x.leftchild, key, value);
        } else if (check > 0) {
            x.rightchild = put(x.rightchild, key, value);
        } else if (check == 0) {
            x.value = value;
        }
        return x;
    }
    /**
     * {minimum function}.
     * @return minimum.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * {minimum function}.
     * Time complexity is log(n)
     * @param      x Node
     *
     * @return minimum.
     */
    private Node min(final Node x) {
        if (x.leftchild == null) {
            return x;
        } else {
            return min(x.leftchild);
        }
    }
    /**
     * {maximum function}.
     * @return maximum.
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * {maximum function}.
     * time complexity is log(n)
     * @param      x Node
     *
     * @return maximum.
     */
    private Node max(final Node x) {
        if (x.rightchild == null) {
            return x;
        } else {
            return max(x.rightchild);
        }
    }
    /**
     * {floor function}.
     * time complexity is log(n).
     * @param      key   The key
     *
     * @return  key
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     *
     * {floor function}.
     * time complexity is log(n).
     * @param      x Node
     * @param      key   The key
     *
     * @return floor.
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int check = key.compareTo(x.key);
        if (check == 0) {
            return x;
        }
        if (check <  0) {
            return floor(x.leftchild, key);
        }
        Node temp = floor(x.rightchild, key);
        if (temp != null) {
            return temp;
        } else {
            return x;
        }
    }
    /**
     * {ceil function}.
     * time complexity is log(n)
     * @param      key   The key
     *
     * @return key.
     */
    public Book ceil(final Book key) {
        Node x = ceil(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * {ceil function}.
     * time complexity is log(n)
     * @param      x Node
     * @param      key   The key
     *
     * @return     return ceiling value.
     */
    private Node ceil(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int check = key.compareTo(x.key);
        if (check == 0) {
            return x;
        }
        if (check < 0) {
            Node temp = ceil(x.leftchild, key);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
        return ceil(x.rightchild, key);
    }
    /**
     * {select method}.
     * time complexity is log(n).
     * @param      k     Integer
     *
     * @return     Book Object
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * {select method}.
     * Time complexity is log(n)
     * @param      x     {Node}
     * @param      k     {Integer}
     *
     * @return     {Node}
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int temp = size(x.leftchild);
        if (temp > k) {
            return select(x.leftchild,  k);
        } else if (temp < k) {
            return select(x.rightchild, k - temp - 1);
        } else {
            return x;
        }
    }
    /**
     * {rank method}.
     * Time complexity is 1.
     * @param      key   The key
     *
     * @return     {Integer}
     */
    public int rank(final Book key) {
        return rank(key, root);
    }
    /**
     * {rank method}.
     * time complexity is log(n)
     * @param      key   The key
     * @param      x     Node variable.
     *
     * @return     Integer
     */
    private int rank(final Book key, final Node x) {
        if (x == null) {
            return 0;
        }
        int check = key.compareTo(x.key);
        if (check < 0) {
            return rank(key, x.leftchild);
        } else if (check > 0) {
            return 1 + size(x.leftchild) + rank(key, x.rightchild);
        } else {
            return size(x.leftchild);
        }
    }
}
/**
 * {solution class}.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree btree = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(",");
            switch (input[0]) {
            case "put":
            btree.put(new Book(input[1], input[2], Float.parseFloat(
                input[2 + 1])), Integer.parseInt(input[2 + 2]));
            break;
            case "get":
            if (btree.get(new Book(input[1], input[2],
                Float.parseFloat(input[2 + 1]))) == -1) {
                System.out.println("null");
            } else {
                System.out.println(btree.get(new Book(input[1], input[2],
                    Float.parseFloat(input[2 + 1]))));
            }
            break;
            case "max":
            System.out.println(btree.max());
            break;
            case "min":
            System.out.println(btree.min());
            break;
            case "floor":
            System.out.println(btree.floor(new Book(input[1], input[2],
                Float.parseFloat(input[2 + 1]))));
            break;
            case "ceiling":
            System.out.println(btree.ceil(new Book(input[1], input[2],
                Float.parseFloat(input[2 + 1]))));
            break;
            case "select":
            System.out.println(btree.select(Integer.parseInt(input[1])));
            break;
            default:
            break;
            }
        }
    }
}
