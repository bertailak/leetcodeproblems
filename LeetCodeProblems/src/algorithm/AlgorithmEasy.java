package algorithm;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s_bertailak
 */
public class AlgorithmEasy {

    public static int[] runningSum(int[] nums) {
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
        //        System.out.println(defangIPaddr("1.1.1.1"));

        return address.replace(".", "[.]");
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
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
//        System.out.println(interpret("G()(al)"));
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static int[] decode(int[] encoded, int first) {
//        decode(new int[]{1, 2, 3}, 1);

        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    public static String restoreString(String s, int[] indices) {
//        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));

        char[] c = new char[indices.length];
        for (int i = 0; i < c.length; i++) {
            c[indices[i]] = s.charAt(i);
        }
        return new String(c);
    }

    public static int numberOfSteps(int num) {
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
//        System.out.println(xorOperation(10, 5));

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }

    public static int balancedStringSplit(String s) {
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
//        System.out.println(arrayStringsAreEqual(new String[]{"ac", "c"}, new String[]{"a", "bc"}));

        if (String.join("", word1).equals(String.join("", word2))) {
            return true;
        }
        return false;
    }

    public static int maxDepth(String s) {
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

        void print(TreeNode node) {
            System.out.print(node.val + " ");
            if (node.left != null) {
                print(node.left);
            }
            if (node.right != null) {
                print(node.right);
            }
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

    public static TreeNode insert_Recursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val) {
            root.left = insert_Recursive(root.left, key);
        } else if (key > root.val) {
            root.right = insert_Recursive(root.right, key);
        }
        return root;
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
//        int[] n = new int[]{10, 5, 15, 3, 7, 13, 18, 1, 6};
//        TreeNode node = new TreeNode(n[0]);
//        for (int i = 1; i < n.length; i++) {
//            node.insert_Recursive(node, n[i]);
//        }
//        System.out.println(rangeSumBST(node, 6, 10));

        if (root == null) {
            return 0;
        } else {
            int sum = (root.val >= low && root.val <= high ? root.val : 0);
            sum = sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            return sum;
        }
    }

    public static int numberOfMatches(int n) {
//        System.out.println(numberOfMatches(7));

        return --n;
    }

    static class OrderedStream {
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
        return increasingBST(root, null);
    }

    public static TreeNode increasingBST(TreeNode root, TreeNode res) {
//        int[] n = new int[]{5, 1, 7};
//        TreeNode node = new TreeNode(n[0]);
//        for (int i = 1; i < n.length; i++) {
//             node = insert_Recursive(node, n[i]);
//        }
//        TreeNode t = increasingBST(node);
//        t.print(t);
//        System.out.println();

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

    public static void main(String[] args) {
    }
}
