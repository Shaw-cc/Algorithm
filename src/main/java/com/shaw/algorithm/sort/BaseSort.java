package com.shaw.algorithm.sort;

import java.util.Arrays;

/**
 * @author: shawcc
 * @Date: 2019-08-07 11:22
 * @Description: Sort方法的基类
 */
public class BaseSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(BaseSort sortMethod) {
        CheckTool tool = CheckTool.getInstance();
        for (int i = 0; i < tool.getNum(); i++) {
            int[] test1 = tool.getRandomArr();
            int[] test2 = Arrays.copyOf(test1, test1.length);
            sortMethod.sort(test1);
            Arrays.sort(test2);
            tool.check(test1, test2);
        }
    }

    public void print(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public void sort(int[] arr, int left, int right) {
    }

    public int[] sort(int[] arr) {
        return new int[0];
    }

}
