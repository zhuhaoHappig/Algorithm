package com.zhh.sort.impl;

import com.zhh.sort.Sort;

public class QuickSort extends Sort {

    /**
     * 思路：设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一趟快速排序，然后在将关键数据前面的进行快速排序...
     * 重点：一般取第一个数据为关键数据key，从第二个元素开始找到大于key的，然后从最后一个元素开始找到小于key的，将它们进行换位；最后找到key所在的位置j，同样，我们可以直接用插入排序对小范围lo-hi排序，这样更有效。
     * 时间复杂度：n*logn, 很快，相对于归并派系，没有额外数组的开销
     * @param a
     */
    public void sort(int[] a){
        sort(a, 0, a.length -1);
    }

    private void sort(int[] a, int lo, int hi){
        if(lo >= hi){//我们可以直接用插入排序对小范围lo-hi排序，这样更有效
            return;
        }
        int partition = partition(a, lo, hi);//一轮排序需要返回key的位置
        sort(a, lo, partition - 1 );
        sort(a,partition + 1, hi);
    }

    private int partition(int[] a, int lo, int hi){

        int i = lo;
        int j = hi + 1;
        int key = a[lo];
        while (true){

            while(a[++i] < key){//i指针右移，找到大于key的元素
                if(i == hi)
                {
                    break;
                }
            }

            while(a[--j] > key){//j指针左移，找到小于key的元素
                if(j == lo)
                {
                    break;
                }
            }

            if(i >= j){//跳出循环条件：i、j出现交叉
                break;
            }
            exchange(a, i, j);//交换i、j
        }
        exchange(a, lo, j);
        return j;//最后指针应该取j，应为最后的j肯定是指向了小于key的元素，所以将j位置的元素和key交换，这样才能保证key左边全是小于key的，右边全是大于key的
    }

}
