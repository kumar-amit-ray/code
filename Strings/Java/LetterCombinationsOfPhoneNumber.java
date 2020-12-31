/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

@Leetcode - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/

class Solution {
    Map<String, String> mapper = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {return result;}
        letterCombinationsRecursive(digits, 0, "", result);
        return result;
    }
    
    private void letterCombinationsRecursive(String digits, int index, String curr, List<String>result) {
        if (index == digits.length()) {
            result.add(curr);
        } else {
            String mapString = mapper.get(String.valueOf(digits.charAt(index)));
            for (int i = 0; i < mapString.length(); i++) {
                letterCombinationsRecursive(digits, index + 1, curr + mapString.charAt(i), result);
            }
        }
    }
}
