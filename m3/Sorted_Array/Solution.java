import java.util.Scanner;
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
        int size1, size2;
        Scanner sc = new Scanner(System.in);
        size1 = sc.nextInt();
        size2 = sc.nextInt();
        String[] arraystring1 = new String[size1];
        if (size1 > 0) {
            arraystring1 = sc.next().split(",");
        } else {
            sc.nextLine();
        }
        String[] arraystring2 = sc.next().split(",");
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int newsize = size1 + size2;
        int[] res = new int[newsize];
        for (int j = 0; j < size1; j++) {
            arr1[j] = Integer.parseInt(arraystring1[j]);
        }
        for (int j = 0; j < size2; j++) {
            arr2[j] = Integer.parseInt(arraystring2[j]);
        }
        int first = 0, second = 0;
        for (int i = 0; i < newsize; i++) {
            if (size1 > 0 && size2 > 0 && first < arr1.length
                && second < arr2.length) {
                if (arr1[first] > arr2[second]) {
                    res[i] = arr2[second];
                    second++;
                } else if (arr1[first] < arr2[second]) {
                    res[i] = arr1[first];
                    first++;
                } else {
                    res[i] = arr1[first];
                    first++;
                    i++;
                    res[i] = arr2[second];
                    second++;
                }
            } else {
                if (arr1.length > arr2.length) {
                    res[i] = arr1[first];
                    first++;
                } else {
                    res[i] = arr2[second];
                    second++;
                }
            }
        }
        for (int i = 0; i < newsize - 1; i++) {
            System.out.print(res[i] + ",");
        } System.out.print(res[newsize - 1]);
    }
}
