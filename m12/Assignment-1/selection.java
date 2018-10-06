import java.util.*;
class selection {
	public void sort(student[] info, int size, Comparator comparator) {
		int min;
		for(int i = 0; i < size - 1; i++) {
			min = i;
			for(int j = i + 1; j < size; j++) {
				if(comparator.compare(info[j],info[min]) > 0) {
					min = j;
				}
			}
			student temp = info[min];
			info[min] = info[i];
			info[i] = temp;
		}
	}
}