import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method for the program.
     * complexity O(n) as we are taking n inputs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        long lines = scan.nextInt();
        MinPQ<Double> minheap = new MinPQ<Double>();
        MaxPQ<Double> maxheap = new MaxPQ<Double>();
        double m = 0.0;
        for (long i = 0; i < lines; i++) {
            double value = scan.nextDouble();
            if (value > m) {
                minheap.insert(value);
            } else if (value < m) {
                maxheap.insert(value);
            } else {
                minheap.insert(value);
            }
            if (minheap.size() - maxheap.size() > 1) {
                maxheap.insert(minheap.delMin());
            }
            if (maxheap.size() - minheap.size() > 1) {
                minheap.insert(maxheap.delMax());
            }
            if (Math.abs(minheap.size() - maxheap.size()) == 1) {
                if (minheap.size() > maxheap.size()) {
                    m = minheap.min();
                    System.out.println(m);
                } else {
                    m = maxheap.max();
                    System.out.println(m);
                }
            }
            if (minheap.size() - maxheap.size() == 0) {
                double minval = minheap.delMin();
                minheap.insert(minval);
                double maxval = maxheap.delMax();
                maxheap.insert(maxval);
                m = (minval + maxval) / 2.0;
                System.out.println(m);
            }
        }
    }
}
