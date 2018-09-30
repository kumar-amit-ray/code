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
