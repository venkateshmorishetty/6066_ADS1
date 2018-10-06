class studentsinfo {
	student[] list;
	student[] result;
	int size;
	public studentsinfo() {
		list = new student[100];
		size = 0;

	}


	public void addstudent(student s) {
		list[size++] = s;
	}


	public void tostring() {
		for(int i = 0; i < size; i++) {
			System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
		}
	}


	public void vacancies(int vacancies, int st, int sc, int bc, int open) {
		result = new student[vacancies];
		int temp = 0;
		for(int i = 0; i < open; i++) {
			// System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
			result[temp++] = list[i];
			vacancies--;
		}
		// if(vacancies==0) {
		// 	return;
		// } else {
		// 	while(vacancies!=0) {
		// 	for(int k = 0; k < size; k++) {
		// 	if(list[k].cast.equals("ST") && st!=0) {
		// 		for(int i = 0; i < open; i++) {
		// 			if(!(result[i].name.equals(list[i].name))) {
		// 				result[temp++] = list[i];
		// 			}
		// 		}
		// 		st--;
		// 	}
		// 	if(list[k].cast.equals("SC") && sc!=0) {
		// 		for(int i = 0; i < temp; i++) {
		// 			if(!(result[i].name.equals(list[i].name))) {
		// 				result[temp++] = list[i];
		// 			}
		// 		}
				
		// 		sc--;
		// 	}
		// 	if(list[k].cast.equals("Open") && open!=0) {
		// 		for(int i = 0; i < open; i++) {
		// 			if(!(result[i].name.equals(list[i].name))) {
		// 				result[temp++] = list[i];
		// 			}
		// 		}
		// 		open--;
		// 	}
		// 	if(list[k].cast.equals("BC") && bc!=0) {
		// 		for(int i = 0; i < open; i++) {
		// 			if(!(result[i].name.equals(list[i].name))) {
		// 				result[temp++] = list[i];
		// 			}
		// 		}
		// 		bc--;
		// 	}
		// 	vacancies--;
		// 	}
		// }
		// }
		for(int i = 0; i < temp; i++) {
			System.out.println(list[i].name+","+list[i].totalscore+","+list[i].cast);
		}	
	}
}