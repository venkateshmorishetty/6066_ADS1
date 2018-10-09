import java.util.*;
class insertion {
	public void sort(student[] students, int size, Comparator comparator) {
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