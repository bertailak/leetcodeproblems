package algorithm;

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

    public static void main(String[] args) {

    }
}
