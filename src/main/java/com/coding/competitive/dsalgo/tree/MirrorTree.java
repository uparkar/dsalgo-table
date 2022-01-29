package com.coding.competitive.dsalgo.tree;

public class MirrorTree {
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

    private static boolean isMirrored(TreeNode node1, TreeNode node2) {
        if(node1 != null && node2 != null) {
            if(node1.data != node2.data)
                return false;
            boolean subTree1 = isMirrored(node1.left,node2.right);
            boolean subTree2 = isMirrored(node1.right, node2.left);
            return  subTree1 && subTree2;
        } else {
            return node1 == null && node2 == null;
        }
    }
}
