/**
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, 
schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] 
in our answer, as they have zero length.

 

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]

@Leetcode - https://leetcode.com/problems/employee-free-time/
@Youtube - https://www.youtube.com/watch?v=tafUkDPWIbM
 */

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> allSchedule = new ArrayList<>();
        // basic error check
        if (schedule == null || schedule.size() == 0) {
            return result;
        }
        // collect all the schedule
        for (List<Interval> employee: schedule) {
            allSchedule.addAll(employee);
        }

        // sort them based on the start time
        allSchedule.sort((o1, o2) -> o1.start - o2.start);

        int lastEnd = allSchedule.get(0).end;
        for (int i = 1; i<allSchedule.size(); i++) {
            int currStart = allSchedule.get(i).start;
            int currEnd = allSchedule.get(i).end;
            if (lastEnd < currStart) {
                result.add(new Interval(lastEnd, currStart));
            }
            lastEnd = Math.max(lastEnd, currEnd);
        }
        return result;    
    }
}
