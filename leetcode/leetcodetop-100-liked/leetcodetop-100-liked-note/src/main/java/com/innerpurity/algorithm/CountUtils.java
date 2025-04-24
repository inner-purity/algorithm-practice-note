package com.innerpurity.algorithm;

/**
 * desc
 * date 2025/4/23
 *
 * @author inner-purity(Jiayi Liu)
 */
public class CountUtils {
    public static void main(String[] args) {
        String testText = "";
        int count = countChineseCharacters(testText);
        System.out.println("中文字符的个数是: " + count);
    }

    public static int countChineseCharacters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS.equals(Character.UnicodeBlock.of(c))) {
                count++;
            }
        }
        return count;
    }
}
