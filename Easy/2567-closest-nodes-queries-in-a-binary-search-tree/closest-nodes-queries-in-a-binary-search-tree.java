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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorderTraversal(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            int floor = findFloor(q);
            int ceil = findCeil(q);
            ans.add(Arrays.asList(floor, ceil));
        }
        return ans;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    private int findFloor(int key) {
        int left = 0, right = inorder.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inorder.get(mid) == key)
                return key;
            if (inorder.get(mid) < key) {
                ans = inorder.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int findCeil(int key) {
        int left = 0, right = inorder.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inorder.get(mid) == key)
                return key;
            if (inorder.get(mid) < key) {
                left = mid + 1;
            } else {
                ans = inorder.get(mid);
                right = mid - 1;
            }
        }
        return ans;
    }
}