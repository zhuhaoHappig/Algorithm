package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class InsertSort extends Sort {

    /**
     * 插入排序
     * 思路：将数组中第二个元素与第一比较，如果比第一个小，就交换位置；再取第三个元素与前2个元素比较，如果比第二个小，交换位置，如果比第一个小，再交换位置...
     * 时间复杂度：O(n^2), n^2/4次比较，n^2/4次交换
     * @param a
     */
    public void sort1(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    exchange(a, j, j-1);
                }
            }
        }
    }

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            for (int j = i; j > 0; j--) {
                if(a[j] < a[j-1]){
                    exchange(a,j,j-1);
                }else{
                    break;
                }
            }

        }

    }

}
