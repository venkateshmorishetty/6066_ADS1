import java.util.Scanner;
/**
 * Class for team.
 */
class Team {
    /**
     * { name of the team }.
     */
    private String name;
    /**
     * { number of wins }.
     */
    private int wins;
    /**
     * { number of losses }.
     */
    private int loss;
    /**
     * { number of draws }.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      n     { name of the team }.
     * @param      w     { wins of the team }
     * @param      l     { losses of the team }
     * @param      d     { draws of the team }
     */
    Team(final String n, final int w, final int l, final int d) {
        name = n;
        wins = w;
        loss = l;
        draws = d;
    }
    /**
     * { returns the name }.
     *
     * @return     { name of the team }.
     */
    public String getname() {
        return name;
    }
    /**
     * { compare current obj with that obj }.
     *
     * @param      that  The that
     *
     * @return     { -1 if less 0 equal +1 grater }.
     */
    public int compareTo(final Team that) {
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
/**
 * Class for teams.
 */
class Teams {
    /**
     * { initial size }.
     */
    private final int initialsize  = 10;
    /**
     * { teams object array }.
     */
    private Team[] t = new Team[initialsize];
    /**
     * { size of the array }.
     */
    private int size = 0;
    /**
     * { making team object }.
     *
     * @param      l     { line }
     */
    public void makingTeamobj(final String[] l) {
        Team newteam = new Team(l[0], Integer.parseInt(l[1]),
            Integer.parseInt(l[2]), Integer.parseInt(l[2 + 1]));
        t[size++] = newteam;

    }
    /**.
     * { print the obj array after sorting }
     * {time complexity is O(n) because to print all
     * elements loop runs 0 to n}
     */
    public void print() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(t[i].getname() + ",");
        }
        System.out.print(t[size - 1].getname());
    }
    /**.
     * { size method }
     *
     * @return     { return size }
     */
    public int getsize() {
        return size;
    }
    /**.
     * { return array }
     *
     * @return     { t }
     */
    public Team[] getarray() {
        return t;
    }
}
/**
 * Class for sort.
 */
class Sort {
    /**.
     * { sorts the array }
     * {time complexity is O(n^2) because we use two
     * loops which takes n^2 complexity}
     * @param      t     { array of teams }
     * @param      size  The size
     */
    public void sorting(final Team[] t, final int size) {
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
        Sort s = new Sort();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            teams.makingTeamobj(line);
        }
        s.sorting(teams.getarray(), teams.getsize());
        teams.print();
    }
}
