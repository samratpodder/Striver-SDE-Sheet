import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (60.57%)
 * Likes:    7574
 * Dislikes: 236
 * Total Accepted:    486.9K
 * Total Submissions: 799.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        func(0, s.length(), new ArrayList<>(), res, s);
        return res;
    }
    public void func(int idx, int n, List<String> temp, List<List<String>> res, String str){
        if(idx==n){
            res.add(new ArrayList<>(temp));
            
        }
        for (int i = idx; i < n; i++) {
            if(isPalindrome(str, idx, i)){
                temp.add(str.substring(idx,i+1));
                func(i+1, n, temp, res,str);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start++)!=str.charAt(end--)) return false;
        }
        return true;
    }
}
// @lc code=end

