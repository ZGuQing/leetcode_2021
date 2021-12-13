package com.leetcode.december;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/9/9 7:21 下午
 * @Version 1.0
 */
public class lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_len = words.length;
        int all_len = one_word * word_len;
        int s_len = s.length();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s_len) {
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if(count == word_len) res.add(left);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"bar", "foo"};
        List<Integer> substring = findSubstring(s, words);
        for(Integer i : substring) {
            System.out.println(i);
        }
    }

}
