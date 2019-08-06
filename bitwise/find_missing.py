'''
An array A[1..n] contains all the integers from 0 to n except for one number which is missing. 
In this problem, we cannot access an entire integer in A with a single operation. The elements of A are represented
in binary, and the only operation we can use to access them is "fetch the jth bit of A[i]", which takes constant time. 
Write code to find the missing integer. Can you do it in O(n) time?

https://www.quora.com/Find-the-missing-number-in-an-array-which-contains-all-numbers-from-0-1-n-except-one-How-do-we-solve-this-in-linear-time-given-that-the-numbers-are-represented-in-binary-format-and-we-can-access-only-a-single-bit-at-a-time
'''
def find_missing_number_bitwise_helper(nums, bitpos):
    odd_indices = list()
    even_indices = list()

    print nums, bitpos

    if len(nums) == 0 or bitpos > 31: return 0

    for num in nums:
        if get_ith_bit(num, bitpos) == 1: odd_indices.append(num)
        else: even_indices.append(num)

    print 'odd:'+str(len(odd_indices))+'even:'+str(len(even_indices))
    if len(odd_indices) >= len(even_indices):
        return find_missing_number_bitwise_helper(even_indices, bitpos+1) << 1 | 0
    else:
        return find_missing_number_bitwise_helper(odd_indices, bitpos + 1) << 1 | 1
