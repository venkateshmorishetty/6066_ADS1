import java.util.Scanner;
/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     * { minheap }.
     */
    private MinPQ<Double> minheap = new MinPQ<Double>();
    /**
     * { max heap }.
     */
    private MaxPQ<Double> maxheap = new MaxPQ<Double>();
    /**
     * { median }.
     */
    private double m = 0.0;
    /**
     * { dynamic median }.
     *
     * @param      value  The value
     *
     * @return     { medain value }
     */
    public double dynamicMedian(final double value) {
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
                return m;
            } else {
                m = maxheap.max();
                return m;
            }
        }
        if (minheap.size() - maxheap.size() == 0) {
            double minval = minheap.delMin();
            minheap.insert(minval);
            double maxval = maxheap.delMax();
            maxheap.insert(maxval);
            m = (minval + maxval) / 2.0;
            return m;
        }
        return 0;
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

    }
    /**
     * main method.
     * time complexity is O(n) because we the loop will run n times.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        long lines = scan.nextInt();
        DynamicMedian dm = new DynamicMedian();
        for (long i = 0; i < lines; i++) {
            double input = scan.nextDouble();
            System.out.println(dm.dynamicMedian(input));
        }
    }
}
