import java.util.Scanner;
class Student {
	String name;
	double score;
	public Student(String n, double s) {
		name = n;
		score = s;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearProbingHashST<Integer, Student> linear = new LinearProbingHashST<Integer, Student>();
		int total = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < total; i++) {
			String[] studentinfo = sc.nextLine().split(",");
			linear.put(Integer.parseInt(studentinfo[0]), new Student(studentinfo[1],
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
					System.out.println(t.name);
				} else if (Integer.parseInt(temp[2]) == 2) {
					System.out.println(t.score);
				}
			}

		}
	}

}