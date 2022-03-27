package com.shaw.algorithm.sort;

/**
 * @Author: shawcc
 * @Date: 2019-08-06 22:10
 * @Description: 插入排序 较为稳定
 * <p>
 * 最坏时间复杂度	 О(n²)
 * 最优时间复杂度	 O(n)
 * 平均时间复杂度	 О(n²)
 * 100000容量 运行10次
 * InsertionSort: 运行平均时间：1235ms	运行结果为：true
 * https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F
 */
public class InsertionSort extends BaseSort {
    /*
        a[j] < a[j - 1] 不交换

        [5]   6   3   1   8   7   2   4 不交换
          ↑   │
          └───┘
        [5, 6]   3   1   8   7   2   4
        ↑        │
        └────────┘
        [3, 5, 6]  1   8   7   2   4
        ↑          │
        └──────────┘
        [1, 3, 5, 6]  8   7   2   4
                   ↑  │
                   └──┘
        [1, 3, 5, 6, 8]  7   2   4
                    ↑    │
                    └────┘
        [1, 3, 5, 6, 7, 8]  2   4
           ↑                │
           └────────────────┘
        [1, 2, 3, 5, 6, 7, 8]  4
                 ↑             │
                 └─────────────┘

        [1, 2, 3, 4, 5, 6, 7, 8]
     */

    @Override
    public int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            // 将元素比较 插入到前方以排序到的数组 相应的位置
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
                // 较大元素不用在比较 直接插入到最后位置
                else {
                    break;
                }
            }
        }
        return a;
    }


}
