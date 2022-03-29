package com.shaw.algorithm.dp.medium;

/**
 * <a href='https://leetcode-cn.com/problems/delete-and-earn/'>740. 删除并获得点数</a>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数
 * <p>
 *
 * @Author : Shaw
 * @Date : 2022/3/28 20:58
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        //int[] a = {1, 2, 3, 1, 2, 3};
        //int[] a = {1, 2};
        int[] a = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(a));
    }


    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        int[] dp = new int[sum.length];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for (int i = 2; i < sum.length; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
