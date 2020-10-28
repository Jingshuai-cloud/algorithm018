package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal pt = new PreorderTraversal();
        pt.createBinaryTree();
        pt.preOrder(pt.root);
        System.out.println(pt.preOrderTraversal(pt.root));
    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private TreeNode root;
    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public  void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = five;
        second.left = third;
        second.right = fourth;
    }
}
