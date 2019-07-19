/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: [[7,10],[2,4]]
Output: true

Solution: Sort the Input based on start time and now go through each meeting to see if the start time of that meeting falls in the range of previous meeting. 
*/

func canAttendMeetings(intervals []Interval) bool {
    //sort the intervals as per the start time.
    sort.Slice(intervals, func(i, j int) bool {
	return intervals[i].Start < intervals[j].Start
})
    
for i:=0; i<len(intervals)-1; i++ {
	if intervals[i].End > intervals[i+1].Start {
		return false
	}
}

return true
}

In Python
==========
class Solution(object):
    def convert_interval_to_dict(self, intervals):
        new_intervals = list()
        for interval in intervals:
            itv = dict()
            itv['start'] = interval[0]
            itv['end'] = interval[1]
            new_intervals.append(itv)

        return new_intervals

    def custom_interval_cmp(self, itv1, itv2):
        if itv1['start'] < itv2['start']: return -1
        if itv1['start'] > itv2['start']: return 1
        else: return 0


    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: bool
        """
        intervals = self.convert_interval_to_dict(intervals)

        intervals = sorted(intervals, cmp=self.custom_interval_cmp)
        #intervals = sorted(intervals, key = lambda i: i['start'])
        i = 0
        while i<len(intervals)-1:
            if intervals[i]['end'] > intervals[i+1]['start']: return False
            i +=1
            
        return True


/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
determine how many conf room is required for  all meetings.
Explanation - https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-@pinkfloyda
*/
	
	func minMeetingRooms(intervals []Interval) int {
		var room int
		var start []int
		var end []int
	
		for i:=0; i<len(intervals); i++ {
			start = append(start, intervals[i].Start)
			end = append(end, intervals[i].End)
		}
	
		sort.Slice(start, func(i, j int) bool {
			return start[i] < start[j]
		})
		sort.Slice(end, func(i, j int) bool {
			return end[i] < end[j]
		})
	
		endItr := 0
		for i:=0; i<len(intervals); i++ {
			if start[i] < end[endItr] {
				room++
			} else {
				endItr++
			}
		}
		return room
	}
	

	/*
  Given a collection of intervals, merge all overlapping intervals.
	Example 1:
	Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	Example 2:
	Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

/**
 * Definition for an interval.
 * type Interval struct {
 *	   Start int
 *	   End   int
 * }
 */
func merge(intervals []Interval) []Interval {
    var newIntervals []Interval
	var startInterval Interval
    
    if len(intervals) == 0 {
		return newIntervals
	}
    
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i].Start < intervals[j].Start {
			return true
		} else {
			return false
		}
	})
	startInterval = intervals[0]
	for _, itv := range intervals[1:] {
		if startInterval.End < itv.Start {
			newIntervals = append(newIntervals, Interval{startInterval.Start, startInterval.End})
			startInterval = itv
		} else {
			startInterval.Start = int(math.Min(float64(startInterval.Start), float64(itv.Start)))
			startInterval.End = int(math.Max(float64(startInterval.End), float64(itv.End)))
		}
	}
	//add the last one
	newIntervals = append(newIntervals, Interval{startInterval.Start, startInterval.End})
	return newIntervals
}

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * type Interval struct {
 *	   Start int
 *	   End   int
 * }
 */
func insert(intervals []Interval, newInterval Interval) []Interval {
	var newIntervals []Interval
	var nextindex int
	var newstart int
	var newend int
	var count int

	for _, itval := range intervals {
		if itval.End < newInterval.Start {
			newIntervals = append(newIntervals, itval)
			count++
		} else {
			nextindex = count
			break
		}
	}
	newstart = newInterval.Start
	newend = newInterval.End

	if count < len(intervals) {
		for _, itval := range intervals[nextindex:] {
			if itval.Start <= newInterval.End {
				newstart = int(math.Min(float64(itval.Start), float64(newstart)))
				newend = int(math.Max(float64(itval.End), float64(newend)))
				count++
			} else {
				nextindex = count
				break
			}
		}
	}
	newIntervals = append(newIntervals, Interval{newstart, newend})
	if count < len(intervals) {
		for _, itval := range intervals[nextindex:] {
			newIntervals = append(newIntervals, itval)
		}
	}
	return newIntervals
}

In Python
----------
class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        result = list()
        
        if len(intervals) == 0: 
            result.append(newInterval)
            return result
        
        intervals = self.convert_interval_to_dict(intervals)
        newInterval = {'start':newInterval[0], 'end':newInterval[1]}
       
        #copy the smaller interval
        count = 0
        index = 0
        for interval in intervals:
            if interval['end'] < newInterval['start']:
                result.append(interval)
                count +=1
            else: break

        if count < len(intervals): 
            for interval in intervals[count:]:
                if newInterval['end'] >= interval['start']:
                    newInterval['start'] = min(newInterval['start'], interval['start'])
                    newInterval['end'] = max(newInterval['end'], interval['end'])
                    count +=1
                else: break

        result.append(newInterval)

        #if count >= len(intervals): return self.convert_dict_to_intervals(result)
        if count < len(intervals):
            for interval in intervals[count:]:
                result.append(interval)

        return self.convert_dict_to_intervals(result)
    
    def convert_interval_to_dict(self, intervals):
        new_intervals = list()
        for interval in intervals:
            itv = dict()
            itv['start'] = interval[0]
            itv['end'] = interval[1]
            new_intervals.append(itv)

        return new_intervals

    def convert_dict_to_intervals(self, intervals):
        result = list()
        for interval in intervals:
            entry = list()
            entry.append(interval['start'])
            entry.append(interval['end'])
            result.append(entry)

        return result
