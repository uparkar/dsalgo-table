package com.coding.competitive.dsalgo.tree;

public class TreeDiameter {
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

    private static int treeDiameterUsingHeight(TreeNode node, int treeDiameter) {
        if(node == null)
            return 0;

        int leftHt = treeDiameterUsingHeight(node.left,treeDiameter);
        int rightHt = treeDiameterUsingHeight(node.right,treeDiameter);

        int nodeDiameter = leftHt + rightHt + 1;
        treeDiameter = Math.max(treeDiameter,nodeDiameter);

        return nodeDiameter;
    }
}
