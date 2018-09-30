/*
	Given a collection of distinct integers, return all possible permutations.
	Example:
	Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

func insertsliceat(sl []int, pos int, num int) []int{
	newslice := make([]int, pos+1)
	copy(newslice, sl[:pos])
	newslice[pos] = num
	newslice = append(newslice, sl[pos:]...)
	return newslice
}

func permute(nums []int) [][]int {
	var ans [][]int

	//Add first element to the list
	ans = append(ans, []int{nums[0]})

	for i:=1; i<len(nums); i++ {
		slist := make ([][]int, 0)
		for j:=0; j<=i; j++ {
			for _, l := range ans {
				newl := insertsliceat(l, j, nums[i])
				slist =append(slist, newl)
			}
		}
		ans = slist
	}
	return ans
}

	1. Given a set of distinct integers, nums, return all possible subsets (the power set).
	
	Note: The solution set must not contain duplicate subsets.
	Example:
	Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
	
/*	
	While iterating through all numbers, for each new number, we can either pick it or not pick it
	1, if pick, just add current number to every existing subset.
	2, if not pick, just leave all existing subsets as they are.
	We just combine both into our result.
	For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
	Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
	Combine them, now we have [ [ ], [1] ] as all possible subset
	Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each 
	previous subset, we have [2], [1,2]
	Combine them, now we have [ [ ], [1], [2], [1,2] ]
	Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, 
	just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]
	Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]

*/

	func ReturnSubsets(nums []int) [][]int {
		var result [][]int
	
		result = make([][]int, 0)
		if len(nums) <= 0 {
			return result
		}
		// Add the first number
		result = append(result, []int{nums[0]})
	
		for _, val := range(nums) {
			// allocate a temporary result
			newresult := make([][]int, 0)
			for _, set := range(result) {
				// copy over the existing set in the temp result
				newresult = append(newresult, set)
				// add val with the set content
				newset := append (set, val)
				// add the new set to the temp result
				newresult = append(newresult, newset)
			}
			// now result contains all existing data with the val appended
			result = newresult
		}
		return result
	}
	
