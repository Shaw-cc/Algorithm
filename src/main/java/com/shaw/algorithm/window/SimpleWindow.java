package com.shaw.algorithm.window;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: Shaw
 * @Date: 2022/3/29 22:22
 */
public class SimpleWindow {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(containsNearbyDuplicate(a, 2));
        System.out.println(findMaxAverage(a, 2));
    }

    //219. 存在重复元素 II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // 643. 子数组最大平均数 I
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (k == nums.length) {
            return 1.0 * sum / k;
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return 1.0 * max / k;
    }
}
