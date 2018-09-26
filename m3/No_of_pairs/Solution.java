import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        int result = 0, j;
        int[] arr = {1, 2, 2, 3, 2, 3, 3, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            j = i + 1;
            if (arr[i] == arr[j]) {
                count++;
            } else {
                count++;
                result += count * (count - 1) / 2;
                count = 0;
            }
            j++;
        }
        if (count > 0) {
            count++;
            result += count * (count - 1) / 2;
        }
        System.out.println(result);
    }
}