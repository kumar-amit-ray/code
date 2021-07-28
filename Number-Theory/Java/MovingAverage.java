/**
https://leetcode.com/problems/moving-average-from-data-stream/
 */
class MovingAverage {
    
    int size;
    Queue<Integer> queue = new LinkedList();
    int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        queue.add(val);
        sum += val;
        return (double)sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
