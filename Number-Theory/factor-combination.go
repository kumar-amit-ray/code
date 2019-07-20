/*
	1. Factor Combinations
	
	Numbers can be regarded as product of its factors. For example,
	8 = 2 x 2 x 2;
  = 2 x 4.
	Write a function that takes an integer n and return all possible combinations of its factors.
	Note:
		1. You may assume that n is always positive.
		2. Factors should be greater than 1 and less than n.
	Example 1:
	Input: 1
Output: []
	Example 2:
	Input: 37
Output:[]
	Example 3:
	Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
	Example 4:
	Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

func getFactors(n int) [][]int {
    return getFactorsWithMin(n, 2)
}

func getFactorsWithMin(n, min int) (results [][]int) {
    
    for a := min; a <= int(math.Sqrt(float64(n))); a++ {
		if n % a != 0 {
			continue
		}
		b := n / a
		subFactors := getFactorsWithMin(b, a)
		for _, subFactor := range subFactors {
			results = append(results, append(subFactor, a))
		}
		results = append(results, []int{b, a})
	}
	return results
}

In Python
---------
    def getFactors(self, num):
        return self.getfactors_with_min(num, 2)

    def getfactors_with_min(self, num, min):
        a = min
        result = list()
        while a <= math.sqrt(num):
            if num%a != 0: continue
            b = num/a
            subfactors = self.getfactors_with_min(b, a)
            for subfactor in subfactors:
                result.append(subfactor)
            result.append([a,b])
            a +=1

        return result
