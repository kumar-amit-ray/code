int max2(int a, int b) {
    if (a>=b) return a;
    return b;
}
int maxSubArray(int* nums, int numsSize) {
    int sumsofar=nums[0], ans=nums[0];
    
    for (int i=1; i<numsSize; i++) {
        sumsofar = max2(sumsofar+nums[i], nums[i]);
        ans = max2(ans, sumsofar);
    }
    return ans;
}
