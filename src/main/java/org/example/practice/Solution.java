package org.example.practice;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();

    }

    public int maxScore(TreeNode root, int x) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        int maxScore = Integer.MIN_VALUE;
        for(int i=0; i<nodes.size()-1; i++) {
            for(int j=i+1; j<nodes.size(); j++) {
                maxScore = Math.max(maxScore, Math.abs(x-nodes.get(i))+Math.abs(x-nodes.get(j)));
            }
        }

        return maxScore;
    }


    // Helper function for inorder traversal of BST
    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;

        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

}

