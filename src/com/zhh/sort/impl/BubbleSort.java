package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class BubbleSort extends Sort {

    /**
     * 思路：比较相邻的元素，如果第一个比第二个大，就交换他们，通过第一轮比较，最大的就到数组最尾端了...
     * 时间复杂度：O(n^2)
     * @param a
     */
    public void sort(int[] a){

        int N = a.length;
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N-i-1; j++){
                if(a[j] > a[j+1]){
                    exchange(a, j, j+1);
                }
            }
        }

    }

}
