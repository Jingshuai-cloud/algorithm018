package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal It = new InorderTraversal();
        It.createBinaryTree();
        It.inOrder(It.root);
        System.out.println(It.inOrderTraversal(It.root));
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList result = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    private TreeNode root;
    
    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void createBinaryTree() {
        InorderTraversal.TreeNode first = new InorderTraversal.TreeNode(1);
        InorderTraversal.TreeNode second = new InorderTraversal.TreeNode(2);
        InorderTraversal.TreeNode third = new InorderTraversal.TreeNode(3);
        InorderTraversal.TreeNode fourth = new InorderTraversal.TreeNode(4);
        InorderTraversal.TreeNode five = new InorderTraversal.TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = five;
    }
}
