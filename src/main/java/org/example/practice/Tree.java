package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // left root right
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public static void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        traversal(root.left, ans);
        ans.add(root.val);
        traversal(root.right, ans);
    }

    //https://leetcode.com/problems/sum-of-left-leaves/
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeft(root, false);
        return ans;
    }
    private void sumOfLeft(TreeNode root, boolean isLeft) {
        if (root == null) return;

        if ((root.left == null && root.right == null) && isLeft) {
            ans += root.val;
        }

        sumOfLeft(root.left, true);
        sumOfLeft(root.right, false);
    }



}


