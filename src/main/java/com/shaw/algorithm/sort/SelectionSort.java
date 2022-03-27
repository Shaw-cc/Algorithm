package com.shaw.algorithm.sort;

/**
 * @author: shawcc
 * @Date: 2019-08-07 09:38
 * @Description: 选择排序 较为不稳
 * 最坏时间复杂度	О(n²)
 * 最优时间复杂度	О(n²)
 * 平均时间复杂度	О(n²)
 */
public class SelectionSort extends BaseSort {


    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //  最小元素的下标
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min >= arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
        return arr;
    }

}
