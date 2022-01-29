package com.coding.competitive.dsalgo.tree;

public class SumChildPath {
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

    private static long sumChildPath(TreeNode node, String currPath, long sum) {
        if(node == null) {
            return 0;
        }

        if(node.left == null && node.left == null) {
            sum += Long.valueOf(currPath + String.valueOf(node.data));
            return sum;
        }

        long lSum = sumChildPath(node.left,currPath+String.valueOf(node.data),sum);
        long rSum = sumChildPath(node.right,currPath+String.valueOf(node.data), sum);

        return lSum + rSum;

    }
}
