package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class ShellSort extends Sort {

    /**
     * 希尔排序
     * 思路：按步长，跳跃比较元素，如果步长是3，数组有10个元素，先将0、3位置排序，在量1、4位置排序，在将2、5排序...，这样能得到一个部分有序的数组，然后用插入排序进行排序。
     * 步长计算：2^x-1或3x+1
     * 时间复杂度：O(n^(3/2))
     * @param a
     */
    public void sort(int[] a) {

        int N = a.length;

        int h = 1;
        while (h < N / 3) { //计算步长
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    exchange(a, j, j - h);
                }
            }

            h = h / 3;//缩小步长，继续部分排序，直到h=1, 进行插入排序
        }

    }

}
