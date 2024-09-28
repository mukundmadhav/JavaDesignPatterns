package structural;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = List.of(4,3,1,3,2);
        System.out.println("Sol: " + solution.findMaximumScore(list));
    }

    public long findMaximumScore(List<Integer> nums) {

        long[]dp = new long[nums.size()];

        for (int i = nums.size() - 2; i >=0 ; --i) {
            long max = 0;
            for (int j = i + 1; j < nums.size(); ++j) {
                max = Math.max(max, (long) (j - i) * nums.get(i) + dp[j]);
            }
            dp[i] = max;
        }

        return dp[0];


    }
}