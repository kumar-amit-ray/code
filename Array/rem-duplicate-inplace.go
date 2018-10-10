/*
Given a sorted array nums, remove the duplicates in-place such that duplicates 
appeared at most twice and return the new length.Do not allocate extra space for another array, 
you must do this by modifying the input array in-place with O(1) extra memory.
*/
func RemoveDupInplace(nums []int) int {
  if len(nums) == 1 {
    return len(nums)
  }
  start := 1
  newlen := 1
  curr := nums[0]
  numcount := 1
  
  for ;start < len(nums); start++ {
    if nums[start] == curr {
      if numcount >= 2 {
        /* just invalidate the number, not required though */
        nums[start] = -1
      } else {
        numcount++
        newlen++
      }
    } else {
      curr = nums[start]
      numcount = 1
      newlen++
    }
  }
  return newlen
}
