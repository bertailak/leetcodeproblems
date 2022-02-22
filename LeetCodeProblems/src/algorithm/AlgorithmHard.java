/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author berta
 */
public class AlgorithmHard {

    public static HashMap<Integer, Integer> dividers(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        if (num == 1) {
            return map;
        }

        int div = 2;

        while (num > 1) {
            if (num % div == 0) {
                map.put(div, map.getOrDefault(div, 0) + 1);
                num /= div;
                div = 2;
            } else {
                div++;
            }
        }

        return map;
    }

    public static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (min == 0) {
            return max;
        }

        return gcd(min, max % min);
    }

    public static long countPairs(int[] nums, int k) {
//        https://leetcode.com/problems/count-array-pairs-divisible-by-k/

        long sum = 0;
        Map<Integer, Integer> gcds = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcd = gcd(nums[i], k);
            for (int num : gcds.keySet()) {
                if ((long) gcd * num % k == 0) {
                    sum += gcds.get(num);
                }
            }
            gcds.put(gcd, gcds.getOrDefault(gcd, 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
    }

}
