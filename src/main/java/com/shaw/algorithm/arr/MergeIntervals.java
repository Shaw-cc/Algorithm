package com.shaw.algorithm.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href='https://leetcode-cn.com/problems/merge-intervals/'>56. 合并区间</a>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{9, 11}, {7, 10}, {2, 4}, {2, 5}, {6, 7}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }


    /**
     * 模拟
     * - 排序
     * 根据规则合并
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.parallelSort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> res = new ArrayList<>();
        // 合并后的结果
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int start = temp[0];
            int end = temp[1];
            int nStart = intervals[i][0];
            int nEnd = intervals[i][1];
            // 合并
            // 排序后start <= nStart
            if (start == nStart) {
                // 相同，返回范围大的
                temp = end >= nEnd ? temp : intervals[i];
            } else if (end < nStart) {
                // 无关，不能再合并，缓存上一次结果
                res.add(temp);
                temp = intervals[i];
            } else {
                // 包含再上个区间中，比较结束区间的大小
                temp[1] = Math.max(end, nEnd);
            }
        }
        // 无法再合并，将最终的temp缓存
        res.add(temp);
        return res.toArray(new int[0][0]);
    }


}

