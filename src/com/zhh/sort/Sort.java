package com.zhh.sort;

public abstract class Sort {

    public enum SortType{

        INSERT,
        MERGE,
        SELECT,
        SHELL,
        QUICK,
        BUBBLE,
        THREEWayQS,
        HEAPSORT

    }


    public abstract void sort(int[] a);

    protected void exchange(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
