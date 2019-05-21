package com.zhh.tree;

public class BST {

    public Node root;

    public void put(int val){
        root = put(root,val);
    }

    public Node put(Node node, int val){
        if(node == null){
            return new Node(val);
        }

        int value = node.val;
        if(val > value){
            node.right = put(node.right, val);
        }else if(val < value){
            node.left = put(node.left, val);
        }else {
            node.val = val;
        }
        return node;
    }

    public Node get(int val){
        Node x = root;
        while( x != null){
            if(val > x.val){
                x = x.right;
            }else if(val < x.val){
                x = x.left;
            }else{
                return x;
            }
        }
        return null;
    }

    public void delete(int val){
        root = delete(root,val);
    }

    private Node delete(Node node, int val){
        if(node == null){
            return null;
        }

        int value = node.val;
        if(val > value){
            node.right = delete(node.right, val);
        }else if(val < value){
            node.left = delete(node.left, val);
        }else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    public Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
