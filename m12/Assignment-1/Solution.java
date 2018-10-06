import java.util.*;
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * { main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		studentsinfo s = new studentsinfo();
		int noofstudents = sc.nextInt();
		int noofvacancies = sc.nextInt();
		int unreseved = sc.nextInt();
		int bcvacanicies = sc.nextInt();
		int scvacanicies = sc.nextInt();
		int stvacanicies = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < noofstudents; i++) {
			String[] arr = sc.nextLine().split(",");
			String[] date = arr[1].split("-");
			Date d = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			student st = new student(arr[0], d, Integer.parseInt(arr[2]),
				Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), arr[6]);
			s.addstudent(st);	
			
		}
		selection sort = new selection();
		sort.sort(s.list, s.size,student.meritCompartor);
		s.tostring();
		sort.sort(s.list, s.size,student.reservationComparator);
		System.out.println();
		s.vacancies( noofvacancies, stvacanicies, scvacanicies, bcvacanicies, unreseved);
		s.second();
	}
}
