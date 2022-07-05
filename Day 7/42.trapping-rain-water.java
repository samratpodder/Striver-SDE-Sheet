/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (57.19%)
 * Likes:    19748
 * Dislikes: 278
 * Total Accepted:    1.2M
 * Total Submissions: 2.1M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int actualTrap = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] canTrap = new int[n];
        for(int i = 0;i<n;i++)
        {
                if(i==0) prefix[i] = 0;
                else prefix[i] = Math.max(height[i-1],prefix[i-1]);
        } 
        for(int i = n-1;i>=0;i--)
        {
                if(i==n-1) suffix[i] = 0;
                else suffix[i] = Math.max(height[i+1],suffix[i+1]);
        } 
        for(int i=0;i<n;i++) canTrap[i] = Math.min(prefix[i],suffix[i]);
        for(int i=0;i<n;i++) actualTrap+=canTrap[i]>height[i]?canTrap[i]-height[i]:0;
        return actualTrap;
    }
}
// @lc code=end

