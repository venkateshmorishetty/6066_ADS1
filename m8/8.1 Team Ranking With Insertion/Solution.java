import java.util.Scanner;
class Team {
	private String name;
	private int wins;
	private int loss;
	private int draws;
	public Team(final String n, final int w, final int l, final int d) {
		name = n;
		wins = w;
		loss = l;
		draws = d;
	} 
	public String getname() {
		return name;
	}
	public int compareTo(Team that) {
		if (this.wins < that.wins) {
			return 1; 
		} else if (this.wins == that.wins) {
			if (this.loss > that.loss) {
				return 1;
			} else if (this.loss == that.loss) {
				if (this.draws < that.draws) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}
class Teams {
	Team[] t = new Team[10];
	private int size = 0;
	/**
	 * { making team object }.
	 *
	 * @param      l     { parameter_description }
	 */
	public void makingTeamobj(final String[] l) {
		Team newteam = new Team(l[0], Integer.parseInt(l[1]),
			Integer.parseInt(l[2]), Integer.parseInt(l[2 + 1]));
		t[size++] = newteam;

	}
	/**
	 * { sorts the array of objects }.
	 */
	public void sorting() {
		int min;
		for (int i = 0; i < size - 1; i++) {
			min = i;
			int j = i + 1;
			while (j <= size - 1) {
				int check = t[min].compareTo(t[j]);
				if (check == 1) {
					min = j;
				}
				j++;
			}
			Team temp = t[i];
			t[i] = t[min];
			t[min] = temp;
		}
	}
	/**
	 * Gets the size.
	 *
	 * @return     The size.
	 */
	public int getSize() {
		return size;
	}
}
/**
 * { solution class }.
 */
final class Solution {
	/**
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
		Teams teams = new Teams();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] line = sc.nextLine().split(",");
			teams.makingTeamobj(line);
		}
		teams.sorting();
		for (int i = 0; i < teams.getSize() - 1; i++) {
			System.out.print(teams.t[i].getname() + ",");
		}
		System.out.print(teams.t[teams.getSize() - 1].getname());
	}
}