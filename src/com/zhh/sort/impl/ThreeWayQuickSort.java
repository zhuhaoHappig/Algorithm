package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class ThreeWayQuickSort extends Sort {

    /**
     * 有很多相同的元素，3-way quicksort
     * @param a
     */
    public void sort(int[] a) {

        sort(a, 0, a.length-1);

    }

    private void sort(int[] a, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int lt = lo;
        int gt = hi;
        int v = a[lo];
        int i = lo;
        while(i <= gt){
            if(a[i] < v){
                exchange(a, lt++, i++);
            }else if(a[i] > v){
                exchange(a, i, gt--);
            }else{
                i++;
            }
        }

        sort(a, lo, lt-1);
        sort(a, gt+1,hi);
    }
}
