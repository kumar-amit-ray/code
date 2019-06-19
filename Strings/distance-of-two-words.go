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


In Python
==========

import sys

def find_min_distance_between_two_same_words(words, word1):
    distance = dict()
    distance[word1] = sys.maxint

    result = sys.maxint
    for index, word in enumerate(words):
        if word ==word1:
            if distance[word1] != sys.maxint:
                result = min(result, abs(distance[word1] - index))
            distance[word1] = index

    print 'min distance between words:%s and %s is %d' % (word1, word1, result)

def find_min_distance_between_two_words(words, word1, word2):
    distance = dict()
    distance[word1] = sys.maxint
    distance[word2] = sys.maxint

    result = sys.maxint
    for index, word in enumerate(words):
        if word == word1:
            distance[word1] = index
            if distance[word2] != sys.maxint:
                result = min(result, abs(distance[word2]-distance[word1]))

        if word == word2:
            distance[word2] = index
            if distance[word1] != sys.maxint:
                result = min(result, abs(distance[word2]-distance[word1]))

    print 'min distance between words:%s and %s is %d' %(word1, word2, result)
