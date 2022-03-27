package com.shaw.algorithm.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * @author: shawcc
 * @Date: 2019-08-28 12:26
 * @Description:
 */
@Data
@AllArgsConstructor
public class CheckTool {
    private static final CheckTool instance = new CheckTool(1000, 3);
    /**
     * 数组大小
     */
    private int size;
    private int num;

    public static CheckTool getInstance() {
        return instance;
    }

    /**
     * 随机生成10000个int类型数据的数组
     */
    public int[] getRandomArr() {
        Random r = new Random();
        size += r.nextInt(10);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(size);
        }
        size -= r.nextInt(10);
        return arr;
    }

    /**
     * 检测两个数组的值是否相等
     */
    public void check(int[] arr1, int[] arr2) {
        boolean flag = true;
        // 验证
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Right" : "Err");
    }
}
