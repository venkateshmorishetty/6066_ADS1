import java.io.*;
import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int count =0;
		int[] arr = new int[size];
		// int k;
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i =0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				// k = j+1;
				// System.out.println(arr[i] +"   " +arr[j]+"    "+arr[k]);
				// if(arr[i]+arr[j]+arr[k]==0) {
				// 	count++;
				// 	k++;
				// } else {
				// 	k++;
				// }
				for(int k = j+1; k<arr.length; k++){
					if(arr[i]+arr[j]+arr[k] == 0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}