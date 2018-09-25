
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { network }.
     */
    private int[][] percolation;
    /**
     * { count for number open in network }.
     */
    private int count;
    /**
     * { union class variable }.
     */
    private Union u;
    /**
     * { size for network }.
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
     * { to make element as open }.
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
     * { returns total number of opens in network }.
     *
     * @return     { number of opens }
     */
    public int numberOfOpenSites() {
        return count;
    }
    /**
     * { checks whether network is percolate or not }.
     *
     * @return     { true or false }
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
    private Solution() {
        //constructor for solution.
    }
    /**
     * { main function }.
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
