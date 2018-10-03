import java.util.Scanner;
/**
 * Class for merge.
 */
class merge {
	/**
	 * { checks array is sorted or not }.
	 *
	 * @param      a     { array }
	 */
	public void sort(final Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length - 1);
		assert isSorted(a);
	}
	/**
	 * { insertion sort }.
	 *
	 * @param      a     { array }
	 * @param      low   The low
	 * @param      high  The high
	 */
	public void insertionsort(final Comparable[] a, final int low, final int high) {
		for(int i = low; i <= high; i++) {
			for(int j = i; j > low && less(a[j], a[j - 1]); j--) {
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
	public void exch(final Object[] a, final int i, final int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	/**
	 * { sort method }.
	 *
	 * @param      array  The array
	 * @param      aux    The auxiliary
	 * @param      low    The low
	 * @param      high   The high
	 */
	public void sort(final Comparable[] array, final Comparable[] aux,
		final int low, final int high) {
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
	/**
	 * { merges two sub arrays }.
	 *
	 * @param      array  The array
	 * @param      aux    The auxiliary
	 * @param      low    The low
	 * @param      mid    The middle
	 * @param      high   The high
	 */
	public void  merge(final Comparable[] array, final Comparable[] aux, final int low,
		final int  mid, final int high) {
			assert isSorted(array, low, mid);
			assert isSorted(array, mid + 1, high);
			int i = low, j = mid + 1;
			for (int k = low; k <= high; k++) {
				if (i > mid) aux[k] = array[j++];
				else if (j > high) aux[k] = array[i++];
				else if (less(array[j], array[i])) aux[k] = array[j++];
				else aux[k] = array[i++];
			}
			assert isSorted(aux, low, high);
		
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
	 * @param      a     { parameter_description }
	 *
	 * @return     True if sorted, False otherwise.
	 */
	public boolean isSorted(final Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
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
	/**
	 * { display sorted array }.
	 *
	 * @param      aux   The auxiliary
	 *
	 * @return     { string }
	 */
	public String show(final Object[] aux) {
		String result = "[";
		for (int i = 0; i < aux.length - 1; i++) {
			result +=  aux[i] + ", ";
		} result += aux[aux.length - 1] + "]";
		return result;
	}

}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
		//constructor.
	}
	/**
	 * { main method }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		merge m = new merge();
		while (sc.hasNext()) {
			String[] a = sc.nextLine().split(",");
			m.sort(a);
			System.out.println(m.show(a));
			System.out.println();
		}
	}
}