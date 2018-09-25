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
     * { function_description }.
     *
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    public int root(int val) {
        while (arr[val] != val) {
            val = arr[val];
        }
        return val;
    }
    /**
     * { function_description }.
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
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { var_description }.
     */
    private int[][] percolation;
    /**
     * { var_description }.
     */
    private int count;
    /**
     * { var_description }.
     */
    private Union u;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        percolation = new int[n][n];
        size = n;
        u = new Union(n * n + 2);
        count = 0;
    }
    /**
     * { function_description }.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        if (percolation[row][col] == 1) {
            return;
        }
        percolation[row][col] = 1;
        count++;
        // //top
        if (row - 1 >= 0 && percolation[row - 1][col] == 1) {
            u.weightedunion(size * row + col, size * (row - 1) + col);
        }
        //bottom
        if (row + 1 < size && percolation[row + 1][col] == 1) {
            u.weightedunion(size * row + col, size * (row + 1) + col);
        }
        //right
        if (col - 1 >= 0 && percolation[row][col - 1] == 1) {
            u.weightedunion(size * row + col, size * row + (col - 1));
        }
        //left
        if (col + 1 < size && percolation[row][col + 1] == 1) {
            u.weightedunion(size * row + col, size * row + (col + 1));
        }
        if (row == 0) {
            u.weightedunion(size * row + col, size * size);
        }
        if (row == size - 1) {
            u.weightedunion(size * row + col, size * size + 1);
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        if (percolation[row][col] == 1) {
            return true;
        }
        return false;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int numberOfOpenSites() {
        return count;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolate() {
        return u.isConnected(size * size, size * size + 1);
    }
}
/**
 * main class for percolation.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        //constructor for solution.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        while (sc.hasNext()) {
            p.open(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        System.out.println(p.percolate());
    }
}