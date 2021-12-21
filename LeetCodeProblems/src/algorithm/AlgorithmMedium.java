package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
