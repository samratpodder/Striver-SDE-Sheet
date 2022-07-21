import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Hard (42.71%)
 * Likes:    4315
 * Dislikes: 404
 * Total Accepted:    284.6K
 * Total Submissions: 663.6K
 * Testcase Example:  '3\n3'
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * 
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 * Input: n = 3, k = 1
 * Output: "123"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 1 <= k <= n!
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact*i;
            list.add(i);
        }
        list.add(n);
        k--;
        StringBuilder ans = new StringBuilder();
        while(!list.isEmpty())
        {
            ans.append(list.get(k/fact));
            list.remove(k/fact);
            k=k%fact;
            if(list.isEmpty())break;
            fact = fact/list.size();
        }
        return ans.toString();
    }
}
// @lc code=end

