package ArrayIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayInterval {
    /**
     * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a
     * person could attend all meetings.
     *
     * Example 1:
     *
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: false
     * Example 2:
     *
     * Input: intervals = [[7,10],[2,4]]
     * Output: true
     *
     * Constraints:
     *
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti < endi <= 106
     *
     * @Leetcode - https://leetcode.com/problems/meeting-rooms/
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i=0; i<intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.
     *
     * Example 1:
     *
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     * Example 2:
     *
     * Input: [[7,10],[2,4]]
     * Output: 1
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     *
     * @Leetcode - https://leetcode.com/problems/meeting-rooms-ii/
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int numConfRoom = 0;
        int endMarker = 0;
        for (int i=0; i<intervals.length; i++) {
            if (starts[i] < ends[endMarker]) {
                numConfRoom++;
            } else {
                endMarker++;
            }
        }

        return numConfRoom;
    }

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     * @Leetcode - https://leetcode.com/problems/merge-intervals/
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] curr = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                result.add(curr);
                curr = intervals[i];
            }
        }
        result.add(curr);
        return result.toArray(new int[result.size()][]);
    }

    /**
     *
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     * Example 3:
     *
     * Input: intervals = [], newInterval = [5,7]
     * Output: [[5,7]]
     * Example 4:
     *
     * Input: intervals = [[1,5]], newInterval = [2,3]
     * Output: [[1,5]]
     * Example 5:
     *
     * Input: intervals = [[1,5]], newInterval = [2,7]
     * Output: [[1,7]]
     *
     * @Leetcode - https://leetcode.com/problems/insert-interval/
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int count = 0;

        // Add all the range that are smaller than new interval
        while (count < intervals.length) {
            if (intervals[count][1] < newInterval[0]) {
                result.add(intervals[count]);
                count++;
            } else {
                break;
            }
        }

        // Merge all the interval that collide with new interval
        while (count < intervals.length) {
            if (newInterval[1] >= intervals[count][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[count][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[count][1]);
                count++;
            } else {
                break;
            }
        }
        result.add(newInterval);

        // Add all the intervals that are greater than new Interval
        while (count < intervals.length) {
            result.add(intervals[count]);
            count++;
        }

        // Convert the list to an array and return
        return result.toArray(new int[result.size()][]);

    }
}
