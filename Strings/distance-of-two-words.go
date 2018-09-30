/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list
word1 and word2 may be the same and they represent two individual words in the list.
Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
*/

func shortestSameWordDistance(words []string, word1 string, word2 string) int {
	var result=math.MaxInt32

	var hash = make (map[string]int)
	hash[word1] = -1

	for index, word := range words {
		if word == word1 {
			if hash[word1] != -1 {
				dist := math.Abs(float64(hash[word1])-float64(index))
				if int(dist) < result {
					result = int(dist)
				}
			}
			hash[word1] = index
		}
	}
	return result
}

func shortestWordDistance(words []string, word1 string, word2 string) int {
   	if word1 == word2 {
		return shortestSameWordDistance(words, word1, word2)
	}
	var result=math.MaxInt32

	var hash = make (map[string]int)
	hash[word1] = -1
	hash[word2] = -1
	for index, word := range words {
		if word == word1 {
			hash[word1] = index
			if hash[word2] != -1 {
				dist := math.Abs(float64(hash[word1])-float64(hash[word2]))
				if int(dist) < result {
					result = int(dist)
				}
			}
		} else if word == word2 {
			hash[word2] = index
			if hash[word1] != -1 {
				dist := math.Abs(float64(hash[word1])-float64(hash[word2]))
				if int(dist) < result {
					result = int(dist)
				}
			}
		}
	}

	return result
}
