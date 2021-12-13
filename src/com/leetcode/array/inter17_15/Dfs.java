package com.leetcode.array.inter17_15;

import com.sun.jndi.ldap.sasl.LdapSasl;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 7:34 下午
 * @Version 1.0
 */
public class Dfs {
    public String longestWord(String[] words) {
        //从长到短排序
        Arrays.sort(words,(o1, o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(),o1.length());
            }
        });
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) { //挨个判断该word是否由其他word构成！！！找到一个直接返回！
            set.remove(word);
            if (find(set, word)) {
                return word;
            }
        }
        return "";
    }

    private boolean find(HashSet<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && find(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
