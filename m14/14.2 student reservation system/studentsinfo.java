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