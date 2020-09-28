package com.grass.interview.suanfa;

/**
 * Created by grassswwang
 * on 2020/9/28
 * Email: grassswwang@tencent.com
 */
public class CountSegments {
    public static void main(String[] args) {
        String str = "Hello, my name is John";
        int count = countSegments(str);
        System.out.println(count);
    }

    public static int countSegments(String s) {
        int count = 0;
        //是否为空格
        boolean isBlank = true;
        for (int i = 0; i < s.length(); i++) {
            //当前字符为空格
            if (s.charAt(i) == ' ') {
                isBlank = true;
            } else {//当前字符不为空格
                if (isBlank) {//前一个字符为空格
                    count++;//单词数+1
                }
                isBlank = false;
            }
        }
        return count;
    }
}
