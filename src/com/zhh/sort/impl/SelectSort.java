package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class SelectSort extends Sort {

    /**
     * 选择排序
     * 思路：在数组中找出最小的元素，和第一个元素交换位置，再从剩下的找出最小的，和第二交换位置...
     * 时间复杂度：O(n^2), n^2/2次比较，n次交换
     *
     * @param a
     */
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                exchange(a, i, min);
            }
        }

    }
}
