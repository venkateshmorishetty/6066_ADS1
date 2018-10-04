import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { head node }.
     */
    private Node head, temp;
    /**
     * { size variable }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    final class Node {
        /**
         * { data }.
         */
        private int data;
        /**
         * { next node address }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      d  The data
         */
        private Node(final int d) {
            data = d;
        }
    }
    /**
     * Gets the head.
     *
     * @return     The head.
     */
    public Node getHead() {
        return head;
    }
    /**
     * { inserts at given position }.
     *
     * @param      index      The index
     * @param      item       The item
     *
     * @throws     Exception  { if index is less then size
     * or 0 throws exception }.
     *  {time complexity for inserAt is O(n) because if we give pos as last
     *  then number of function calls will be n-1 nearly n}.
     */
    public void insertAt(final int index, final int item) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Can't insert at this position.");
        }
        if (size == 0) {
            Node newnode = new Node(item);
            head = newnode;
            temp = head;
            size++;
            return;
        } else if (size >= 1) {
            Node newnode = new Node(item);
            if (index == 0) {
                newnode.next = head;
                head = newnode;
                temp = head;
                size++;
                return;
            } else if (index == 1) {
                newnode.next = temp.next;
                temp.next = newnode;
                size++;
                temp = head;
                return;
            } else {
                temp = temp.next;
                insertAt(index - 1, item);
            }
        }
    }
    /**
     * { revers the given linked list }.
     *
     * @param      curr       The curr
     * @param      prev       The previous
     * { time complexity for reverse is O(n) because to 
     * reverse linked list number of function callings will be n}
     * @throws     Exception  { if there are no elements throws exception }.
     */
    public void reverse(final Node curr, final Node prev)
    throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        if (curr.next == null) {
            head = curr;
            head.next = prev;
            temp = head;
            return;
        }
        Node temp1 = curr.next;
        curr.next = prev;
        reverse(temp1, curr);
    }
    /**
     * { print the entire list }.
     * { time complexity for display is O(n) because while loop runs n times }
     */
    public void display() {
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        } System.out.print(temp.data);
        System.out.println();
        temp = head;
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
        //constructor of Solution
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Linkedlist l = new Linkedlist();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            if (arr[0].equals("insertAt")) {
                try {
                    l.insertAt(Integer.parseInt(arr[1]),
                        Integer.parseInt(arr[2]));
                    l.display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (arr[0].equals("reverse")) {
                try {
                    l.reverse(l.getHead(), null);
                    l.display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
