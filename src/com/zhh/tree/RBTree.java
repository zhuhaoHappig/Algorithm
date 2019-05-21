package com.zhh.tree;

public class RBTree {

    RBNode root;

    private void flipColors(RBNode h){
        h.color = RBNode.RED;
        h.left.color = RBNode.BLACK;
        h.right.color = RBNode.BLACK;
    }

    private RBNode rotateRight(RBNode h){
        RBNode x = h.left;
        x.color = h.color;
        h.color = RBNode.RED;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private RBNode rotateLeft(RBNode h){
        RBNode x = h.right;
        x.color = h.color;
        h.color = RBNode.RED;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private void put(int val){
        root = put(root,val);
        root.color = RBNode.BLACK;
    }


    private RBNode put(RBNode h, int val){
        if(h == null){
            return new RBNode(val, RBNode.RED);
        }
        if(val > h.val){
            h.right = put(h.right, val);
        }else if(val < h.val){
            h.left = put(h.left, val);
        }else{
            h.val = val;
        }
        if(isRed(h.right) && !isRed(h.left)){
            rotateLeft(h);
        }

        if(isRed(h.left) && isRed(h.left.left)){
            rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        return h;
    }

    private boolean isRed(RBNode h){
        if(h == null){
            return false;
        }
        return h.color == RBNode.RED;
    }


}
