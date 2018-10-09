/*
Given an sorted array and a sum, find 3 number in that array that equal to that sum.
*/

func find3sum(nums []int, findsum int) (int, int, int) {
  for index, num := range nums {
    left := index+1
    right := len(nums) -1
    
    while (left < right) {
      sum := num+nums[left]+nums[right]
      if sum == findsum {
        return index, left, right
      } else if sum > findsum {
        right--
      } else{
        left++
      }
    }
  }
  return -1, -1, -1
}
