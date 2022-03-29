package com.shaw.algorithm.dp.medium;

/**
 * <a href='https://leetcode-cn.com/problems/house-robber/'>198. 打家劫舍</a>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 *
 * @Description : 打家劫舍
 * @Author : Shaw
 * @Date : 2022/3/28 12:24
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(rob(a));
        System.out.println(rob1(a));
    }


    // 打家劫舍I
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < dp.length; i++) {
            // dp[i]的值：前一个偷取，则不能偷取当前放假，价值为 dp[i-1]
            //           前一个不偷取，则说明dp[i-2]偷取了，加上当前房间的价值
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


    /**
     * <a href='https://leetcode-cn.com/problems/house-robber-ii/'>213. 打家劫舍 II</a>
     */
    public static int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < dp1.length - 1; i++) {
            // dp[i]的值：前一个偷取，则不能偷取当前放假，价值为 dp[i-1]
            //           前一个不偷取，则说明dp[i-2]偷取了，加上当前房间的价值
            // 当第一个选了
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            // 当第一个没选
            dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);

    }
}
