public class WordDistance {
    /**
     *
     * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     *
     * word1 and word2 may be the same and they represent two individual words in the list.
     *
     * Example:
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Input: word1 = “coding”, word2 = “practice”
     * Output: 3
     * Input: word1 = "makes", word2 = "coding"
     * Output: 1
     * Input: word1 = "makes", word2 = "makes"
     * Output: 3
     * Note:
     * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     *
     * @Leetcode - https://leetcode.com/problems/shortest-word-distance/
     * @Leetcode - https://leetcode.com/problems/shortest-word-distance-iii/
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return shortestWordDistanceSameWords(words, word1);
        }
        Map<String, Integer> hmap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                hmap.put(words[i], i);
            }
            if (hmap.containsKey(word1) && hmap.containsKey(word2)) {
                minLen = Math.min(minLen, Math.abs(hmap.get(word1)-hmap.get(word2)));
            }
        }

        return minLen;
    }

    private int shortestWordDistanceSameWords(String[] words, String word) {
        int minLen = Integer.MAX_VALUE;
        Map<String, Integer> hmap = new HashMap<>();
        for (int i= 0; i<words.length; i++) {
            if (!words[i].equals(word)) {
                continue;
            }
            if (hmap.containsKey(word)) {
                minLen = Math.min(minLen, Math.abs(hmap.get(word) - i));
            }
            hmap.put(word, i);
        }
        return minLen;
    }

}

