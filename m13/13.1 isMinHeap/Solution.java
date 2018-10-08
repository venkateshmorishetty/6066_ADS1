import java.util.*;
import java.lang.*;
class Heap<E extends Comparable<E>> {
	public boolean isMinHeap(E[] arr) {
		int index = arr.length - 1;
		// System.out.println(Arrays.toString(arr));
		while(index > 1) {
			// System.out.println(arr[index] +"    "+arr[index/2]);
			if(arr[index].compareTo(arr[index/2])>=0) {
				index = index - 1;
			} else {
				return false;
			}
		}
		return true;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();
		int testcases = Integer.parseInt(sc.nextLine());
		switch(type) {
			case "String":
			Heap<String> heap = new Heap<String>();
			for(int i = 0; i < testcases; i++) {
				String[] arr = sc.nextLine().split(",");
				String[] a = new String[arr.length+1];
				int temp = 1;
				for(int k = 0; k < arr.length; k++) {
					a[temp++] = arr[k];
				}
				System.out.println(heap.isMinHeap(a));
			}
			break;
			case "Float":
			Heap<Float> floatobj = new Heap<Float>();
			for(int i = 0; i < testcases; i++) {
				try{
					String[] arr = sc.nextLine().split(",");
					Float[] a = new Float[arr.length+1];
					int temp = 1;
					for(int k = 0; k < arr.length; k++) {
						a[temp++] = Float.parseFloat(arr[k]);
					}
					System.out.println(floatobj.isMinHeap(a));	
				} catch(Exception e) {
					System.out.println("false");
				}
			}
			break;
			case "Integer":
			Heap<Integer> intobj = new Heap<Integer>();
			for(int i = 0; i < testcases; i++) {
				String[] arr = sc.nextLine().split(",");
				Integer[] a = new Integer[arr.length + 1];
				int temp = 1;
				for(int k = 0; k < arr.length; k++) {
					a[temp++] = Integer.parseInt(arr[k]);
				}
				System.out.println(intobj.isMinHeap(a));
			}
			break;
			case "Double":
			Heap<Double> doubleobj = new Heap<Double>();
			for(int i = 0; i < testcases; i++) {
				String[] arr = sc.nextLine().split(",");
				Double[] a = new Double[arr.length + 1];
				int temp = 1;
				for(int k = 0; k < arr.length; k++) {
					a[temp++] = Double.parseDouble(arr[k]);
				}
				System.out.println(doubleobj.isMinHeap(a));
			}
			break;
			default:
			break;
		}
	}
}