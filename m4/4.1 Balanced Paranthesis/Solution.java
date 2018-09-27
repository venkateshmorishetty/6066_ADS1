import java.util.*;
class Stack {
	String[] stack;
	int size, top = -1;
	Stack(int size) {
		stack = new String[size];
		this.size = size;
	}
	public boolean push(String item) {
		stack[++top] = item;
		return true;
	} 
	public String pop() {
		if(top>=0) {
			return stack[top--];

		}
		return null;
	}

}

class Solution{
	public static void main(String[] args) {
		Stack s;
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		int flag;
		for(int j = 0; j < lines; j++) {
			flag = 0;
			String line = sc.next();
			String[] arr = line.split("", line.length());
			s = new Stack(arr.length);
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("[")) {
					s.push(arr[i]);
				} else {
					String check = s.pop();
					if(check == null){

						flag =1;
						break;
						
					} else {
						// System.out.println("iam here");
						if(check.equals("(") && arr[i].equals(")"))
						{	

							continue;
						}
						else if(check.equals("{") && arr[i].equals("}"))
						{
							continue;
						} else if(check.equals("[") && arr[i].equals("]"))
						{
							continue;
						} else {

							flag =1;
							break;
						}
					}		
				}
			}
			if(s.top==-1 && flag == 0){
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}