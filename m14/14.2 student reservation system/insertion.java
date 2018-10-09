import java.util.Comparator;
/**
 * Class for insertion.
 */
class insertion {
	/**
	 * { insertion class }.
	 *
	 * @param      students    The students
	 * @param      size        The size
	 * @param      comparator  The comparator
	 */
	public insertion() {
		//constructor
	}
	/**
	 * { performs insertion sort }.
	 * { time complexity for insertion sort is O(n^2) because there is a nested loop }
	 * @param      students    The students
	 * @param      size        The size
	 * @param      comparator  The comparator
	 */
	public void sort(final student[] students, final int size,
		final Comparator comparator) {
		student temp;
		for(int i = 1; i < size; i++) {
			temp = students[i];
			int j = i - 1;
			while (j >= 0 && comparator.compare(students[j], temp) < 0) {
				students[j+1] = students[j];
				j--;
			}
			students[j+1] = temp;
		}
	}
}