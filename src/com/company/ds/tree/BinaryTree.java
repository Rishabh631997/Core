
package com.company.ds.tree;

import com.company.ds.stack.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {


    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // prints tree/zigzag level order
    public static void spiralOrZigzagLevelOrder(TreeNode root) throws Exception {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        boolean directionflag = false;
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();

            while (!stack.isEmpty()) {
                TreeNode tempNode = stack.pop();
                System.out.printf("%d ", tempNode.data);
                if (!directionflag) {
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                } else {
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                }
            }
            // for changing direction
            directionflag = !directionflag;

            stack = tempStack;
        }

    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    public static Queue<Integer> BFS(TreeNode root) throws Exception {
        if (root == null)
            return null;
        Queue<TreeNode> tempQueue = new ArrayDeque<>();
        tempQueue.add(root);

        Queue<Integer> queue = new ArrayDeque<>();
        while (!tempQueue.isEmpty()) {
            TreeNode node = tempQueue.poll();
            queue.add(node.data);
            if (node.left != null)
                tempQueue.add(node.left);
            if (node.right != null)
                tempQueue.add(node.right);
        }

        return queue;
    }

    public static void printAlternateNodes(TreeNode root) throws Exception {
        Queue queue = BFS(root);
        System.out.println("BFS :"  + queue);
        int size = queue.size();
        System.out.println("Printing Alternate Nodes :" );
        for (int index = 0; index < size; index++) {
            if (index % 2 == 0)
                System.out.println(queue.poll());
            else
                queue.poll();

        }

    }


    public static void main(String[] args) throws Exception {
        // Creating a binary tree
        TreeNode rootNode = createBinaryTree();
        System.out.println("Spiral/Zigzag traversal of binary tree :");
        spiralOrZigzagLevelOrder(rootNode);
        System.out.println();
        System.out.println("Height of binary tree :"  + height(rootNode));
        printAlternateNodes(rootNode);
    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);
        TreeNode node5 = new TreeNode(5);
        TreeNode node55 = new TreeNode(55);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;
        node10.left = node5;
        node50.right = node55;

        return rootNode;
    }
}

