package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class MergeSort extends Sort {

    /**
     * 归并排序，递归实现
     * 思路：将数组分成2个小的数组进行排序，将小的数组再分为2个小数组排序...，最后进行合并
     * 时间复杂度：n*logn，有额外数组的开销
     * @param a
     */
    public void sort(int[] a){
        int[] aux = new int[a.length];//需要一个数组暂时用于复制
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(int[] a, int[] aux, int lo, int hi){
        if(hi <= lo){
            return;
        }
//        if(hi <= lo + CUTOFF){//由于归并排序最后会产生很多小数组，为了防止这一开销，我们可以将小数组直接用插入排序，这样更有效
//            insertSort(a);
//            return;
//        }
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);//排左边
        sort(a, aux, mid+1, hi);//排右边

//        if(a[mid] <= a[mid+1]){//前一半最大的数如果小于等于后一半最小的数，也不用再合并了，可以提高效率
//            return;
//        }

        merge(a, aux, lo, mid, hi);//左右排完，合并
    }

    private void merge(int[] a, int[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++ ){
            aux[k] = a[k];//暂时复制到aux中
        }

        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++ ){
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(aux[j] < aux[i]){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
    }

    /**
     * mergesort非递归算法
     */
    public void sortNonRecursive(int[] a){
        int N = a.length;
        int[] aux = new int[N];
        for(int sz = 1; sz < N; sz = sz + sz){
            for(int lo = 0; lo < N-sz; lo += sz + sz){
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}
