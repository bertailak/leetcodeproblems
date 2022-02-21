package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author s_bertailak
 */
public class AlgorithmMedium {

    public static int maximumScore(int a, int b, int c) {
//        https://leetcode.com/problems/maximum-score-from-removing-stones/

        int point = 0;

        if (a >= b && a >= c) {
            int max = Math.max(b, c);
            int min = Math.min(b, c);
            while (max + min > a) {
                max--;
                min--;
                point++;
            }
            point = point + max + min;
        } else if (b >= a && b >= c) {
            int max = Math.max(a, c);
            int min = Math.min(a, c);
            while (max + min > b) {
                max--;
                min--;
                point++;
            }
            point = point + max + min;
        } else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            while (max + min > c) {
                max--;
                min--;
                point++;
            }
            point = point + max + min;
        }

        return point;
    }

    public static String largestMerge(String word1, String word2) {
//        https://leetcode.com/problems/largest-merge-of-two-strings/

        String merge = "";

        while (!word1.isEmpty() && !word2.isEmpty()) {
            if (word1.compareTo(word2) > 0) {
                merge = merge + word1.charAt(0);
                word1 = word1.substring(1);
            } else {
                merge = merge + word2.charAt(0);
                word2 = word2.substring(1);
            }
        }
        merge = merge + word1 + word2;

        return merge;
    }

    public static int[] productExceptSelf(int[] nums) {
//        https://leetcode.com/problems/product-of-array-except-self/

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static int maxProduct(int[] nums) {
//        https://leetcode.com/problems/maximum-product-subarray/

        int max = nums[0];
        int product = nums[0];

        for (int i = 0; i < nums.length; i++) {
            product = nums[i];
            max = Math.max(max, product);
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                max = Math.max(max, product);
            }
        }

        return max;
    }

    public static int findMin(int[] nums) {
//        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[j] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return nums[i];
    }

    public static int search(int[] nums, int target) {
//        https://leetcode.com/problems/search-in-rotated-sorted-array/

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[j] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        if (target == nums[i]) {
            return i;
        }

        if (nums[i] <= target && target <= nums[nums.length - 1]) {
            j = nums.length - 1;
        } else {
            j = i - 1;
            i = 0;
        }

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
//        https://leetcode.com/problems/3sum/

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        lo++;
                    } else {
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static int maxArea(int[] height) {
//        https://leetcode.com/problems/container-with-most-water/

        int volume = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            volume = Math.max(volume, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return volume;
    }

    public static int rob(int[] nums) {
//        https://leetcode.com/problems/house-robber/

        int[] sums = new int[nums.length];

        for (int i = 0; i < sums.length; i++) {
            if (i < 2) {
                sums[i] = nums[i];
            } else {
                sums[i] = nums[i] + Math.max((i - 2 >= 0) ? sums[i - 2] : 0, (i - 3 >= 0) ? sums[i - 3] : 0);
            }
        }

        return Math.max(sums[sums.length - 1], (sums.length - 2 >= 0) ? sums[sums.length - 2] : 0);
    }

    public static int minimumOperations(int[] nums) {
        //https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/

        int count = 0;
        if (nums.length < 2) {
            return count;
        }

        HashMap<Integer, Integer> map0 = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < nums.length / 2 + 1; i++) {
            if (i * 2 < nums.length) {
                map0.put(nums[i * 2], (map0.getOrDefault(nums[i * 2], 0) + 1));
            }
            if ((i * 2 + 1) < nums.length) {
                map1.put(nums[i * 2 + 1], (map1.getOrDefault(nums[i * 2 + 1], 0) + 1));
            }
        }

        int max0 = nums[0];
        int max1 = nums[1];
        for (Map.Entry<Integer, Integer> entry : map0.entrySet()) {
            if (map0.get(max0) < entry.getValue()) {
                max0 = entry.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map1.get(max1) < entry.getValue()) {
                max1 = entry.getKey();
            }
        }

        if (max0 == max1) {
            if (map0.get(max0) > map1.get(max1)) {
                max1 = 0;
                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                    if (max0 != entry.getKey() && map1.getOrDefault(max1, 0) < entry.getValue()) {
                        max1 = entry.getKey();
                    }
                }
            } else {
                max0 = 0;
                for (Map.Entry<Integer, Integer> entry : map0.entrySet()) {
                    if (max1 != entry.getKey() && map0.getOrDefault(max0, 0) < entry.getValue()) {
                        max0 = entry.getKey();
                    }
                }
            }
        }

        count = nums.length - map0.getOrDefault(max0, 0) - map1.getOrDefault(max1, 0);

        return count;
    }

    public static int uniquePaths(int m, int n) {
//        https://leetcode.com/problems/unique-paths/
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[m - 1][n - 1];
    }

    public static boolean canJump(int[] nums) {
//        https://leetcode.com/problems/jump-game/
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];

        int dpIndex = 0;
        dp[dpIndex++] = true;

        for (int i = 0; i < nums.length - 1 && dpIndex < nums.length; i++) {
            while (i < dpIndex && dpIndex <= i + nums[i] && dpIndex < nums.length) {
                dp[dpIndex] = true;
                System.out.println(i + ": " + dpIndex + ": " + dp[dpIndex]);
                dpIndex++;
            }
        }

        return dp[nums.length - 1];
    }

    public static void setZeroes(int[][] matrix) {
//        https://leetcode.com/problems/set-matrix-zeroes/

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    list.add(position);
                }
            }
        }
        for (List<Integer> position : list) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][position.get(1)] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[position.get(0)][i] = 0;
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
//        https://leetcode.com/problems/spiral-matrix/

        List<Integer> result = new ArrayList<>();

        int columnStart = 0;
        int rowStart = 0;
        int columnEnd = matrix[0].length - 1;
        int rowEnd = matrix.length - 1;

        while (columnStart <= columnEnd && rowStart <= rowEnd) {

            for (int i = columnStart; i <= columnEnd; i++) {
                result.add(matrix[rowStart][i]);
            }

            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }

            for (int i = columnEnd - 1; i >= columnStart && rowStart < rowEnd; i--) {
                result.add(matrix[rowEnd][i]);
            }

            for (int i = rowEnd - 1; i > rowStart && columnStart < columnEnd; i--) {
                result.add(matrix[i][columnStart]);
            }
            columnStart++;
            rowStart++;
            rowEnd--;
            columnEnd--;
        }

        return result;
    }

    public static void rotate(int[][] matrix) {
//        https://leetcode.com/problems/rotate-image/

        for (int i = 0; i < matrix.length / 2; i++) {
            int[] current = Arrays.copyOf(matrix[i], matrix[0].length);

            for (int j = i + 1; j < current.length - i; j++) {
                matrix[i][current.length - 1 - j] = matrix[j][i];
                matrix[j][i] = matrix[current.length - 1 - i][j];
                matrix[current.length - 1 - i][j] = matrix[current.length - 1 - j][current.length - 1 - i];
                matrix[current.length - 1 - j][current.length - 1 - i] = current[current.length - 1 - j];
            }
        }
    }

    public static ListNode mergeNodes(ListNode head) {
//        https://leetcode.com/problems/merge-nodes-in-between-zeros/

        int sum = 0;

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            sum += head.val;
            if (head.val == 0 && sum != 0) {
                list.add(sum);
                sum = 0;
            }
            head = head.next;
        }
        if (sum != 0) {
            list.add(sum);
        }

        ListNode nodes = new ListNode(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            nodes = new ListNode(list.get(i), nodes);
        }

        return nodes;
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
//        https://leetcode.com/problems/construct-string-with-repeat-limit/

        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        int index = alphabet.length - 1;

        while (index >= 0) {
            if (alphabet[index] > 0
                    && (sb.length() < repeatLimit
                    || (sb.length() >= repeatLimit
                    && ((sb.subSequence(sb.length() - repeatLimit, sb.length()).chars().distinct().count() > 1)
                    || (sb.charAt(sb.length() - 1) != ('a' + index)))))) {

                sb.append((char) ('a' + index));
                alphabet[index]--;
                index = alphabet.length - 1;
            } else {
                index--;
            }

        }

        return sb.toString();
    }

    public static int climbStairs(int n) {
//        https://leetcode.com/problems/climbing-stairs/

        if (n == 1) {
            return 1;
        }

        int[] steps = new int[n + 1];
        steps[0] = 1;

        for (int i = 1; i < steps.length; i++) {
            steps[i] = steps[i - 1];
            if (i - 2 >= 0) {
                steps[i] += steps[i - 2];
            }
        }

        return steps[n];
    }

    public static int lengthOfLongestSubstring(String s) {
//        https://leetcode.com/problems/longest-substring-without-repeating-characters/

        int length = 0;
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                int ind = list.indexOf(s.charAt(i));

                while (ind-- >= 0) {
                    list.remove(0);
                }
            }
            list.add(s.charAt(i));
            length = Math.max(length, list.size());
        }

        return length;
    }

    public static void main(String[] args) {
    }
}
