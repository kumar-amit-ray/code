/*
Given a sorted array nums, remove the duplicates in-place such that duplicates 
appeared at most twice and return the new length.Do not allocate extra space for another array, 
you must do this by modifying the input array in-place with O(1) extra memory.

Youtube Explanation: https://www.youtube.com/watch?v=gf7vdIin0dk
*/

func removeduplicateinline(nums []int) {
    j := 0

    for i:=0; i<len(nums)-1; i++ {
        if nums[i] != nums[i+1] {
          nums[j] = nums[i]
          j++
        }
    }
    nums[j] = nums[len(nums)-1]
    fmt.Println(nums)
    fmt.Println(j+1)
}

