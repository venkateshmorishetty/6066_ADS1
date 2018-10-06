import java.util.*;
class student {
	String name;
	Date birth;
	int marks1;
	int marks2;
	int marks3;
	int totalscore;
	String cast;
	public student(String n, Date d, int m1, int m2, int m3, int total, String cat) {
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
				return s1.birth.compareTo(s2.birth);
			}
		}
	};


	static Comparator<student> reservationComparator = new Comparator<student>() {
		public int compare(student s1, student s2) {
			if(s1.totalscore - s2.totalscore != 0) {
				return s1.totalscore - s2.totalscore;
			} 
			return s1.cast.compareTo(s2.cast);
		}
	};
	static Comparator<student> secondComparator = new Comparator<student>() {
		public int compare(student s1, student s2) {
			if(s1.cast.compareTo(s2.cast)!=0) {
				return s1.cast.compareTo(s2.cast);
			} 
			return s1.totalscore - s2.totalscore;
		}
	};
}