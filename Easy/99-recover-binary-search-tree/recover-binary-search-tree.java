/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inorder = new ArrayList<>();
    int index = 0;
    public void recoverTree(TreeNode root) {
        store(root);
        Collections.sort(inorder);
        fix(root);
    }
    void store(TreeNode root) {
        if (root == null) return;
        store(root.left);
        inorder.add(root.val);
        store(root.right);
    }
    void fix(TreeNode root) {
        if (root == null) return;
        fix(root.left);
        root.val = inorder.get(index++);
        fix(root.right);
    }
}