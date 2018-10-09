import java.util.*;
class student {
	String name;
	int[] birth;
	int marks1;
	int marks2;
	int marks3;
	int totalscore;
	String cast;
	public student(String n, int[] d, int m1, int m2, int m3, int total, String cat) {
		name = n;
		birth = d;
		marks1 = m1;
		marks2 = m2;
		marks3 = m3;
		totalscore = total;
		cast = cat;
	}


	static Comparator<student> meritCompartor = new Comparator<student>() {
		public int compare(student s1, student s2) {
			if(s1.totalscore - s2.totalscore != 0) {
				return s1.totalscore - s2.totalscore;
			}
			else if(s1.marks3 - s2.marks3 != 0) {
				return s1.marks3 - s2.marks3;
			} else if(s1.marks2 - s2.marks2 != 0) {
				return s1.marks2 - s2.marks2;
			} else {
				if (s2.birth[2] - s2.birth[2] != 0) {
					return s2.birth[2] - s1.birth[2];
				} else {
					int count = 2 * 2 + (2 + 1);
					return (((count - s1.birth[1]) * 30) - ((count - s2.birth[1]) * 30));
				}
			}
		}
	};
}