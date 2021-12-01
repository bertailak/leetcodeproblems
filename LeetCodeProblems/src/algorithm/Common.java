/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author berta
 */
public class Common {

    public Common() {
    }

    public static TreeNode insert_Recursive(TreeNode root, Object key) {
        if (root == null) {
            root = new TreeNode((int) key);
            return root;
        }
        if ((int) key < root.val) {
            root.left = insert_Recursive(root.left, key);
        } else if ((int) key > (int) root.val) {
            root.right = insert_Recursive(root.right, key);
        }
        return root;
    }

    public static TreeNode insertByOrder(int index, Object[] keys) {
        if (index < keys.length && keys[index] != null) {
            TreeNode root = new TreeNode((int) keys[index]);
            root.left = insertByOrder(index * 2 + 1, keys);
            root.right = insertByOrder(index * 2 + 2, keys);
            return root;
        }
        return null;
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

}
