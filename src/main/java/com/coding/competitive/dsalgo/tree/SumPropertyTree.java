package com.coding.competitive.dsalgo.tree;

public class SumPropertyTree {
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

    private static int isSumProperty(TreeNode node) {

        if(node == null || (node.left == null && node.right == null))
            return 1;

        boolean isBothChildsSum = node.left != null && node.right != null && node.data == node.left.data+node.right.data;
        boolean isLeftOnlyChildSum = node.left != null && node.right == null && node.data == node.left.data;
        boolean isRightOblyChildSum = node.left == null && node.right != null && node.data == node.right.data;

        if(isBothChildsSum || isLeftOnlyChildSum || isRightOblyChildSum) {
            return isSumProperty(node.left) & isSumProperty(node.right);
        } else {
            return 0;
        }
    }
}
