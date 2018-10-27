import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
	/**
	 * { capacity }.
	 */
    private static final int CAPACITY = 2;
    /**
     * { number of keys }.
     */
    private int n;
    /**
     * { size of array }.
     */
    private int m;
    /**
     * { keys array }.
     */
    private Key[] keys;
    /**
     * { values array }.
     */
    private Value[] values;
    /**
     * Constructs the object.
     */
    public LinearProbingHashST() {
        this(CAPACITY);
    }
    /**
     * Constructs the object.
     *
     * @param      s     { size }
     */
    public LinearProbingHashST(int s) {
        m = s;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }
    /**
     * { size }
     *
     * @return     { size }
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * { checks is key in array }.
     *
     * @param      key   The key
     *
     * @return     { true or false }
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * { generate hash value }.
     *
     * @param      key   The key
     *
     * @return     { hash value of given key }
     */
    private int hash(Key key) {
        return (key.hashCode() * 11) % m;
    }
    /**
     * { resize array }
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m    = temp.m;
    }
    /**
     * { put given key }
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        n++;
    }
    /**
     * { get the value of given key }.
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }
    /**
     * { return all keys }
     *
     * @return     { keys }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
    /**
     * { delete given key }
     *
     * @param      key   The key
     */
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   k = keys[i];
            Value v = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(k, v);
            i = (i + 1) % m;
        }
        n--;
        if (n > 0 && n <= m/8) resize(m/2);
    }
    /**
     * { display given the hash table }.
     */
    public void display() {
    	if(size() == 0) {
    		System.out.println("{}");
    	} else {
    		String s = "";
    		 for (Key s1: keys()) {
                        s += s1 + ":" + get(s1) + ", ";
                    }
    		System.out.println("{" + s.substring(
                        0, s.length() - 2) + "}");
    	}
    }
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
		//constructor
	}
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearProbingHashST<String, Integer> ht =
		new LinearProbingHashST<String, Integer>();
		while (sc.hasNext()) {
			String[] input = sc.nextLine().split(" ");
			switch (input[0]) {
			case "put":
				ht.put(input[1], Integer.parseInt(input[2]));
				break;
			case "get":
				System.out.println(ht.get(input[1]));
				break;
			case "delete":
				ht.delete(input[1]);
				break;
			case "display":
				ht.display();
				break;
			default:
				break;
			}
		}
	}
}