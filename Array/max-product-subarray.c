int max3(int a, int b, int c) {
    if (a>=b && a>=c) return a;
    else if (b>=a && b>=c) return b;
    else return c;
}

int min3(int a, int b, int c) {
    if (a<=b && a<=c) return a;
    else if (b<=a && b<=c) return b;
    else return c;
}

int max2(int a, int b) {
    if (a>=b)  return a;
    return b;
}

int maxProduct(int* nums, int numsSize) {
    if (numsSize == 0) return 0;
    if (numsSize == 1) return nums[0];
    
    int cur_prod_max = nums[0];
    int cur_prod_min = nums[0];
    int prev_prod_max = nums[0];
    int prev_prod_min = nums[0];
    int ans = nums[0];
    
    for (int i=1; i<numsSize; i++) {
        cur_prod_max = max3(prev_prod_max*nums[i], prev_prod_min*nums[i], nums[i]);
        cur_prod_min = min3(prev_prod_max*nums[i], prev_prod_min*nums[i], nums[i]);
        ans = max2(ans, cur_prod_max);
        prev_prod_max = cur_prod_max;
        prev_prod_min = cur_prod_min;
    }
    return ans;
}
