package com.innerpurity.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * desc
 * date 2025/4/20
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic15 {
// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
// 请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//示例 1：
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//示例 2：
//
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//示例 3：
//
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
//
//提示：
//
//3 <= nums.length <= 3000
//-105 <= nums[i] <= 105
    public static void main(String[] args) {
        int[] nums = { -1,0,1,2,-1,-4 };
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            // 如果当前元素大于0
            //或下一位元素与当前元素重复，则跳过。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                // 如果左右两数满足条件，封装成三元组返回
                if(nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 更新双指针位置，方便下一轮查找。左右两个指针都越过重复元素，直到判断下一个元素不重复为止。
                    // 注意，判断到最后时，不进行移动，只是说判断下一个不是重复元素就停止移动了，最后统一移动左右指针。
                    // 这样就保证了三元组不重复。
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                    // 大了就让右数小点
                }else if(nums[left] + nums[right] > target){
                    right--;
                    // 小了就让左数大点
                }else{
                    left++;
                }
            }

        }
        return result;
    }

//            for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                return null;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum > 0) {
//                    right--;
//                } else if (sum < 0) {
//                    left++;
//                } else {
//                    while (left < right && nums[left] == nums[left + 1]) {
//                        left++;
//                    }
//                    while (left < right && nums[right] == nums[right - 1]) {
//                        right--;
//                    }
//                    left++;
//                    right--;
//                }
//            }
//        }
}
