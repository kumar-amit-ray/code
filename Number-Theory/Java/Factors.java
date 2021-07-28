/**
    @LeetCode - https://leetcode.com/problems/factor-combinations/
 */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n <= 1) {
            return new ArrayList();
        }
        
        return getSubfactors(n, 2);
    }
    
    private List<List<Integer>> getSubfactors(int num, int start) {
        List<List<Integer>> result = new ArrayList();

        for (int i=start; i<=Math.sqrt(num); i++) {
            if (num % i != 0) {continue;}
            int newNum = num/i;
            List<List<Integer>> subFactors= getSubfactors(newNum, i);
            for (List<Integer> l : subFactors) {
                l.add(i);
                result.add(l);
            }
            result.add(new ArrayList<Integer>(Arrays.asList(i, newNum)));
        }

        return result;
    }
}
