import java.util.Scanner;
import java.lang.Comparable;

class CubeSum implements Comparable<CubeSum>{
	int i;
	int j;
	int sum;
	public CubeSum(int i, int j) {
		this.i = i;
		this.j = j;
		sum = i*i*i + j*j*j;
	}
	public int compareTo(CubeSum that) {
		return this.sum - that.sum;
	}
	public int getIval() {
		return i;
	}
	public int getJval() {
		return j;
	}
	public int getSum() {
		return sum;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int value1 = Integer.parseInt(input[0]);
		int value2 = Integer.parseInt(input[1]);
		TaxiNumbers(value1, value2);
	}

	public static void TaxiNumbers(int nthnumber, int combinations) {
		int n = 600;
		MinPQ<CubeSum> mp = new MinPQ<CubeSum>();
		for(int i = 0; i < n; i++) {
			mp.insert(new CubeSum(i, i));
		}
		int t = -1;
		int count = 0;
		while(!mp.isEmpty()) {
			CubeSum temp = mp.delMin();
			if(t == temp.getSum()) {
				count++;
			} else {
				count = 0;
			}
			if(count == combinations - 1) {
				nthnumber--;
				if(nthnumber == 0) {
					System.out.println(temp.sum);
					break;
				}
			}
			t = temp.getSum();
			if(temp.getJval() < n) {
				mp.insert(new CubeSum(temp.getIval(), temp.getJval()+1));
			}
		}
	}
}