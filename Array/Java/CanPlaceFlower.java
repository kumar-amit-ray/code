/**
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

@Leetcode - https://leetcode.com/problems/can-place-flowers/
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 ) {
            return true;
        }
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        } 
        
        int i = 0;
        while(i<flowerbed.length) {
            if (canPlace(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) {
                return true;
            }
            i++;
        }
        if (n == 0) {
            return true;
        }
        return false;
    }
    
    private boolean canPlace(int[] flowerbed, int pos) {
        if (flowerbed[pos] == 0 && (pos == 0 || flowerbed[pos-1] == 0) 
            && (pos == flowerbed.length-1 || flowerbed[pos+1] == 0)) {
            return true;
        } 
        return false;
    }
}
