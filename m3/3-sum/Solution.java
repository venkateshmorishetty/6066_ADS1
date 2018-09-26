import java.util.Scanner;
import java.util.Arrays;
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
        int count = 0;
        int[] arr = new int[size];
        int j, k, sum;
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
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
        System.out.println(count);
    }
}