import java.util.Scanner;
final class minST<Key extends Comparable<Key>> {
   private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private int[] values;
    private int size = 0;

    /**
     * Initializes an empty symbol table.
     */
    public minST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public minST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        values = new int[capacity]; 
    }   

    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= size;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        int[] tempv = new int[capacity];
        for (int i = 0; i < size; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
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
     * { time complexity to put element into symbol table is O(logn) }
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final int value) {
        // System.out.println("key is "+key+"   "+value);
        boolean check = contains(key);
        if (size == 0) {
            keys[size] = key;
            values[size] = 1;
            size++;
            return;
        }
        if(!check){
        	keys[size] = key;
        	values[size] = 1;
        	size++;
        	if (size == keys.length) resize(2*keys.length);
        } else {
        	int i = rank(key);
        	values[i] = values[i] + 1; 
        }
    }
    public boolean contains(Key key) {
        for(int i = 0; i < size; i++) {
        	if(keys[i].equals(key)) return true;
        }
        return false;
    }
    /**
     * { get the value of given key }.
     * { time complexity for get is O(1)}
     * @param      key   The key
     *
     * @return     { return value if key is in symbol table else null }
     */
    public int get(final Key k) {
        // int i = rank(k);
        // if (keys[i].compareTo(k) == 0) {
        //     return values[i];
        // } else {
        //     return 0;
        // }
        // // 
        for(int i = 0; i < size; i++) {
        	if(keys[i].equals(k)) {
        		return values[i];
        	}
        }
        return 0;
    }
    
    public void deleteMin() {
        for (int j = 0; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        keys[size] = null;
        values[size] = 0;
        size--;
    }
}