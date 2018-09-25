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
		if(sz[p1]>sz[p2]) {
			arr[p2] = p1;
			sz[p1]++;
		} else {
			arr[p1] = p2;
			sz[p2]++;
		}
	}
	public boolean isConnected(int val1,int val2) {
		if(arr[val1] == arr[val2]) {
			return true;
		}
		return false;
	}
}
class Percolation{
	int[][] percolation;
	int count;
	Union u;
	public Percolation(int n){
		percolation = new int[n][n];
		u = new Union(n*n+2);
		count = 0;
	}
	public void open(int row, int col) {
		percolation[row][col] = 1;
		count++;
		//top
		if(row-1 >=0 && percolation[row-1][col] == 1){
			u.weighted_union(percolation[row][col],percolation[row-1][col]);
		}
		//bottom
		if(row+1<percolation.length && percolation[row+1][col] == 1){
			u.weighted_union(percolation[row][col], percolation[row][col+1]);
		}
		//right
		if(col-1>=0 && percolation[row][col-1] == 1) {
			u.weighted_union(percolation[row][col], percolation[row][col-1]);
		}
		//left
		if(col+1<percolation.length && percolation[row][col+1] == 1) {
			u.weighted_union(percolation[row][col],percolation[row][col+1]);
		}
		if(row == 0) {
			u.weighted_union(percolation[row][col],percolation.length*percolation.length);
		}
		if(col == percolation.length-1){
			u.weighted_union(percolation[row][col],percolation.length*percolation.length+1);
		}
	}
	public boolean isOpen(int row, int col) {
		if(percolation[row-1][col-1] == 1) {
			return true;
		}
		return false;
	}
	public int numberOfOpenSites() {
		return count;
	}
	public void percolate() {
		u.isConnected(0,percolation.length*percolation.length-1 );
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