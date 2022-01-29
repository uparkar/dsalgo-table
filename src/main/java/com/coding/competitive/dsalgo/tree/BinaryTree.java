package com.coding.competitive.dsalgo.tree;

public class BinaryTree {

    public TreeNode root;

    private Integer treeDiameter;

    public void initRootNode(int value) {
        root = new TreeNode(value);
    }

    public TreeNode createChildNode(TreeNode parent, int value, boolean addToLeft) {
        TreeNode node = new TreeNode(value);
        if(addToLeft)
            parent.left = node;
        else
            parent.right = node;

        return node;

    }

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

        //Inorder Traversal*******
        bt.inorderTraversal(bt.root);


        //Leaf node count*******
        System.out.printf("\nTotal Leaf nodes = %d",bt.leafNodeCount(bt.root));
        System.out.println();


        BinaryTree bt1 = new BinaryTree();
        bt1.initRootNode(1);
        left = bt1.createChildNode(bt1.root, 3, true);
        bt1.createChildNode(left,7,true);
        right = bt1.createChildNode(bt1.root, 2,false);
        bt1.createChildNode(right,5,true);
        bt1.createChildNode(right,4,false);


        BinaryTree bt2 = new BinaryTree();
        bt2.initRootNode(1);
        left = bt2.createChildNode(bt2.root, 2, true);
        right = bt2.createChildNode(bt2.root, 3,false);
        bt2.createChildNode(left,4,true);
        bt2.createChildNode(left,5,false);

       bt1.inorderTraversal(bt1.root);
       System.out.println();
       bt2.inorderTraversal(bt2.root);
       System.out.println();


    }

    private void inorderTraversal(TreeNode node) {
        if(node==null) return;

        inorderTraversal(node.left);
        System.out.printf("%d ",node.data);
        inorderTraversal(node.right);
    }



    private int leafNodeCount(TreeNode node) {
        if(node == null) return 0;

        if(node.left == null && node.right ==null)
            return 1;

        return leafNodeCount(node.left) + leafNodeCount(node.right);
    }


}
