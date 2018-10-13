import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
	/**
	 * { name }.
	 */
	String name;
	/**
	 * { chenge }.
	 */
	Double change;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { name }
	 * @param      c     { change }
	 */
	public Stock(final String n, final Double c) {
		name = n;
		change = c;
	}
	public int compareTo(final Stock that) {
		if (this.change - that.change < 0) return 1;
		if (this.change - that.change > 0) return -1;
		else return 0;
	}
}
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
		int noofstockshour = Integer.parseInt(sc.nextLine());
		maxST<String> maxst = new maxST<String>();
		minST<String> minst = new minST<String>();
		for (int i = 0; i < 6; i++) {
			MinPQ<Stock> min = new MinPQ<Stock>();
			MaxPQ<Stock> max = new MaxPQ<Stock>();
			for (int j = 0; j < noofstockshour; j++) {
				String[] input = sc.nextLine().split(",");
				min.insert(new Stock(input[0], Double.parseDouble(input[1])));
				max.insert(new Stock(input[0], Double.parseDouble(input[1])));
			}

			for (int k = 0; k < 5; k++) {
				Stock temp = min.delMin();
				System.out.println(temp.name + " " + temp.change);
				minst.put(temp.name,1);
			}
			System.out.println();
			for (int z = 0; z < 5; z++) {
				Stock temp1 = max.delMax();
				System.out.println(temp1.name + " " + temp1.change);
				maxst.put(temp1.name,1);
			}
			System.out.println();

		}

		int queries = Integer.parseInt(sc.nextLine());
		if(queries!=0){
			for(int w = 0; w < queries; w++) {
			String[] line = sc.nextLine().split(",");
			switch(line[0]) {
				case "get":
				if(line[1].equals("maxST")) {
					System.out.println(maxst.get(line[2]));
				}
				else {
					System.out.println(minst.get(line[2]));
				}
			}
			}
		}
	}
}