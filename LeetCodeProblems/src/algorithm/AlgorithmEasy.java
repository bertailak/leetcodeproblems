package algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author @bertailak
 */
public class AlgorithmEasy {

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

    public static void printTree(TreeNode root) {
        Queue<TreeNode> s = new LinkedList<>();
        HashMap<Integer, TreeNode> m = new HashMap<>();

        int ind = 0;
        s.add(root);
        m.put(ind++, root);

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
            System.out.print(obj[i] + " ");
        }
        System.out.println();
    }

    public static class TreeNode {

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
    }

    public static class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int countBalls(int lowLimit, int highLimit) {
//        https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

        int max = 0;
        int[] sums = new int[100000];
        for (int i = lowLimit; i <= highLimit; i++) {
            sums[getSum(i) - 1]++;
            if (max < sums[getSum(i) - 1]) {
                max = sums[getSum(i) - 1];
            }
        }
        return max;
    }

    public static boolean check(int[] nums) {
//        https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

        boolean res = false;

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums.length; i++) {

            List<Integer> list2 = list.subList(i, nums.length);
            list2.addAll(list.subList(0, i));

            int l = 0;
            for (int j = 0; j < nums.length - 1; j++) {
                if (list2.get(j) <= list2.get(j + 1)) {
                    l++;
                }
            }
            if (l == nums.length - 1) {
                res = true;
                break;
            }
        }

        return res;
    }

    public static int[] runningSum(int[] nums) {
//        https://leetcode.com/problems/running-sum-of-1d-array/
//        int[] n = {1, 2, 3};
//        n = runningSum(n);
//        for (int i = 0; i < n.length; i++) {
//            System.out.print(n[i] + " ");
//        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static String defangIPaddr(String address) {
//        https://leetcode.com/problems/defanging-an-ip-address/
//        System.out.println(defangIPaddr("1.1.1.1"));

        return address.replace(".", "[.]");
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//        https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
//        List<Boolean> b = kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
//        for (int i = 0; i < b.size(); i++) {
//            System.out.print(b.get(i) + " ");
//        }

        List<Boolean> b = new ArrayList<Boolean>();
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                b.add(true);
            } else {
                b.add(false);
            }
        }
        return b;
    }

    public static int maximumWealth(int[][] accounts) {
//        https://leetcode.com/problems/richest-customer-wealth/
//        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
//        System.out.println(maximumWealth(accounts));

        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = accounts[i][0];
            for (int j = 1; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int[] shuffle(int[] nums, int n) {
//        https://leetcode.com/problems/shuffle-the-array/
//        int[] a = shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length / 2; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[res.length / 2 + i];
        }
        return res;
    }

    public static int numIdenticalPairs(int[] nums) {
//        https://leetcode.com/problems/number-of-good-pairs/
//        System.out.println(numIdenticalPairs(new int[]{1,2,3}));

        int good = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    good++;
                }
            }
        }
        return good;
    }

    public static int numJewelsInStones(String jewels, String stones) {
//        https://leetcode.com/problems/jewels-and-stones/
//        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                count++;
            }
        }
        return count;

    }

    class ParkingSystem {
//        https://leetcode.com/problems/design-parking-system/

        int[] a;

        public ParkingSystem(int big, int medium, int small) {
            a = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            boolean res = false;
            if (a[carType - 1] > 0) {
                res = true;
                a[carType - 1]--;
            }
            return res;
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
//        https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
//        int[] res = smallerNumbersThanCurrent(new int[]{1, 3, 2, 3});
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }

        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums2[j] == nums[i]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static String interpret(String command) {
//        https://leetcode.com/problems/goal-parser-interpretation/
//        System.out.println(interpret("G()(al)"));
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static int[] decode(int[] encoded, int first) {
//        https://leetcode.com/problems/decode-xored-array/
//        decode(new int[]{1, 2, 3}, 1);

        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    public static String restoreString(String s, int[] indices) {
//        https://leetcode.com/problems/shuffle-string/
//        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));

        char[] c = new char[indices.length];
        for (int i = 0; i < c.length; i++) {
            c[indices[i]] = s.charAt(i);
        }
        return new String(c);
    }

    public static int numberOfSteps(int num) {
//        https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
//        System.out.println(numberOfSteps(14));

        int step = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            step++;
        }

        return step;
    }

    public static int subtractProductAndSum(int n) {
//        https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
//        System.out.println(subtractProductAndSum(234));

        int product = 1;
        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            product *= m;
            sum += m;
            n /= 10;
        }
        return product - sum;
    }

    public static int[] decompressRLElist(int[] nums) {
//        https://leetcode.com/problems/decompress-run-length-encoded-list/
//        int[] a = decompressRLElist(new int[]{1, 2, 3, 4});
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            for (int j = 0; j < nums[2 * i]; j++) {
                arr.add(nums[2 * i + 1]);
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
//        https://leetcode.com/problems/create-target-array-in-the-given-order/
//        int[] a = createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0});
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int xorOperation(int n, int start) {
//        https://leetcode.com/problems/xor-operation-in-an-array/
//        System.out.println(xorOperation(10, 5));

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }

    public static int balancedStringSplit(String s) {
//        https://leetcode.com/problems/split-a-string-in-balanced-strings/
//        System.out.println(balancedStringSplit("RLRRRLLRLL"));

        int count = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.empty() || st.peek() == s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                st.pop();
                if (st.empty()) {
                    count++;
                }
            }
        }

        if (!st.empty()) {
            count--;
        }

        return count;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
//        https://leetcode.com/problems/count-the-number-of-consistent-strings/
//        System.out.println(countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < allowed.length(); j++) {
                words[i] = words[i].replaceAll(allowed.charAt(j) + "", "");
            }
            if (words[i].length() == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
//        System.out.println(arrayStringsAreEqual(new String[]{"ac", "c"}, new String[]{"a", "bc"}));

        if (String.join("", word1).equals(String.join("", word2))) {
            return true;
        }
        return false;
    }

    public static int maxDepth(String s) {
//        https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
//        System.out.println(maxDepth("1+(2*3)/(2-1)"));

        int depth = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                if (depth > max) {
                    max = depth;
                }
            } else if (s.charAt(i) == ')') {
                depth--;
            }
        }
        return max;
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
//        https://leetcode.com/problems/range-sum-of-bst/
        if (root == null) {
            return 0;
        } else {
            int sum = (root.val >= low && root.val <= high ? root.val : 0);
            sum = sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            return sum;
        }
    }

    public static int numberOfMatches(int n) {
//        https://leetcode.com/problems/count-of-matches-in-tournament/
//        System.out.println(numberOfMatches(7));

        return --n;

    }

    static class OrderedStream {
//        https://leetcode.com/problems/design-an-ordered-stream/
//        OrderedStream obj = new OrderedStream(5);
//        int[] ind = new int[]{3, 1, 2, 5, 4};
//        String[] val = new String[]{"ccccc", "aaaaa", "bbbbb", "eeeee", "ddddd"};
//        for (int i = 0; i < val.length; i++) {
//            List<String> s = obj.insert(ind[i], val[i]);
//            for (String s2 : s) {
//                System.out.print(s2 + ":");
//            }
//            System.out.println();
//        }

        int ptr;
        List<String> s;

        public OrderedStream(int n) {
            ptr = 0;
            s = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                s.add("");
                System.out.print(s.get(i) + ":");
            }
            System.out.println();
        }

        public List<String> insert(int id, String value) {
            s.set(id - 1, value);
            int iter = ptr;
            while (iter < s.size() && !s.get(iter).isEmpty()) {
                iter++;
            }
            List<String> ss = s.subList(ptr, iter);
            ptr = iter;
            return ss;
        }
    }

    public static int sumOddLengthSubarrays(int[] arr) {
//        https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
//        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if ((j - i) % 2 == 0) {
                    total += sum;
                }
            }
        }

        return total;
    }

    public static int largestAltitude(int[] gain) {
//        https://leetcode.com/problems/find-the-highest-altitude/
//        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));

        int max = 0;
        int sum = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
//        https://leetcode.com/problems/count-good-triplets/
//        System.out.println(countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));

        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static String toLowerCase(String str) {
//        https://leetcode.com/problems/to-lower-case/
//        System.out.println(toLowerCase("al&phaBET"));

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                s.append((char) ((byte) str.charAt(i) + 32));
            } else {
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
//        https://leetcode.com/problems/minimum-time-visiting-all-points/
//        System.out.println(minTimeToVisitAllPoints(new int[][]{{559, 511}, {932, 618}, {-623, -443}, {431, 91}, {838, -127}, {773, -917}, {-500, -910}, {830, -417}, {-870, 73}, {-864, -600}, {450, 535}, {-479, -370}, {856, 573}, {-549, 369}, {529, -462}, {-839, -856}, {-515, -447}, {652, 197}, {-83, 345}, {-69, 423}, {310, -737}, {78, -201}, {443, 958}, {-311, 988}, {-477, 30}, {-376, -153}, {-272, 451}, {322, -125}, {-114, -214}, {495, 33}, {371, -533}, {-393, -224}, {-405, -633}, {-693, 297}, {504, 210}, {-427, -231}, {315, 27}, {991, 322}, {811, -746}, {252, 373}, {-737, -867}, {-137, 130}, {507, 380}, {100, -638}, {-296, 700}, {341, 671}, {-944, 982}, {937, -440}, {40, -929}, {-334, 60}, {-722, -92}, {-35, -852}, {25, -495}, {185, 671}, {149, -452}}));
//        System.out.println(minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
//        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));

        int[][] dir = new int[][]{{-1, 1}, {1, 1}, {-1, -1}, {1, -1}, {0, 1}, {-1, 0}, {0, 0}, {1, 0}, {0, -1}};
        int step = 0;
        int iter = 0;
        while (iter < points.length - 1) {
            for (int i = 0; i < dir.length; i++) {
                int diff = Math.abs(points[iter + 1][0] - points[iter][0]) + Math.abs(points[iter + 1][1] - points[iter][1]);
                if (Math.abs(points[iter + 1][0] - (points[iter][0] + dir[i][0])) + Math.abs(points[iter + 1][1] - (points[iter][1] + dir[i][1])) < diff) {
                    step++;
                    points[iter][0] += dir[i][0];
                    points[iter][1] += dir[i][1];
                    break;
                }
            }

            if (points[iter][0] == points[iter + 1][0]
                    && points[iter][1] == points[iter + 1][1]) {
                iter++;
            }
        }
        return step;
    }

    public static int findNumbers(int[] nums) {
//        https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
//        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            while (nums[i] > 0) {
                nums[i] /= 10;
                len++;
            }
            if (len % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static String removeOuterParentheses(String S) {
//        https://leetcode.com/problems/remove-outermost-parentheses/
//        System.out.println(removeOuterParentheses("(()())()(()(()))"));
        String res = "";
        int count = 0;
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            ss.append(S.charAt(i));
            if (count == 0) {
                res = res + ss.toString().substring(1, ss.length() - 1);
                ss = new StringBuilder();
            }
        }
        return res;
    }

    public static int oddCells(int n, int m, int[][] indices) {
//        https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
//        System.out.println(oddCells(2, 2, new int[][]{{0, 0}, {1, 1}}));

        int count = 0;

        int[][] a = new int[n][m];

        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < m; j++) {
                if (++a[indices[i][0]][j] % 2 == 1) {
                    count++;
                } else {
                    count--;
                }
            }
            for (int j = 0; j < n; j++) {
                if (++a[j][indices[i][1]] % 2 == 1) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count;
    }

    public static int uniqueMorseRepresentations(String[] words) {
//        https://leetcode.com/problems/unique-morse-code-words/
//        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> codes = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder st = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                st.append(morse[words[i].charAt(j) - 'a']);
            }
            codes.add(st.toString());
        }
        return codes.size();
    }

    public static int diagonalSum(int[][] mat) {
//        https://leetcode.com/problems/matrix-diagonal-sum/
//        System.out.println(diagonalSum(new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}}));

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (i != mat.length - 1 - i) {
                sum += mat[i][mat.length - 1 - i];
            }
        }
        return sum;
    }

    public static int[][] flipAndInvertImage(int[][] A) {
//        https://leetcode.com/problems/flipping-an-image/
//        int[][] a = flipAndInvertImage(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length / 2; j++) {
                int swap = A[i][j];
                A[i][j] = 1 - A[i][A.length - 1 - j];
                A[i][A.length - 1 - j] = 1 - swap;
            }
            if (A.length % 2 == 1) {
                A[i][A.length / 2] = 1 - A[i][A.length / 2];
            }
        }
        return A;
    }

    public static int maximum69Number(int num) {
//        https://leetcode.com/problems/maximum-69-number/
//        System.out.println(maximum69Number(9669));

        char[] c = (num + "").toCharArray();
        for (int j = 0; j < c.length; j++) {
            if (c[j] == '6') {
                c[j] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }

    public static int sumOfUnique(int[] nums) {
//        https://leetcode.com/problems/sum-of-unique-elements/
//        System.out.println(sumOfUnique(new int[]{1,2,3,4,5}));

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 0);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 0) {
                sum += integer;
            }
        }
        return sum;
    }

    public static int countGoodRectangles(int[][] rectangles) {
//        https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
//        System.out.println(countGoodRectangles(new int[][]{{2,3},{3,7},{4,3},{3,7}}));

        int count = 0;
        int poss = Math.min(rectangles[0][0], rectangles[0][1]);

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i][0] = Math.min(rectangles[i][0], rectangles[i][1]);
            if (poss < rectangles[i][0]) {
                poss = rectangles[i][0];
            }
        }

        for (int i = 0; i < rectangles.length; i++) {
            if (poss == rectangles[i][0]) {
                count++;
            }
        }
        return count;
    }

    public static boolean halvesAreAlike(String s) {
//        https://leetcode.com/problems/determine-if-string-halves-are-alike/
//        System.out.println(halvesAreAlike("AbCdEfGh"));

        List<Character> l = new ArrayList<>();
        l.add('a');
        l.add('e');
        l.add('i');
        l.add('o');
        l.add('u');
        l.add('A');
        l.add('E');
        l.add('I');
        l.add('O');
        l.add('U');

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            if (l.indexOf(s.charAt(i)) >= 0) {
                count1++;
            }
            if (l.indexOf(s.charAt((s.length() / 2) + i)) >= 0) {
                count2++;
            }
        }

        return count1 == count2;
    }

    public static int minDeletionSize(String[] strs) {
//        https://leetcode.com/problems/delete-columns-to-make-sorted/
//        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));

        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static String freqAlphabets(String s) {
//        https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
//        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));

        HashMap<String, String> dict = new HashMap<>();
        dict.put("10#", "j");
        dict.put("11#", "k");
        dict.put("12#", "l");
        dict.put("13#", "m");
        dict.put("14#", "n");
        dict.put("15#", "o");
        dict.put("16#", "p");
        dict.put("17#", "q");
        dict.put("18#", "r");
        dict.put("19#", "s");
        dict.put("20#", "t");
        dict.put("21#", "u");
        dict.put("22#", "v");
        dict.put("23#", "w");
        dict.put("24#", "x");
        dict.put("25#", "y");
        dict.put("26#", "z");
        HashMap<String, String> dict2 = new HashMap<>();
        dict2.put("1", "a");
        dict2.put("2", "b");
        dict2.put("3", "c");
        dict2.put("4", "d");
        dict2.put("5", "e");
        dict2.put("6", "f");
        dict2.put("7", "g");
        dict2.put("8", "h");
        dict2.put("9", "i");

        for (String key : dict.keySet()) {
            s = s.replaceAll(key, dict.get(key));
        }
        for (String key : dict2.keySet()) {
            s = s.replaceAll(key, dict2.get(key));
        }
        return s;
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
//        https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
//        System.out.println(busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));

        int count = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static int maxProduct(int[] nums) {
//        https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
//        System.out.println(maxProduct(new int[]{10, 2, 5, 2}));

        int max = (nums[0] - 1) * (nums[1] - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }

        return max;
    }

    public static String destCity(List<List<String>> paths) {
//        https://leetcode.com/problems/destination-city/
//        List<String> d1 = new ArrayList<>();
//        d1.add("London");
//        d1.add("New York");
//        List<String> d2 = new ArrayList<>();
//        d2.add("New York");
//        d2.add("Lima");
//        List<String> d3 = new ArrayList<>();
//        d3.add("Lima");
//        d3.add("Sao Paulo");
//        List<List<String>> d = new ArrayList<>();
//        d.add(d1);
//        d.add(d2);
//        d.add(d3);
//        System.out.println(destCity(d));

        boolean[] b = new boolean[paths.size() + 1];

        HashMap<String, Integer> map = new HashMap<>();

        int iter = 0;
        for (int i = 0; i < paths.size(); i++) {

            if (!map.containsKey(paths.get(i).get(0))) {
                map.put(paths.get(i).get(0), iter++);
            }
            if (!map.containsKey(paths.get(i).get(1))) {
                map.put(paths.get(i).get(1), iter++);
            }
            b[map.get(paths.get(i).get(0))] = true;
        }
        String res = paths.get(0).get(0);

        for (String key : map.keySet()) {
            if (!b[map.get(key)]) {
                res = key;
            }
        }

        return res;
    }

    public static int[] sumZero(int n) {
//        https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//        int[] a = sumZero(4);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        int[] a = new int[n];
        if (n % 2 == 1) {
            a[n - 1] = 0;
            n--;
        }
        for (int i = 0; i < n / 2; i++) {
            a[2 * i] = (i + 1);
            a[2 * i + 1] = -(i + 1);
        }
        return a;
    }

    public static String sortString(String s) {
//        https://leetcode.com/problems/increasing-decreasing-string/
//        System.out.println(sortString("aaaabbbbcccc"));

        int[] a = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        while (sb.length() < s.length()) {
            for (int i = 0; i < a.length; i++) {
                if (a[i]-- > 0) {
                    sb.append((char) ('a' + i));
                }
            }
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i]-- > 0) {
                    sb.append((char) ('a' + i));
                }
            }
        }

        return sb.toString();
    }

    public static String generateTheString(int n) {
//        https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
//        System.out.println(generateTheString(4));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - (1 - n % 2); i++) {
            sb.append('a');
        }
        if (n % 2 == 0) {
            sb.append('b');
        }

        return sb.toString();
    }

    public static int countNegatives(int[][] grid) {
//        https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
//        System.out.println(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int j = grid[0].length - 1;
            while (j >= 0 && 0 > grid[i][j]) {
                j--;
            }
            count += grid[0].length - 1 - j;
        }
        return count;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
//        https://leetcode.com/problems/self-dividing-numbers/
//        List<Integer> l = selfDividingNumbers(1, 22);
//        for (int i = 0; i < l.size(); i++) {
//            System.out.print(l.get(i) + " ");
//        }

        List<Integer> l = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            int j = 0;
            while (j < sb.length() && sb.charAt(j) != '0' && i % (sb.charAt(j) - '0') == 0) {
                j++;
            }
            if (j == sb.length()) {
                l.add(i);
            }
        }
        return l;
    }

    public static int[] finalPrices(int[] prices) {
//        https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
//        int[] a = finalPrices(new int[]{10, 1, 1, 6});
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
            while (j < prices.length) {

                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }

                j++;
            }
        }
        return prices;
    }

    public static int[] sortArrayByParity(int[] A) {
//        https://leetcode.com/problems/sort-array-by-parity/
//        int[] a = sortArrayByParity(new int[]{3, 1, 2, 4});
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                a.add(0, A[i]);
            } else {
                a.add(A[i]);
            }
        }
        for (int i = 0; i < a.size(); i++) {
            A[i] = a.get(i);
        }

        return A;
    }

    public static int[] replaceElements(int[] arr) {
//        https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//        int[] a = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

        int[] a = new int[arr.length];
        a[a.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            a[i] = Math.max(a[i + 1], arr[i + 1]);
        }
        return a;
    }

    public static TreeNode increasingBST(TreeNode root) {
//        https://leetcode.com/problems/increasing-order-search-tree/
        return increasingBST(root, null);
    }

    public static TreeNode increasingBST(TreeNode root, TreeNode res) {
//        https://leetcode.com/problems/increasing-order-search-tree/
        if (root.left != null) {
            res = increasingBST(root.left, res);
        }
        if (res == null) {
            res = new TreeNode(root.val);
        } else {
            res = insert_Recursive(res, root.val);
        }
        if (root.right != null) {
            res = increasingBST(root.right, res);
        }
        return res;
    }

    public static String longestCommonPrefix(String[] strs) {
//        https://leetcode.com/problems/longest-common-prefix/
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));

        String prefix = "";
        boolean b = false;
        int j = 0;
        while (strs.length > 0 && j < strs[0].length()) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || c != strs[i].charAt(j)) {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
            j++;
        }
        if (j > 0) {
//            j = j > strs[0].length() ? strs[0].length() - 1 : j;
            prefix = strs[0].substring(0, j);
        }
        return prefix;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        https://leetcode.com/problems/merge-two-binary-trees/
        if (root1 == null) {
            root1 = root2;
        } else if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        return root1;
    }

    public static TreeNode searchBST(TreeNode root, int val) {
//        https://leetcode.com/problems/search-in-a-binary-search-tree/
        TreeNode res = null;

        if (root.val == val) {
            res = root;
        } else if (root.val > val && root.left != null) {
            res = searchBST(root.left, val);
        } else if (root.val < val && root.right != null) {
            res = searchBST(root.right, val);
        }
        return res;
    }

    public static List<Integer> postorder(Node root) {
//        https://leetcode.com/problems/n-ary-tree-postorder-traversal/
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            for (int i = 0; i < root.children.size(); i++) {
                res.addAll(postorder(root.children.get(i)));
            }

            res.add(root.val);
        }
        return res;
    }

    public static List<Integer> preorder(Node root) {
//        https://leetcode.com/problems/n-ary-tree-preorder-traversal/
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                res.addAll(preorder(root.children.get(i)));
            }
        }
        return res;
    }

    public static int sumRootToLeaf(TreeNode root) {
//        https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
        int res = 0;

        if (root != null) {
            res = sumRootToLeaf(root, new StringBuilder());
        }

        return res;
    }

    public static int sumRootToLeaf(TreeNode root, StringBuilder sb) {
//        https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

        int res = 0;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res = Integer.parseInt(sb.toString(), 2);
        }
        if (root.left != null) {
            res += sumRootToLeaf(root.left, sb);
        }
        if (root.right != null) {
            res += sumRootToLeaf(root.right, sb);
        }
        sb.setLength(sb.length() - 1);
        return res;
    }

    public static int maxDepth(TreeNode root) {
//        https://leetcode.com/problems/maximum-depth-of-binary-tree/
        if (root == null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return left > right ? left : right;
    }

    public static int maxDepth(Node root) {
//        https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

        int depth = 0;

        if (root != null) {
            depth = 1;
            for (Node node : root.children) {
                int dep = 1 + maxDepth(node);
                depth = Math.max(dep, depth);
            }
        }
        return depth;
    }

    public static boolean isUnivalTree(TreeNode root) {
//        https://leetcode.com/problems/univalued-binary-tree/

        boolean res = true;

        if (root.left != null) {
            res = res && root.val == root.left.val;
            if (res) {
                res = isUnivalTree(root.left);
            }
        }
        if (res && root.right != null) {
            res = res && root.val == root.right.val;
            if (res) {
                res = isUnivalTree(root.right);
            }
        }

        return res;
    }

    public static TreeNode invertTree(TreeNode root) {
//        https://leetcode.com/problems/invert-binary-tree/
//        Object[] obj = new Object[]{4, 2, 7, 1, 3, 6, 9};
//        TreeNode t = insertByOrder(0, obj);
//        TreeNode res = invertTree(t);

        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }

        return root;
    }

    static List<Double> avrgLevels = new ArrayList<>();
    static List<Integer> countLevels = new ArrayList<>();

    public static List<Double> averageOfLevels(TreeNode root) {
//        https://leetcode.com/problems/average-of-levels-in-binary-tree/
//        Object[] a = new Object[]{3, 9, 20, null, null, 15, 7};
//        TreeNode t = insertByOrder(0, a);
//        List<Double> list = averageOfLevels(t);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }

        averageOfLevels(root, 0);
        for (int i = 0; i < avrgLevels.size(); i++) {
            avrgLevels.set(i, avrgLevels.get(i) / countLevels.get(i));
        }

        return avrgLevels;
    }

    public static void averageOfLevels(TreeNode root, int level) {
        if (avrgLevels.size() < level + 1) {
            avrgLevels.add(root.val * 1.0);
            countLevels.add(1);
        } else {
            avrgLevels.set(level, avrgLevels.get(level) + root.val);
            countLevels.set(level, countLevels.get(level) + 1);
        }
        if (root.left != null) {
            averageOfLevels(root.left, level + 1);
        }
        if (root.right != null) {
            averageOfLevels(root.right, level + 1);
        }
    }

    static List<Integer> leaves1 = new ArrayList<>();
    static List<Integer> leaves2 = new ArrayList<>();

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        https://leetcode.com/problems/leaf-similar-trees/
//        Object[] a1 = new Object[]{1,2};
//        Object[] a2 = new Object[]{2,2};
//        TreeNode t1 = insertByOrder(0, a1);
//        TreeNode t2 = insertByOrder(0, a2);
//        System.out.println(leafSimilar(t1, t2));

        boolean res = true;
        leafSimilar(root1, 1);
        leafSimilar(root2, 2);

        if (leaves1.size() == leaves2.size()) {
            for (int i = 0; i < leaves1.size(); i++) {
                if (leaves1.get(i) != leaves2.get(i)) {
                    res = false;
                }
            }
        } else {
            res = false;
        }
        return res;
    }

    public static void leafSimilar(TreeNode root, int index) {
        if (root.left == null && root.right == null) {
            if (index == 1) {
                leaves1.add(root.val);
            } else {
                leaves2.add(root.val);
            }
        } else {
            if (root.left != null) {
                leafSimilar(root.left, index);
            }
            if (root.right != null) {
                leafSimilar(root.right, index);
            }
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
//        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

        TreeNode node = new TreeNode(nums[nums.length / 2]);
        for (int i = 0; i < nums.length / 2; i++) {
            insert_Recursive(node, nums[i]);
            if (nums.length / 2 + 1 + i < nums.length) {
                insert_Recursive(node, nums[nums.length / 2 + 1 + i]);
            }
        }
        return node;
    }

    public static String tree2str(TreeNode t) {
//        https://leetcode.com/problems/construct-string-from-binary-tree/
//        Object[] obj = new Object[]{1, 2, 3, null, 4};
//        TreeNode t = insertByOrder(0, obj);
//        System.out.println(tree2str(t));

        StringBuilder sb = new StringBuilder();

        if (t != null) {
            sb.append(Integer.toString(t.val));
            if (t.left != null) {
                sb.append('(');
                sb.append(tree2str(t.left));
                sb.append(')');
            }
            if (t.right != null) {
                if (t.left == null) {
                    sb.append('(');
                    sb.append(')');
                }
                sb.append('(');
                sb.append(tree2str(t.right));
                sb.append(')');
            }
        }
        return sb.toString();
    }

    public static int getMinimumDifference(TreeNode root) {
//        https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//        Object[] obj = new Object[]{1, null, 3, null, null, 2};
//        TreeNode t = insertByOrder(0, obj);
//        System.out.println(getMinimumDifference(t));

        int abs = Integer.MAX_VALUE;

        List<Integer> a = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();

            int i = 0;
            while (a.size() > 0 && i < a.size() && a.get(i) < node.val) {
                i++;
            }
            a.add(i, node.val);

            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }

        for (int i = 0; i < a.size() - 1; i++) {
            int ab = Math.abs(a.get(i + 1) - a.get(i));
            if (ab < abs) {
                abs = ab;
            }
        }

        return abs;
    }

    public static int minDiffInBST(TreeNode root) {
//        https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//        Object[] obj = new Object[]{1, null, 3, null, null, 2};
//        TreeNode t = insertByOrder(0, obj);
//        System.out.println(getMinimumDifference(t));

        int abs = Integer.MAX_VALUE;

        List<Integer> a = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();

            int i = 0;
            while (a.size() > 0 && i < a.size() && a.get(i) < node.val) {
                i++;
            }
            a.add(i, node.val);

            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }

        for (int i = 0; i < a.size() - 1; i++) {
            int ab = Math.abs(a.get(i + 1) - a.get(i));
            if (ab < abs) {
                abs = ab;
            }
        }

        return abs;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
//        https://leetcode.com/problems/same-tree/
//        System.out.println(isSameTree(insertByOrder(0, new Object[]{1, 2, 1}), insertByOrder(0, new Object[]{1, 1, 2})));

        boolean res = true;
        if (!(p == null && q == null)) {
            res = p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return res;
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
//        https://leetcode.com/problems/count-items-matching-a-rule/
//        List<String> line1 = new ArrayList<>();
//        line1.add("phone");
//        line1.add("blue");
//        line1.add("pixel");
//        List<List<String>> lines = new ArrayList<>();
//        lines.add(line1);
//
//        System.out.println(countMatches(lines, "type", "phone"));

        int count = 0;
        int ind = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(ind).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

    public static int getDecimalValue(ListNode head) {
//        https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
//        ListNode node2 = new ListNode(1);
//        ListNode node1 = new ListNode(0, node2);
//        ListNode node0 = new ListNode(1, node1);
//        System.out.println(getDecimalValue(node0));

        int res = 0;
        int pow = 1;

        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.add(head.val);
            head = head.next;
        }
        while (!st.isEmpty()) {
            int val = st.pop();
            res += pow * val;
            pow *= 2;
        }

        return res;
    }

    public static String mergeAlternately(String word1, String word2) {
//        https://leetcode.com/problems/merge-strings-alternately/
//        System.out.println(mergeAlternately("ab", "pqrs"));

        StringBuilder sb = new StringBuilder();
        StringBuilder w1 = new StringBuilder(word1);
        StringBuilder w2 = new StringBuilder(word2);
        while (w1.length() > 0 || w2.length() > 0) {
            if (w1.length() > 0) {
                sb.append(w1.charAt(0));
                w1.deleteCharAt(0);
            }
            if (w2.length() > 0) {
                sb.append(w2.charAt(0));
                w2.deleteCharAt(0);
            }
        }
        return sb.toString();
    }

    public static int repeatedNTimes(int[] A) {
//        https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
//        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                res = A[i];
                break;
            } else {
                map.put(A[i], 0);
            }
        }

        return res;
    }

    public static boolean judgeCircle(String moves) {
//        https://leetcode.com/problems/robot-return-to-origin/
//        System.out.println(judgeCircle("LL"));
        
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                y++;
            } else if (moves.charAt(i) == 'D') {
                y--;
            } else if (moves.charAt(i) == 'R') {
                x++;
            } else if (moves.charAt(i) == 'L') {
                x--;
            }
        }
        return (x == 0 && y == 0);
    }

    public static void main(String[] args) {
    }
}
