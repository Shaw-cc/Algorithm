package com.shaw.algorithm.sort;

/**
 * @author: shawcc
 * @Date: 2019-08-07 14:18
 * @Description: 希尔排序
 * 最坏时间复杂度	根据步长序列的不同而不同。已知最好的： O(n·log²n)
 * 最优时间复杂度	O(n)
 */
public class ShellSort extends BaseSort {
    public static void main(String[] args) {
        test(new ShellSort());
    }

    /**
     * 复杂度与增量序列有关
     */


    @Override
    public int[] sort(int[] arr) {
        // Knuth增量:1,4,13,40,...,(3^k - 1)/2
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                // 将元素比较 插入到前方以排序到的数组 相应的位置
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                    // 较大元素不用在比较 直接插入到最后位置
                    else {
                        break;
                    }
                }
            }
        }
        return arr;
    }

}
