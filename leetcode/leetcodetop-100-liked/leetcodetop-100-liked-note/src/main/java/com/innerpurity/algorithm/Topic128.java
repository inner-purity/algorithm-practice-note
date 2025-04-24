package com.innerpurity.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * desc
 * date 2025/4/20
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic128 {
// 题目: 128. 最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//示例 1：
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//示例 3：
//
//输入：nums = [1,0,1,2]
//输出：3
//
//提示：
//
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
