// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.io.*;
import java.util.*;
class Union {
	int[] arr;
	int[] sz;
	public Union(int size) {
		arr = new int[size];
		sz = new int[size];
		for(int i = 0; i < size; i++){
			sz[i] = 1;
			arr[i] = i;
		}
	}
	public int root(int val) {
		while(arr[val] != val) {
			val = arr[val];
		}
		return val;
	}
	public void weighted_union(int val1, int val2) {

		int p1 = root(val1);

		int p2 = root(val2);

		if(sz[p1]<sz[p2]) {
			arr[p1] = p2;
			sz[p2]+=sz[p1];
		} else {
			arr[p2] = p1;
			sz[p1]+=sz[p2];
		}

		// System.out.println("array is"+Arrays.toString(arr));
		// System.out.println("size is"+Arrays.toString(sz));

	}
	public boolean isConnected(int val1,int val2) {
		return root(val1) == root(val2);
	}
}
class Percolation{
	int[][] percolation;
	int count;
	Union u;
	int size;
	public Percolation(int n){
		percolation = new int[n][n];
		size = n;
		u = new Union(n*n+2);
		count = 0;
	}
	public void open(int row, int col) {

		if(percolation[row][col] == 1){
			return;
		}

		percolation[row][col] = 1;
		count++;
		// for(int i= 0; i < size; i++) {
		// 	System.out.println(Arrays.toString(percolation[i]));
		// }

		// System.out.println("*******************");
		// //top
		if(row-1 >= 0 && percolation[row-1][col] == 1){
			u.weighted_union(size*row+col,size*(row-1)+col);
		}
		//bottom
		if(row+1<size && percolation[row+1][col] == 1){

			u.weighted_union(size*row+col, size*(row+1)+col);
		}
		//right
		if(col-1>=0 && percolation[row][col-1] == 1) {

			u.weighted_union(size*row+col, size*row+(col-1));
		}
		//left
		if(col+1<size && percolation[row][col+1] == 1) {

			u.weighted_union(size*row+col,size*row+(col+1));
		}
		if(row == 0) {
			u.weighted_union(size*row+col,size*size);
		}
		if(row == size-1){
			u.weighted_union(size*row+col,size*size+1);
		}
	}
	public boolean isOpen(int row, int col) {
		if(percolation[row][col] == 1) {
			return true;
		}
		return false;
	}
	public int numberOfOpenSites() {
		return count;
	}
	public void percolate() {
		System.out.println(u.isConnected(size*size,size*size+1 ));
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolation p = new Percolation(size);
		while(sc.hasNext()) {
			p.open(sc.nextInt()-1,sc.nextInt()-1);
		}
		p.percolate();
	}
}