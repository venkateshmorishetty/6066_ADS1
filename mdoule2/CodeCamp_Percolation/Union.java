/**
 * { union }.
 */
import java.io.*;
import java.util.Scanner;
/**
 * Class for union.
 */
class Union {
    private int[] arr;
    private int[] sz;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    public Union(final int size) {
        arr = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            sz[i] = 1;
            arr[i] = i;
        }
    }
    /**
     * { determines parent of given node }.
     *
     * @param      val   The value
     *
     * @return     { returns parent node }
     */
    public int root(int val) {
        while (arr[val] != val) {
            val = arr[val];
        }
        return val;
    }
    /**
     * { weighted union function }.
     *
     * @param      val1  The value 1
     * @param      val2  The value 2
     */
    public void weightedunion(final int val1, final int val2) {
        int p1 = root(val1);
        int p2 = root(val2);
        if (sz[p1] < sz[p2]) {
            arr[p1] = p2;
            sz[p2] += sz[p1];
        } else {
            arr[p2] = p1;
            sz[p1] += sz[p2];
        }
    }
    /**
     * Determines if connected.
     *
     * @param      val1  The value 1
     * @param      val2  The value 2
     *
     * @return     True if connected, False otherwise.
     */
    public boolean isConnected(final int val1, final int val2) {
        return root(val1) == root(val2);
    }
}