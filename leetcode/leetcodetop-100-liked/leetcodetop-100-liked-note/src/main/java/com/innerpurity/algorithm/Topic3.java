package com.innerpurity.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * desc
 * date 2025/5/4
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic3 {
    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    //
    //提示：
    //
    //0 <= s.length <= 5 * 104
    //s 由英文字母、数字、符号和空格组成

    public static void main(String[] args) {
        String test = "abcabcbb";
        int i = lengthOfLongestSubstring(test);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        int r = 0;
        for(; r < charArray.length; r++){
            if(map.containsKey(String.valueOf(charArray[r]))){
                l = Math.max(l, map.get(String.valueOf(charArray[r])) + 1);
            }
            map.put(String.valueOf(charArray[r]), r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
