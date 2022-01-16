package com.coding.competitive.dsalgo.tree;

public class BinaryTree {

    private TreeNode root;

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

        bt.initRootNode(10);
        //left subtree
        left = bt.createChildNode(bt.root,6,true);
        right = bt.createChildNode(left,8,false);

        left = bt.createChildNode(left,4,true);

        //right subtree
        right = bt.createChildNode(bt.root,16,false);
        left = bt.createChildNode(right,13,true);
        right = bt.createChildNode(right,20,false);

        //Inorder Traversal*******
        bt.inorderTraversal(bt.root);

        //Leaf node count*******
        System.out.printf("\nTotal Leaf nodes = %d",bt.leafNodeCount(bt.root));
        System.out.println();

        //Tree diameter******
        bt.treeDiameterUsingHeight(bt.root);
        System.out.printf("\n Tree Diameter = %d\n", bt.treeDiameter);

        //Sum tree******
        int sum = bt.isSumTree(bt.root);
        if(sum != Integer.MIN_VALUE)
            System.out.println("Tree is a Sum tree");


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

       //Mirror tree********
       boolean areMirrors = isMirrored(bt1.root,bt2.root);
       System.out.println("Bt1 & Bt2 are mirrors = "+areMirrors);

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

    private int treeDiameterUsingHeight(TreeNode node) {
        if(node == null)
            return 0;

        int leftHt = treeDiameterUsingHeight(node.left);
        int rightHt = treeDiameterUsingHeight(node.right);

        int nodeDiameter = leftHt + rightHt + 1;
        treeDiameter = Math.max(treeDiameter,nodeDiameter);

        return nodeDiameter;
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
