import java.util.Scanner;
import java.util.Comparator;
class student {
	/**
	 * { name variable }.
	 */
	String name;
	/**
	 * { birth }.
	 */
	int[] birth;
	/**
	 * { marks1 }.
	 */
	int marks1;
	/**
	 * { marks2 }.
	 */
	int marks2;
	/**
	 * { marks3 }.
	 */
	int marks3;
	/**
	 * { total score }.
	 */
	int totalscore;
	/**
	 * { cast }.
	 */
	String cast;
	/**
	 * Constructs the object.
	 *
	 * @param      n      { name }
	 * @param      d      { date of birth }
	 * @param      m1     The m 1
	 * @param      m2     The m 2
	 * @param      m3     The m 3
	 * @param      total  The total
	 * @param      cat    The cat
	 */
	public student(final String n, final int[] d, final int m1, final int m2,
		final int m3, final int total, final String cat) {
		name = n;
		birth = d;
		marks1 = m1;
		marks2 = m2;
		marks3 = m3;
		totalscore = total;
		cast = cat;
	}
	/**
	 * { comparator }.
	 */
	static Comparator<student> meritCompartor = new Comparator<student>() {
		public int compare(final student s1, final student s2) {
			if (s1.totalscore - s2.totalscore != 0) {
				return s1.totalscore - s2.totalscore;
			}
			else if (s1.marks3 - s2.marks3 != 0) {
				return s1.marks3 - s2.marks3;
			} else if (s1.marks2 - s2.marks2 != 0) {
				return s1.marks2 - s2.marks2;
			} else {
				if (s1.birth[2] - s2.birth[2] != 0) {
					return s1.birth[2] - s2.birth[2];
				} else {
					if (s1.birth[1] - s2.birth[1] != 0) {
						return s1.birth[1] - s2.birth[1];
				}					
				return s1.birth[0] - s2.birth[0];
				}
			}
		}
	};
}