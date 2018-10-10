import java.util.Scanner;
/**
 * Class for binary search symbol table.
 *
 * @param      <Comparable>  The comparable
 * @param      <Value>       The value
 */
class BinarySearchSymbolTable<Key extends Comparable, Value> {
    /**
     * { keys array }.
     */
    private Key[] keys;
    /**
     * { values array }.
     */
    private Value[] values;
    /**.
     * { size }
     */
    private int size = 0;
    /**
     * Constructs the object.
     *
     * @param      len   The length
     */
    BinarySearchSymbolTable(final int len) {
        keys = (Key[]) new Comparable[len];
        values = (Value[]) new Object[len];
    }
    /**
     * { to find the position of key or rank of key }.
     * { time complexity require to find rank is log(n) because it uses binary
     *  search }.
     * @param      k     { key }
     *
     * @return     { returns the position of given key in key array }
     */
    public int rank(final Key k) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (keys[mid].compareTo(k) < 0) {
                low = mid + 1;
            } else if (keys[mid].compareTo(k) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * { put the key int symbol table }.
     * { time complexity to put element into }
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (size == 0) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        for (int j = size; j > i; j--) {
            values[j] = values[j - 1];
            keys[j] = keys[j - 1];
        }
        values[i] = value;
        keys[i] = key;
        size++;
    }
    /**
     * { checks whether key is in symbol table or not }.
     *
     * @param      key   The key
     *
     * @return     { true if present false otherwise }
     */
    public boolean contains(final Key key) {
        int i = rank(key);
        return keys[i].compareTo(key) == 0;
    }
    /**
     * { returns floor of given key }.
     *
     * @param      key   The key
     *
     * @return     { returns largest key less than or equal given key }
     */
    public Key floor(final Key key) {
        int i = rank(key);
        if (keys[i].compareTo(key) == 0) {
            return keys[i];
        } else if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * { get the value of given key }.
     *
     * @param      key   The key
     *
     * @return     { return value if key is in symbol table else null }
     */
    public Value get(final Key key) {
        int i = rank(key);
        if (keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }
    /**
     * { prints the symbol table }.
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
    /**
     * { maximum key in symbol table }.
     *
     * @return     { maximum key in symbol table }
     */
    public Key max() {
        return keys[size - 1];
    }
    /**
     * { deletes minimum }.
     */
    public void deleteMin() {
        for (int j = 0; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        keys[size] = null;
        values[size] = null;
        size--;
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
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] keys = sc.nextLine().split(" ");
        BinarySearchSymbolTable<String, Integer> s = new BinarySearchSymbolTable
        <String, Integer>(keys.length);
        for (int i = 0; i < keys.length; i++) {
            s.put(keys[i], i);
        }
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
            case "max":
            System.out.println(s.max());
            break;
            case "floor":
            System.out.println(s.floor(input[1]));
            break;
            case "contains":
            System.out.println(s.contains(input[1]));
            break;
            case "get":
            System.out.println(s.get(input[1]));
            break;
            case "keys":
            s.keys();
            break;
            case "rank":
            System.out.println(s.rank(input[1]));
            break;
            case "deleteMin":
            s.deleteMin();
            default:
            break;
            }
        }
    }
}
