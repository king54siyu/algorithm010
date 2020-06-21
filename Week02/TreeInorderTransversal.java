import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInorderTransversal {

    /**
     * Because of the special structure of Tree
     * 1. we can easily think of the method of the recursion
     *      The other way to iterate through is just change the order of transverse.
     * 2. Similarly, we can use the Stack to iterate through the tree
     *      The most important is how do we push and pop from the stack
     */

    // The tree node in the java code
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // all kinds of constructors
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        // first, we initiate a List to store the result of transversal
        List<Integer> res = new ArrayList<>();

        // The inorder transversal is based on the left -> root -> right
        if (root != null) {
            // transverse the left side recursively
            if (root.left != null) {
                res.addAll(inorderTraversal(root.left));
            }
            // add the value of the root
            res.add(root.val);
            // transverse the right side
            if (root.right != null) {
                res.addAll(inorderTraversal(root.right));
            }

        }

        // if the root is null
        return res;
    }

    // Method 2: using the stack to iterate through the tree
    public List<Integer> inorderTraversal2(TreeNode root) {

        // initiate a List and Stack to store the result and all iterated tree node
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // current position
        TreeNode curr = root;
        // this part is the most important part !!
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


}
