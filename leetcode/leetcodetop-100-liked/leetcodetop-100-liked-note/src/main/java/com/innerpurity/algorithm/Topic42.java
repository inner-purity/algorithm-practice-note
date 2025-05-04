package com.innerpurity.algorithm;

/**
 * desc
 * date 2025/5/4
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic42 {
    //  42. 接雨水
    // 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //
    //示例 1：
    //
    //
    //
    //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出：6
    //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    //示例 2：
    //
    //输入：height = [4,2,0,3,2,5]
    //输出：9
    //
    //
    //提示：
    //
    //n == height.length
    //1 <= n <= 2 * 104
    //0 <= height[i] <= 105

    public static void main(String[] args) {
        int[] height = { 4, 9, 4, 5, 3, 2 };
        System.out.println("水滴面积为：" + trap(height));
    }

    public static int trap(int[] height) {
        int baseHeight = 1;
        int left = 0;
        int right = height.length - 1;
        // 柱形容器自身面积
        int volumeArea = 0;
        // 总面积
        int totalArea = 0;
        // 水滴面积
        int waterArea;
        // 记录最高柱形高度
        int maxHeight = 0;
        // 计算柱形容器自身总面积
        for (int h : height) {
            volumeArea += h;
            maxHeight = Math.max(maxHeight, h);
        }
        while (left <= right && baseHeight <= maxHeight) {
            while(left < right && height[left] < baseHeight) {
                left++;
            }
            while(left < right && height[right] < baseHeight) {
                right--;
            }
            if(left <= right && height[left] >= baseHeight && height[right] >= baseHeight) {
                totalArea += right - left + 1;
                System.out.println("第" + baseHeight + "层宽度：" + (right - left + 1));
                baseHeight++;
            }
        }
        // 处理边界情况（防止面积负值）
        waterArea = Math.max(totalArea - volumeArea, 0);
        return waterArea;
    }
}
