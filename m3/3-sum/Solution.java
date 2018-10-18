import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for three sum.
 */
class ThreeSum {
    /**
     * { three sum count }.
     *
     * @param      arr   The arr
     *
     * @return     { count of possible combinations of
     * three values which their sum gives zero}.
     */
    public int ThreeSumcount(final int[] arr) {
        int count = 0;
        int j, k, sum;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            k = arr.length - 1;
            j = i + 1;
            while (j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    k--;
                    count++;
                    j++;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
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
        //pass
    }
    /**
     * { solution class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.ThreeSumcount(arr));
    }
}
