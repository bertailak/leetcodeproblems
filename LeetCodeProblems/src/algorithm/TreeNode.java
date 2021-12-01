package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author berta
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getMin() {
        if (this.left != null) {
            return getMin(this.left);
        }
        return this;
    }

    TreeNode getMin(TreeNode node) {
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

    public static ListNode insertByOrder(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode node = new ListNode(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            node = new ListNode(nums[i], node);
        }

        return node;
    }

    public void printTree() {
        Queue<TreeNode> s = new LinkedList<>();
        HashMap<Integer, TreeNode> m = new HashMap<>();

        int ind = 0;
        s.add(this);
        m.put(ind++, this);

        while (!s.isEmpty()) {
            TreeNode node = s.poll();
            if (node == null) {
                ind += 2;
            } else {
                s.add(node.left);
                s.add(node.right);
                m.put(ind++, node.left);
                m.put(ind++, node.right);
            }
        }
        Object[] obj = new Object[ind];
        for (Map.Entry<Integer, TreeNode> entry : m.entrySet()) {
            int key = (int) entry.getKey();
            TreeNode value = entry.getValue();
            if (value != null) {
                obj[key] = value.val;
            }
        }
        int j = obj.length - 1;
        while (j > 0) {
            if (obj[j] == null) {
                j--;
            } else {
                break;
            }
        }

        for (int i = 0; i <= j; i++) {
            System.out.print(obj[i] + ", ");
        }
        System.out.println();
    }
}
