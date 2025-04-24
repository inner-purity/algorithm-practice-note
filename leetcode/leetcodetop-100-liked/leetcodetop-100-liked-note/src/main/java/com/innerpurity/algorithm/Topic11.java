package com.innerpurity.algorithm;

import java.util.Arrays;

/**
 * desc
 * date 2025/4/20
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic11 {
// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//图片请参考 https://leetcode.cn/problems/container-with-most-water?envType=study-plan-v2&envId=top-100-liked
//说明：你不能倾斜容器。
//
//示例 1：
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//示例 2：
//
//输入：height = [1,1]
//输出：1
//
//提示：
//
//n == height.length
//2 <= n <= 105
//0 <= height[i] <= 104
    public static void main(String[] args) {
        int[] height = { 1,8,6,2,5,4,8,3,7 };
        int area = maxArea(height);
        System.out.println(area);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            // 找出谁是当前的短板
            int minHeight = Math.min(height[left], height[right]);
            // 求出当前的面积(面积受限于短板)
            int area = (right - left) * minHeight;
            // 尝试更新最大面积
            maxArea = Math.max(maxArea, area);
            // 让短板的一方移动，试图寻找更大的面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
