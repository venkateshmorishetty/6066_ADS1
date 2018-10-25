import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * { data }.
     */
    private String data;
    int count = 1;
    /**
     * { next node address }.
     */
    private Node next = null;
    /**
     * Constructs the object.
     *
     * @param      d     { data of node }
     */
    Node(final String d) {
        data = d;
    }
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public String getData() {
        return data;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }
    /**
     * Sets the next.
     *
     * @param      n     { next node address }
     */
    public void setNext(final Node n) {
        next = n;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int c) {
        count = c;
    }
}
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { head of linked list }.
     */
    private Node head = null;
    /**
     * Gets the head.
     *
     * @return     The head.
     */
    public Node getHead() {
        return head;
    }
    /**
     * { add new node to linked list }.
     *
     * @param      word  The word
     */
    public void insert(final String word) {
        Node newnode = new Node(word);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            int f = 0;
            while (temp != null) {
                if (temp.getData().equals(word)) {
                    f = 1;
                    temp.setCount(temp.getCount() + 1);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            if (f == 0) {
                newnode.setNext(head);
                head = newnode;
            }
        }
    }
}
/**
 * Class for hashing.
 */
class Hashing {
    /**
     * { hash table of lonked list objects }.
     */
    private Linkedlist[] hash;
    /**
     * { size }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      s     { size of hash table }.
     */
    Hashing(final int s) {
        size = s;
        hash = new Linkedlist[s];
    }
    /**
     * { position of given word }.
     *
     * @param      value  The value
     *
     * @return     { returns the position of word in hash table }
     */
    public int key(final String value) {
        return Math.abs(value.hashCode() % size);
    }
    /**.
     * { insert into hash table }
     *
     * @param      word  The word
     * @param      pos   The position
     */
    public void insert(final String word, final int pos) {
        if (hash[pos] == null) {
            Linkedlist l = new Linkedlist();
            l.insert(word);
            hash[pos] = l;
        } else {
            hash[pos].insert(word);
        }
    }
    /**
     * Gets the hash.
     *
     * @return     The hashtable.
     */
    public Linkedlist[] getHash() {
        return hash;
    }
}
/**
 * Class for ransom note.
 */
class RansomNote {
    /**
     * { magazine size }.
     */
    private int msize;
    /**
     * { note size }.
     */
    private int nsize;
    /**
     * { magazine }.
     */
    private String[] magazine;
    /**
     * { note }.
     */
    private String[] note;
    /**
     * { hashing class varaible }.
     */
    private Hashing h;
    /**
     * Constructs the object.
     *
     * @param      ms    { magazine size }
     * @param      ns    { note size }
     * @param      m     { magazine }
     * @param      n     { note }
     */
    RansomNote(final int ms, final int ns, final String[] m,
               final String[] n) {
        msize = ms;
        nsize = ns;
        magazine = m;
        note = n;
        h = new Hashing(msize);
    }
    /**
     * { creates the hashtable for magazine }.
     */
    public void creatingHashtable() {
        for (int i = 0; i < msize; i++) {
            int pos = h.key(magazine[i]);
            h.insert(magazine[i], pos);
        }
    }
    /**
     * { checks whether magazine contain all words of note }.
     */
    public void checking() {
        Linkedlist[] hashtable = h.getHash();
        for (int i = 0; i < nsize; i++) {
            int pos = h.key(note[i]);
            int flag = 0;
            Node temp = hashtable[pos].getHead();
            while (temp != null) {
                if (temp.getData().equals(note[i])) {
                    if (temp.getCount() > 0) {
                        flag = 1;
                        temp.setCount(temp.getCount() - 1);
                        break;
                    } else {
                        System.out.println("No");
                        return;
                    }
                } else {
                    temp = temp.getNext();
                }
            } if (flag == 0) {
                System.out.println("No");
                return;
            }

        }
        System.out.println("Yes");
    }

}
/**.
 * { Solution class }
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor
    }
    /**
     * { main class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int msize = sc.nextInt();
        int nsize = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        RansomNote r = new RansomNote(msize, nsize, magazine, note);
        r.creatingHashtable();
        r.checking();
    }
}
