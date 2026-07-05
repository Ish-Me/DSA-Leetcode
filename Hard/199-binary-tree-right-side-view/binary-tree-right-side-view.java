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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(ans,root,0);
        return ans;
    }
    public void rightView(List<Integer> ans,TreeNode node,int level){
        if(node == null)return;
        if(level == ans.size())ans.add(node.val);
        rightView(ans,node.right,level+1);
        rightView(ans,node.left,level+1);
    }
}