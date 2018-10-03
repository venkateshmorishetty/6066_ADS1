import java.util.Scanner;
class merge {

	public void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length - 1);
		assert isSorted(a);
	}

	public void insertionsort(Comparable[] a, int low, int high) {
		for(int i = low; i <= high; i++) {
			for(int j = i; j > low && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	public void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	public void sort(Comparable[] array, Comparable[] aux, int low, int high) {
		if(high <= low + 7) {
			insertionsort(aux, low, high);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = (low + high) / 2;
		sort(aux, array, low, mid);
		sort(aux, array, mid + 1, high);
		if(!less(array[mid + 1], array[mid])) {
			for(int t = low; t <= high; t++) {
				aux[t] = array[t];
			}
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(array, aux, low, mid, high);
	}
	public void  merge(Comparable[] array, Comparable[] aux, int low,int  mid, int high) {
			assert isSorted(array, low, mid);
			assert isSorted(array, mid + 1, high);
			int i = low, j = mid + 1;
			for(int k = low; k <= high; k++) {
				if(i>mid) aux[k] = array[j++];
				else if(j>high) aux[k] = array[i++];
				else if(less(array[j], array[i])) aux[k] = array[j++];
				else aux[k] = array[i++];
			}
			assert isSorted(aux, low, high);
		
	}
	public boolean less(Comparable first, Comparable sec) {
	
		return first.compareTo(sec) < 0;
	}
	public boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}
	public boolean isSorted(Comparable[] array, int low, int high) {
		for(int i = low + 1; i <= high; i++) {
			if(less(array[i], array[i - 1])) {
				return false;
			}
		}
		return true;
	}
	public String show(Object[] aux) {
		String result = "[";
		for(int i = 0; i < aux.length - 1; i++) {
			result +=  aux[i]+", ";
		} result += aux[aux.length - 1] + "]";
		return result;
	}

}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		merge m = new merge();
		while(sc.hasNext()) {
			String[] a = sc.nextLine().split(",");
			m.sort(a);
			System.out.println(m.show(a));
			System.out.println();
		}
	}
}