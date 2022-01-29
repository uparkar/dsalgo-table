package com.coding.competitive.dsalgo.tree;

public class SumTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode left, right;

        bt.initRootNode(20);
        //left subtree
        left = bt.createChildNode(bt.root,4,true);
        right = bt.createChildNode(left,5,false);

        left = bt.createChildNode(left,-1,true);

        //right subtree
        right = bt.createChildNode(bt.root,16,false);
        left = bt.createChildNode(right,13,true);
        right = bt.createChildNode(right,3,false);
        right = bt.createChildNode(right,3,false);
    }

    private int isSumTree(TreeNode currNode) {
        if(currNode == null)
            return 0;

        if(currNode.left == null && currNode.right == null) { // we reached a leaf node
            return currNode.data;
        }

        int leftSum = isSumTree(currNode.left);
        int rtSum = isSumTree(currNode.right);

        if(currNode.data == leftSum+rtSum) { //TODO: something is missing as -ve test case not working correctly
            return currNode.data + leftSum + rtSum;
        } else
            return Integer.MIN_VALUE;

    }
}
