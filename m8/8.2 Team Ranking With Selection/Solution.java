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
	// sorting s = new sorting();
	public void makingTeamobj(String[] l) {
		
		Team newteam = new Team(l[0], Integer.parseInt(l[1]), Integer.parseInt(l[2]), Integer.parseInt(l[3]));
		t[size++] = newteam;

	}
	public void sorting() {
		for(int i = 1; i < size; i++) {
			Team key = t[i];
			int j = i - 1;
			int check = t[j].compareTo(key);
			while(check == 1 && j >= 0) {
				t[j+1] = t[j];
				j--;
				if(j > 0) {
					check = t[j].compareTo(key);
				}
			}
			t[j+1] = key;
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