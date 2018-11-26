package com.zhh.sort;

import com.zhh.sort.impl.*;
import com.zhh.sort.Sort.SortType;

public class SortFactory {

    public static Sort create(SortType type) {
        Sort sort = null;
        switch (type) {
            case MERGE:
                sort = new MergeSort();
                break;
            case QUICK:
                sort = new QuickSort();
                break;
            case SHELL:
                sort = new ShellSort();
                break;
            case INSERT:
                sort = new InsertSort();
                break;
            case SELECT:
                sort = new SelectSort();
                break;
            case BUBBLE:
                sort = new BubbleSort();
                break;
            case THREEWayQS:
                sort = new ThreeWayQuickSort();
                break;
            case HEAPSORT:
                sort = new HeapSort();
                break;
            default:
                break;
        }
        return sort;
    }

}
