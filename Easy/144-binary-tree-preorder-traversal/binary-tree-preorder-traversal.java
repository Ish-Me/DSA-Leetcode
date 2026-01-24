/*
* public class TreeNode {
*       int val;
*       TreeNode left;
*       TreeNode right;
*       TreeNode() {}
*       TreeNode(int val) { this.val = val; }
*       TreeNode(int val, TreeNode left, TreeNode right) {
*          this.val = val;
*           this.left = left;
*          this.right = right;
*       }
*  }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        ans.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        ans.addAll(right);

        return ans;
}
}