import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for insertion.
 */
class insertion {
    /**
     * { insertion class }.
     *
     * @param      students    The students
     * @param      size        The size
     * @param      comparator  The comparator
     */
    public insertion() {
        //constructor
    }
    public void sort(final student[] students, final int size,
        final Comparator comparator) {
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
/**
 * Class for student.
 */
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
/**
 * Class for studentsinfo.
 */
class studentsinfo {
    /**
     * { list }.
     */
    student[] list;
    /**
     * { result }.
     */
    student[] result;
    /**
     * { size }.
     */
    int size;
    /**
     * Constructs the object.
     */
    int temp = 0;
    /**
     * Constructs the object.
     */
    public studentsinfo() {
        list = new student[100];
        size = 0;

    }
    /**
     * { add student }.
     *
     * @param      s     { parameter_description }
     */
    public void addstudent(student s) {
        list[size++] = s;
    }
    /**
     * { tostring }.
     */
    public void tostring() {
        for(int i = 0; i < size; i++) {
            System.out.println(list[i].name + ","
                + list[i].totalscore + "," + list[i].cast);
        }
    }
    /**
     * { seconf }.
     */
    public void second() {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].name + "," +
                result[i].totalscore + "," + result[i].cast);
        }
    }
    /**
     * { checks the result }.
     *
     * @param      t     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final student t) {
        for (int i = 0; i < temp; i++) {
            if (t.name.equals(result[i].name)) {
                return true;
            }
        }
        return false;
    }
    /**
     * { qualified }.
     *
     * @param      vacancies  The vacancies
     * @param      st         { parameter_description }
     * @param      sc         The screen
     * @param      bc         { parameter_description }
     * @param      open       The open
     */
    public void vacancies(int vacancies, int st, int sc,
        int bc, int open) {
        result = new student[vacancies];
        for (int i = 0; i < open; i++) {
            result[temp++] = list[i];
            vacancies--;
        }
        for (int i = 0; i < size; i++) {
            if (!(contains(list[i]))) {
                if (vacancies != 0) {
                    if(list[i].cast.equals("SC")
                        && sc != 0) {
                        result[temp++] = list[i];
                        vacancies--;
                        sc--;
                    } else if (list[i].cast.equals("ST")
                        && st != 0) {
                        result[temp++] = list[i];
                        vacancies--;
                        st--;
                    } else if (list[i].cast.equals("BC")
                        && bc != 0) {
                        result[temp++] = list[i];
                        vacancies--;
                        bc--;
                    }
                } else {
                    return;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (vacancies != 0) {
                if (!contains(list[i])) {
                    result[temp++] = list[i];
                    vacancies--;
                }
            }
        }
        insertion i = new insertion();
        i.sort(result, result.length, student.meritCompartor);
    }
}
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
        sort.sort(s.list, s.size,student.meritCompartor);
        s.tostring();
        System.out.println();
        s.vacancies( noofvacancies, stvacanicies, scvacanicies,
            bcvacanicies, unreseved);
        s.second();
    }
}
