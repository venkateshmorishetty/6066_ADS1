import java.util.Scanner;
/**
 * stack class.
 */
class Stack {
    /**
     * { stack }.
     */
    private String[] stack;
    /**
     * { top variable }.
     */
    private int top = -1;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    Stack(final int size) {
        stack = new String[size];
    }
    /**
     * { insert the element to stack }.
     *
     * @param      item  The item
     */
    public void push(final String item) {
        stack[++top] = item;
    }
    /**
     * { pop the top element }.
     *
     * @return     { stack top element }.
     */
    public String pop() {
        if (top >= 0) {
            return stack[top--];
        }
        return null;
    }
    /**
     * Gets the top.
     *
     * @return     The top.
     */
    public int getTop() {
        return top;
    }
}
/**
 * Class for balanced parenthesis.
 */
class BalancedParenthesis {
    /**
     * { flag value }.
     */
    private int flag;
    /**
     * { satck object }.
     */
    private Stack s;
    /**
     * { checksBalancedParenthesis }.
     *
     * @param      input  The input
     *
     * @return     { returns true if it is balanced else false }.
     */
    public void checksBalancedParenthesis(final String input) {
        flag = 0;
        String[] arr = input.split("", input.length());
            s = new Stack(arr.length);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("(") || arr[i].equals("{")
                    || arr[i].equals("[")) {
                    s.push(arr[i]);
                } else {
                    String check = s.pop();
                    if (check == null) {
                        flag = 1;
                        break;
                    } else {
                        if (check.equals("(") && arr[i].equals(")")) {
                            continue;
                        } else if (check.equals("{") && arr[i].equals("}")) {
                            continue;
                        } else if (check.equals("[") && arr[i].equals("]")) {
                            continue;
                        } else {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            if (s.getTop() == -1 && flag == 0) {
                // return true;
                System.out.println("YES");

            } else {
                // return false;
                System.out.println("NO");
            }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //pass
    }
    /**
     * { Solution class }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int j = 0; j < lines; j++) {
            String line = sc.next();
            BalancedParenthesis b = new BalancedParenthesis();
            b.checksBalancedParenthesis(line);
            // if (b.checksBalancedParenthesis(line)) {
            //     System.out.println("YES");
            // } else {
            //     System.out.println("NO");
            // }
        }
    }
}
