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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    travel(0, root, ans);
    Collections.reverse(ans);
    return ans;
}

private void travel(int level, TreeNode cur, List<List<Integer>> ans) {
    if (cur == null) return;
    if (level >= ans.size())
        ans.add(new ArrayList<>());
    
    ans.get(level).add(cur.val);    
    
    travel(level + 1, cur.left, ans);
    travel(level + 1, cur.right, ans);
}
}