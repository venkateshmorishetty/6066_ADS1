import java.util.Scanner;
/**
 * { solution class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //pass.
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        linkedlist l;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            l = new linkedlist(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
            l.josephproblem();
        }
    }
}
