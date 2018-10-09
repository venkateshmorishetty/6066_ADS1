import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Studentsinfo s = new Studentsinfo();
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
            int[] dat = new int[date.length];
            for (int j = 0; j < date.length; j++) {
                dat[j] = Integer.parseInt(date[j]);
            }
            student st = new student(arr[0], dat, Integer.parseInt(arr[2]),
                Integer.parseInt(arr[3]), Integer.parseInt(arr[4]),
                Integer.parseInt(arr[5]), arr[6]);
            s.addstudent(st);
        }
        insertion sort = new insertion();
        sort.sort(s.getList(), s.getSize(),student.meritCompartor);
        s.tostring();
        System.out.println();
        s.vacancies( noofvacancies, stvacanicies, scvacanicies,
            bcvacanicies, unreseved);
        s.second();
    }
}
