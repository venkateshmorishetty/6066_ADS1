import java.util.*;
class Team{
	String name;
	int wins;
	int loss;
	int draws;
	public Team(String n, int w, int l, int d) {
		name = n;
		wins = w;
		loss = l;
		draws = d;
	}
	public int compareTo(Team that) {
		if(this.wins < that.wins) {
			return 1; 
		} else if(this.wins == that.wins) {
			if(this.loss > that.loss) {
				return 1;
			} else if(this.loss == that.loss) {
				if(this.draws < that.draws) {
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
	int size = 0;
	public void makingTeamobj(String[] l) {
		
		Team newteam = new Team(l[0], Integer.parseInt(l[1]), Integer.parseInt(l[2]), Integer.parseInt(l[3]));
		t[size++] = newteam;

	}
	public void sorting() {
		int min;
		for(int i = 0; i < size - 1; i++) {
			min = i;
			int j = i + 1;
			while(j<=size - 1) {
				int check = t[min].compareTo(t[j]);
				if(check == 1) {
					min = j;
				}
				j++; 
			}

			Team temp = t[i];
			t[i] = t[min];
			t[min] = temp;
		}
	}
}





class Solution {
	public static void main(String[] args) {
		Teams teams = new Teams();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] line = sc.nextLine().split(",");
			teams.makingTeamobj(line);
		}
		teams.sorting();
		for(int i = 0; i < teams.size-1; i++) {
			System.out.print(teams.t[i].name+",");
		}System.out.print(teams.t[teams.size-1].name);
	}
}