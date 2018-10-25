import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * { data }.
     */
    private String data;
    /**
     * { next node address }.
     */
    private Node next = null;
    /**
     * Constructs the object.
     *
     * @param      d     { data of node }
     */
    Node (final String d) {
        data = d;
    }
    public String getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
}
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { head of linked list }.
     */
    Node head = null;
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
            head = newnode;
            newnode.setNext(temp);
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
    Linkedlist[] hash;
    /**
     * { size }.
     */
    int size;
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
    int msize;
    /**
     * { note size }.
     */
    int nsize;
    /**
     * { magazine }.
     */
    String[] magazine;
    /**
     * { note }.
     */
    String[] note;
    /**
     * { hashing class varaible }.
     */
    Hashing h;
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
     * { checks whether magazine contain all words of letter }.
     */
    public void checking() {
        for (int i = 0; i < nsize; i++) {
            int pos = h.key(note[i]);
            Linkedlist[] hashtable = h.getHash();
            if (hashtable[pos] == null) {
                System.out.println("No");
                return;
            } else {
                Node temp = hashtable[pos].head;
                int f = 1;
                if (temp.getData().equals(note[i])) {
                    f = 0;
                    temp = temp.getNext();
                    continue;
                } else {
                    while (temp.getNext() != null) {
                        if (temp.getNext().getData().equals(note[i])) {
                            f = 0;
                            temp.setNext(temp.getNext().getNext());
                            break;
                        } else {
                            temp = temp.getNext();
                        }
                    }
                }
                if (f == 1) {
                    System.out.println("No");
                    return;
                }
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