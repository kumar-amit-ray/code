/**
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 
 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * @Leetcode - https://leetcode.com/problems/shortest-word-distance-ii/
 */
public class WordDistance2 {
    Map<String, List<Integer>> hmap = new HashMap<>();

    public WordDistance2(String[] words) {
        for (int i=0; i<words.length; i++) {
            if (!hmap.containsKey(words[i])) {
                hmap.put(words[i], new ArrayList<>());
            }
            hmap.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = hmap.get(word1);
        List<Integer> l2 = hmap.get(word2);

        int i=0, j=0, minLen=Integer.MAX_VALUE;

        while (i<l1.size() && j<l2.size()) {
            minLen = Math.min(minLen, Math.abs(l1.get(i)-l2.get(j)));
            if (l1.get(i) > l2.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        return minLen;
    }
}
