import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //pass.
    }
    /**
     * { soultution }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Linkedlist l = new Linkedlist();
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int t = 0; t <= lines; t++) {
            String s = sc.nextLine();
            String[] tokens = s.split(" ");
            switch (tokens[0]) {
                case "isEmpty":
                System.out.println(l.isEmpty());
                    break;
                case "size":
                System.out.println(l.size());
                    break;
                case "pushLeft":
                    l.pushLeft(Integer.parseInt(tokens[1]));
                    break;
                case "pushRight":
                    l.pushRight(Integer.parseInt(tokens[1]));
                    break;
                case "popLeft":
                    l.popLeft();
                    break;
                case "popRight":
                    l.popRight();
                    break;
                default:
                    break;
            }
        }
    }
}
