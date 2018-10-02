/*
Youtube - https://www.youtube.com/watch?v=_nCsPn7_OgI&t=24s
*/

func longestPalindromeSubsequence(s string) int {
	var dp [][]int

	dp = make([][]int, len(s))
	for i:= 0; i<len(dp); i++ {
		dp[i] = make ([]int, len(s))
	}
	for i:=0; i<len(s); i++ {
		dp[i][i] = 1
	}

	for l:=2; l<=len(s); l++ {
		for i:=0; i<=len(s)-l; i++ {
			j := l+i-1
			if l == 2 && s[i] == s[j] {
				dp[i][j] = 2
			} else if s[i] == s[j] {
				dp[i][j] = 2+dp[i+1][j-1]
			} else {
				dp[i][j] = getmax(dp[i+1][j], dp[i][j-1])
			}
		}
	}
	fmt.Println(dp)
	return dp[0][len(s)-1]
}
