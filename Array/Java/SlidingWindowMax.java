/**
@Leetcode - https://leetcode.com/problems/sliding-window-maximum/
@Youtube - https://www.youtube.com/watch?v=xFJXtB5vSmM
 */

class Solution {
    ArrayDeque<Integer> dq = new ArrayDeque();
    
    private void cleanDq(int[] nums, int i, int k) {
        // remove element that is outside the sliding window
        if (!dq.isEmpty() && dq.getFirst() == i-k) {
            dq.removeFirst();
        }
        // remove any element which are in the sliding window and less than the current
        // element becos we know that it is not the first element of the window and removing it for
        // the next window will not matter.
        while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
            dq.removeLast();
        }
        
        // add the current element to the end of the queue.
        dq.addLast(i);
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }
        // either number of elements in the array or the sliding window size is 0
        if (nums.length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        for (int i=0; i<k; i++) {
            cleanDq(nums, i, k);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[dq.getFirst()];
        
        for (int i = k; i <nums.length; i++) {
            cleanDq(nums, i, k);
            ans[i - k + 1] = nums[dq.getFirst()];
        }
        
        return ans;
    }
}
