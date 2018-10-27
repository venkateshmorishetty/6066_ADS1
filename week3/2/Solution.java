import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
  
   	String name;
  
    int number;
    
    Student(int no,String n) {
        name = n;
        number = no;
    }

}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int data = Integer.parseInt(sc.nextLine());
		BST<Double, Student> b = new 	BST<Double, Student>();
		for (int i = 0; i < data; i++) {
			String[] s = sc.nextLine().split(",");
			b.put(Double.parseDouble(s[2]), new Student(Integer.parseInt(s[0]), s[1]));
		}
		int get = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < get; i++) {
			String[] line = sc.nextLine().split(" ");
			if(line[0].equals("BE")) {
				String[] s = b.keys(Double.parseDouble(line[1]), Double.parseDouble(line[2])).toString().split(" ");
				for (int j = 0; j < s.length; j++) {
					System.out.println(b.get(Double.parseDouble(s[j])).name);
				}	
			} else if(line[0].equals("LE")) {
				double least = b.min();
				String[] s = b.keys(least, Double.parseDouble(line[1])).toString().split(" ");
				for (int j = 0; j < s.length; j++) {
					System.out.println(b.get(Double.parseDouble(s[j])).name);
				}
			} else {
				double max = b.max();
				String[] s = b.keys(Double.parseDouble(line[1]), max).toString().split(" ");
				for (int j = 0; j < s.length; j++) {
					System.out.println(b.get(Double.parseDouble(s[j])).name);
				}
			}

		}	
	}
}