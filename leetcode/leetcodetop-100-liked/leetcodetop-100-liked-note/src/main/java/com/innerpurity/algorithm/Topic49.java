package com.innerpurity.algorithm;

import java.util.*;

/**
 * desc
 * date 2025/4/20
 *
 * @author inner-purity(Jiayi Liu)
 */
public class Topic49 {
//     题目: 49. 字母异位词分组
//     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//    示例 1:
//
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    示例 2:
//
//    输入: strs = [""]
//    输出: [[""]]
//    示例 3:
//
//    输入: strs = ["a"]
//    输出: [["a"]]
//
//    提示：
//
//    1 <= strs.length <= 104
//    0 <= strs[i].length <= 100
//    strs[i] 仅包含小写字母
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams1(strs);
        List<List<String>> lists = groupAnagrams2(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    // 方案1 通过元素Ascii码值入手，如果ASCII码值一样，则判断为同一组（部分通过，有逻辑问题）
    public static List<List<String>> groupAnagrams1(String[] strs) {

        // 建立 字符串 <ASCII码值, 同ASCII码值的字符串列表> 哈希表
        Map<Integer, List<String>> strsMap = new HashMap<>();
        // 遍历收集字符串信息
        for (String s : strs) {
            // 获取对应字符串的总ASCII码值
            int strSum = s.chars().sum();
            List<String> origin = new ArrayList<>();
            // 值相同的，归为一组
            if (strsMap.containsKey(strSum)) {
                origin = strsMap.get(strSum);
            }
            // 新的值则新加入
            origin.add(s);
            strsMap.put(strSum, origin);
        }
        return new ArrayList<>(strsMap.values());
    }
    //输入
    //strs = ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
    //输出
    //[["buy"],["duh","ill"],["bar"],["cab"],["max"],["doc"],["may"],["tin"],["pew"]]
    //预期结果
    //[["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]]
    //错误原因分析：
    // 没有考虑到如果1+3 = 4； 2+2 也 = 4 的情况；

    // 方案2 既然是字母异位词，那么每个单词按ASCII码排序后肯定是相同的，
    // 现在关键问题就是：
    // 1. 解决如何对原字符串排序
    // 2. 按照排序后的字符串进行分组
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> strsMap = new HashMap<>();
        for (String s : strs) {
            // 先遍历原字符串数组，然后对每个字符串进行排序，排序后的字符串作为key，原字符串作为value，加入到每个哈希索引下挂载的链表中
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            strsMap.put(String.valueOf(chars), strsMap.getOrDefault(String.valueOf(chars), new ArrayList<>()));
            strsMap.get(String.valueOf(chars)).add(s);
        }
        return new ArrayList<>(strsMap.values());
    }

}
