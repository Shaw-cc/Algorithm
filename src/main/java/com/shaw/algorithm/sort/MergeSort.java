package com.shaw.algorithm.sort;

/**
 * @author: shawcc
 * @Date: 2019-08-07 16:12
 * @Description: 归并排序
 * 归并操作（merge），也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。
 * 最坏时间复杂度	O(nlogn)
 * 最优时间复杂度	O(nlogn)
 * 平均时间复杂度	O(nlogn)
 * 最坏空间复杂度	O(n)
 */
public class MergeSort extends BaseSort {

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        // 左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid + 1, right);
        // 合并排序好的数组
        merge(arr, left, mid + 1, right);
    }

    /**
     * 示例：{1, 4, 7, 8, 3, 6, 9}; merge(arr, 0,4,arr.length - 1);
     * 两个已经排序好的子数组 合并一个 排序数组
     *
     * @param arr        被合并的数组
     * @param leftPtr    左起始指针
     * @param rightPtr   右起始指针
     * @param rightBound 右边界结束标志
     */
    public void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        // 左子数组的边界结束标志
        int mid = rightPtr - 1;
        int[] newArr = new int[rightBound - leftPtr + 1];
        // 第一个子数组 起始指针
        int i = leftPtr;
        // 第二个子数组 起始指针l;p
        int j = rightPtr;
        // 新数组起始指针
        int k = 0;
        // 相互比较 较小的插入到新数组中
        while (i <= mid && j <= rightBound) {
            if (arr[i] >= arr[j]) {
                newArr[k++] = arr[j++];
            } else {
                newArr[k++] = arr[i++];
            }
        }
        // 剩余元素 添加到新数组中
        while (j <= rightBound) {
            newArr[k++] = arr[j++];
        }
        while (i <= mid) {
            newArr[k++] = arr[i++];
        }
        // 将排序好的数组覆盖原数组
        System.arraycopy(newArr, 0, arr, leftPtr, newArr.length);
    }

}
