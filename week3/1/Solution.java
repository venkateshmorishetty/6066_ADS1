import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
	/**
	 * { name of the student }.
	 */
	private String name;
	/**
	 * score.
	 */
	private double score;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { name  }
	 * @param      s     { score }
	 */
	public Student(final String n, final double s) {
		name = n;
		score = s;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the score.
	 *
	 * @return     The score.
	 */
	public double getScore() {
		return score;
	}
}
/**
 * { solution class }.
 */
final class Solution {
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearProbingHashST<Integer, Student> linear = new LinearProbingHashST
		<Integer, Student>();
		int total = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < total; i++) {
			String[] studentinfo = sc.nextLine().split(",");
			linear.put(Integer.parseInt(studentinfo[0]),
				new Student(studentinfo[1],
					Double.parseDouble(studentinfo[2])));
		}
		int output = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < output; i++) {
			String[] temp = sc.nextLine().split(" ");
			Student t = linear.get(Integer.parseInt(temp[1]));
			if (t == null) {
				System.out.println("Student doesn't exists...");
			} else {
				if (Integer.parseInt(temp[2]) == 1) {
					System.out.println(t.getName());
				} else if (Integer.parseInt(temp[2]) == 2) {
					System.out.println(t.getScore());
				}
			}

		}
	}

}