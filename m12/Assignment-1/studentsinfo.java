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
			System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
		}
	}
	/**
	 * { seconf }.
	 */
	public void second() {
		for(int i = 0; i < result.length; i++) {
			System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
		}
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
	public void vacancies(int vacancies, int st, int sc, int bc, int open) {
		result = new student[vacancies];
		for(int i = 0; i < open; i++) {
			// System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
			result[temp++] = list[i];
			vacancies--;
		}
		if(vacancies==0) {
			return;
		} else {
			// selection sort = new selection();
			// sort.sort(list, size, student.secondComparator);
			for (int k = 0; k < size; k++) {
				int flag = 1;
				if(vacancies==0) {
					return;
				}
				for(int j = 0; j < temp; j++) {
					if(result[j].name.equals(list[k])){
						flag = 0;
					}
				}
				if(flag == 1) {
					result[temp++] = list[k];
					vacancies--;
				}	
			}
		}
			
	}
}