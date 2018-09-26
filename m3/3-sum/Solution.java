import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int count =0;
		int[] arr = new int[size];
		int j,k,sum;
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i =0; i < arr.length-1; i++) {
			k = arr.length-1;

			j=i+1;
			while(j<k){
				sum = arr[i]+arr[j]+arr[k];
				if(sum == 0){
					k--;
					count++;
					j++;
				}
				else if(sum < 0) {
					j++;
				}
				else {
					k--;
				}	

			}
				
		}
		System.out.println(count);
	}
}