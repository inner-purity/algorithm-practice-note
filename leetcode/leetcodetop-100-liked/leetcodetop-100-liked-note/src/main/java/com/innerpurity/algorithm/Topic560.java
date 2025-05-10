package com.innerpurity.algorithm;

/**
 * desc
 * date 2025/5/5
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic560 {
    // 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    //
    //子数组是数组中元素的连续非空序列。
    //
    //示例 1：
    //
    //输入：nums = [1,1,1], k = 2
    //输出：2
    //示例 2：
    //
    //输入：nums = [1,2,3], k = 3
    //输出：2
    //
    //提示：
    //
    //1 <= nums.length <= 2 * 104
    //-1000 <= nums[i] <= 1000
    //-107 <= k <= 107
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySum1(nums, k));
    }

    // 暴力解法
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 哈希表 + 前缀和
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
