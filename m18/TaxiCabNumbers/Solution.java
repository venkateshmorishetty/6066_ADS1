import java.util.Scanner;
import java.lang.Comparable;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum>{
    int i;
    int j;
    int sum;
    /**
     * Constructs the object.
     *
     * @param      i     { i value }
     * @param      j     { j value }
     */
    public CubeSum(final int i, final int j) {
        this.i = i;
        this.j = j;
        sum = i*i*i + j*j*j;
    }
    /**
     * { compares two objects }.
     *
     * @param      that  The that
     *
     * @return     { return 0 if equal -1 if less else 1 }
     */
    public int compareTo(final CubeSum that) {
        return this.sum - that.sum;
    }
    /**
     * Gets the ival.
     *
     * @return     The ival.
     */
    public int getIval() {
        return i;
    }
    /**
     * Gets the jval.
     *
     * @return     The jval.
     */
    public int getJval() {
        return j;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
}
/**
 * { main class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor
    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int value1 = Integer.parseInt(input[0]);
        int value2 = Integer.parseInt(input[1]);
        TaxiNumbers(value1, value2);
    }
    /**
     * { taxinumbers }.
     *
     * @param      number        nth number
     * @param      combinations  The combinations
     */
    public static void TaxiNumbers(final int number, final int combinations) {
        final int n = 600;
        MinPQ<CubeSum> mp = new MinPQ<CubeSum>();
        for (int i = 0; i < n; i++) {
            mp.insert(new CubeSum(i, i));
        }
        int t = -1;
        int count = 0;
        int nthnumber = number;
        while (!mp.isEmpty()) {
            CubeSum temp = mp.delMin();
            if (t == temp.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == combinations - 1) {
                nthnumber--;
                if (nthnumber == 0) {
                    System.out.println(temp.sum);
                    break;
                }
            }
            t = temp.getSum();
            if (temp.getJval() < n) {
                mp.insert(new CubeSum(temp.getIval(),
                    temp.getJval() + 1));
            }
        }
    }
}