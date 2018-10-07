import java.util.Scanner;
/**
 * Class for quick.
 */
class Quick {
    /**
     * { insertion sort }.
     * { time complexity for insertion sort is O(n^2) becuse
     * it uses nested loop}
     * @param      a     { array }
     * @param      low   The low
     * @param      high  The high
     */
    public void insertionsort(final Comparable[] a, final int low,
        final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * { exchanges }.
     *
     * @param      a     { array }
     * @param      i     { first value }
     * @param      j     { second value }
     */
    public void exch(final Comparable[] a, final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * { sort method }.
     * { time complexity for sort is log(n)}.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(final Comparable[] array, final int low,
        final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertionsort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int temp = partition(array, low, high);
        System.out.println(toString(array));
        sort(array, low, temp - 1, cutOff);
        sort(array, temp + 1, high, cutOff);
    }
    /**
     * { partition function }.
     *
     * @param      a     { parameter_description }
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(final Comparable[] a, final int low,
        final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(a[++i], a[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(a[low], a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      a     { parameter_description }
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] a) {
        String str = "[";
        for (int i = 0; i < a.length - 1; i++) {
            str += a[i]+", ";
        }
        str += a[a.length - 1] + "]";
        return str;
    }
    /**
     * { sort function }.
     *
     * @param      array   The array
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    /**
     * { less function }.
     *
     * @param      first  The first
     * @param      sec    The security
     *
     * @return     { return true if less or false }
     */
    public boolean less(final Comparable first, final Comparable sec) {

        return first.compareTo(sec) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] array, final int low,
                            final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**.
     * { main method }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Quick q = new Quick();
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            int j = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String[] tokens = s.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                q.sort(tokens, j);
                System.out.println(q.toString(tokens));
            }
        }
    }
}
