package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NtreePreoderTraversal {

    //recursion time/space O(n)
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> recursion(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children) {
            recursion(node);
        }
        return list;
    }

    //stack time/space O(n)
    public List<Integer> preOrderStack(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return list;
    }

    public class Node {
        public ArrayList<Node> children;
        private int val;
        public Node(int val){
            this.val = val;
        }
    }
}
