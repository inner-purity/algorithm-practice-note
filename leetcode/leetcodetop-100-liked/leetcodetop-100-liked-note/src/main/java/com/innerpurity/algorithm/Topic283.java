package com.innerpurity.algorithm;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc
 * date 2025/4/20
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic283 {
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//示例 1:
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//示例 2:
//
//输入: nums = [0]
//输出: [0]
//
//
//提示:
//
//1 <= nums.length <= 104
//-231 <= nums[i] <= 231 - 1
//
//
//进阶：你能尽量减少完成的操作次数吗？
    public static void main(String[] args) {
//        int[] nums = { 0, 100, 0, 4, 0, 200, 0, 1, 3, 2, 0, 0 };
        int[] nums = { 1, 0, 1 };
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        // 设置两个指针，basePoint指向0，checkPoint指向非0元素。初始时两个指针都在数组开头
        int basePoint = 0;
        int checkPoint = 0;
        System.out.println(Arrays.toString(nums));
        while (checkPoint < nums.length) {
            if (nums[checkPoint] != 0) {
                // 如果当前元素非0，且basePoint指向的元素为0，则将当前元素与basePoint交换位置。
                // 随后更新basePoint到当前checkPoint。
                basePoint = swap(nums, basePoint, checkPoint);
                System.out.println(Arrays.toString(nums));
            }
            // checkPoint指向下一个元素
            checkPoint++;
        }
    }

    private static int swap(int[] nums, int basePoint, int checkPoint) {
        // 交换两个位置上的元素
        int temp = nums[checkPoint];
        nums[checkPoint] = nums[basePoint];
        nums[basePoint] = temp;
        // 更新basePoint的位置到当前checkPoint。
        basePoint++;
        return basePoint;
    }
}
