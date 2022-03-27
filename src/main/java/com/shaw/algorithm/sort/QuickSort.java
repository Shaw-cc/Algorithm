package com.shaw.algorithm.sort;

/**
 * @author: shawcc
 * @Date: 2019-08-09 15:50
 * @Description: 快速排序 快排使用分治法策略来把一个序列（list）分为较小和较大的2个子序列，然后递归地排序两个子序列。
 * 最坏时间复杂度  О(n²)
 * 最优时间复杂度  O(nlogn)
 * 平均时间复杂度  O(nlogn)
 */
public class QuickSort extends BaseSort {
    @Override
    public void sort(int[] arr, int leftPtr, int rightPtr) {
        if (leftPtr >= rightPtr) {
            return;
        }
        // 重新分配轴
        int mid = partition(arr, leftPtr, rightPtr);
        // 将轴的左边重新进行排序
        sort(arr, leftPtr, mid - 1);
        // 右边
        sort(arr, mid + 1, rightPtr);
    }

    /**
     * 以arr的leftPtr到rightPtr为边界；int temp = arr[rightPtr]为轴进行排序
     * 将小于或等于temp分配到左边 大于分配到右边
     * 返回 轴对应的元素排序后新的坐标
     */
    public int partition(int[] arr, int leftPtr, int rightPtr) {
        int temp = arr[rightPtr];
        int index = rightPtr;
        for (int i = leftPtr; i < arr.length; ) {
            if (index == i) {
                swap(arr, rightPtr, i);
                break;
            }
            if (arr[i] > temp) {
                swap(arr, i, --index);
            }
            if (arr[i] <= temp) {
                i++;
            }
        }
        return index;
    }


}
