package com.grass.interview.collection;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by grassswwang
 * on 2020/9/28
 * Email: grassswwang@tencent.com
 * 读取一篇英文文章，输出其中出现单词的次数最多的单词
 */
public class HelloTreemap {
    public static void main(String[] args) {
        String str = "ggggiuiiipppppaaaaahhhhddddd";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            boolean containsKey = map.containsKey(c);
            if (containsKey) {
                Integer integer = map.get(c);
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        System.out.println(list);

        test2();
    }

    public static void test2() {
        String str = "gggg gggg gggg iu ii ipp pppa aaaa hhhh    dd  ddd";
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);
        Map<String, Integer> map = new HashMap<>();
        String word = "";
        int count;
        while (matcher.find()) {
            word = matcher.group();
            if (map.containsKey(word)) {
                count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        System.out.println(list);
    }


}
