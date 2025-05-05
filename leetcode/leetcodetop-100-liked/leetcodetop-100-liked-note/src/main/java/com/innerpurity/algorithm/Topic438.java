package com.innerpurity.algorithm;

import java.util.*;

/**
 * desc
 * date 2025/5/4
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic438 {
    //  找到字符串中所有字母异位词
    // 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    //
    //示例 1:
    //
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    //解释:
    //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    // 示例 2:
    //
    //输入: s = "abab", p = "ab"
    //输出: [0,1,2]
    //解释:
    //起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    //起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    //起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
    //
    //
    //提示:
    //
    //1 <= s.length, p.length <= 3 * 104
    //s 和 p 仅包含小写字母

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> ints = findAnagrams(s, p);
        System.out.println(ints);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // 解题思路：
        // 字符串异位词的特征：
        // 1. 字符串长度相同
        // 2. 字符串中每个字符出现的次数相同
        // 所以我们只需要统计模板字符串中每个单词的个数，再用和模板字符串等长的滑动窗口去统计，然后比较每个单词的数量即可。
        // 特殊情况：
        // 当模板字符串长度大于字符串长度时，返回空数组。
        // 代码实现：
        // 统计s、p字符串的长度
        int sLen = s.length();
        int pLen = p.length();
        // 初始化维护26个英文字母出现次数的数组
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 特殊情况
        if(sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        // 录入模板字符串的每个字符出现的次数。顺便初始化滑动窗口。
        for(int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        // Arrays.equals比较两个数组内元素依次是否相同，底层采用从前到后扫描比较。
        // 此步骤的目的是判断从0索引开始的子串是否满足条件，只判断此一次。
        // （顺便的事，检查当前滑动窗口是否满足条件，不然之后放到循环中处理还麻烦）
        if(Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        for(int i = 0; i < sLen - pLen; i++) {
            // 移动滑动窗口(移除窗口前端的元素，新增窗口后端的元素)
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            // 比较滑动窗口内单词出现个数
            if(Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
