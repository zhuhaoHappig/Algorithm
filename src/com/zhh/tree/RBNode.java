package com.zhh.tree;

public class RBNode {

    public static final int RED = 0;
    public static final int BLACK = 1;
    public RBNode left;
    public RBNode right;
    public int val;

    public RBNode(int val, int color) {
        this.color = color;
        this.val = val;
    }

    int color;



}
