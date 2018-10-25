import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * { data }.
     */
    String data;
    /**
     * { next node address }.
     */
    Node next = null;
    /**
     * Constructs the object.
     *
     * @param      d     { data of node }
     */
    public Node (final String d) {
        data = d;
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
            newnode.next = temp;
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
    public Hashing(int s) {
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
    Hashing h;
    /**
     * Constructs the object.
     *
     * @param      ms    { magazine size }
     * @param      ns    { note size }
     * @param      m     { magazine }
     * @param      n     { note }
     */
    public RansomNote(int ms, int ns, String[] m, String[] n) {
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
                if (temp.data.equals(note[i])) {
                    f = 0;
                    temp = temp.next;
                    continue;
                } else {
                    while (temp.next != null) {
                        if (temp.next.data.equals(note[i])) {
                            f = 0;
                            temp.next = temp.next.next;
                            break;
                        } else {
                            temp = temp.next;
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