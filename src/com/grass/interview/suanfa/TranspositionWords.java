package com.grass.interview.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 换位词
 */
public class TranspositionWords {
    public void test() {
        String[] array = new String[]{"tea", "and", "ate", "eat", "den"};
        String[] newArray = sort(array);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (int index = 0; index < newArray.length; index++) {
            String item = newArray[index];
            boolean containsKey = map.containsKey(item);
            if (containsKey) {
                map.get(item).add(array[index]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(array[index]);
                map.put(item, list);
            }
        }
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        TranspositionWords test = new TranspositionWords();
//        String ate = test.sortString("ate");
//        System.out.println(ate);
        test.test();

    }

    private String[] sort(String[] array) {
        String[] newArray = new String[array.length];
        for (int index = 0; index < array.length; index++) {
            String newStr = sortString(array[index]);
            newArray[index] = newStr;
        }
        return newArray;
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            for (int j = 0; j < chars.length - index - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    swapvalue(chars, j, j + 1);
                }
            }
        }
        return new String(chars);
    }

    private void swapvalue(char[] chars, int j, int i) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }
}
