package com.leetcode.trie.lc_677;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/7 10:19 下午
 * @Version 1.0
 */
public class MapSum {
    class TrieNode {
        private TrieNode[] son = new TrieNode[26];
        private int val;
    }
    private TrieNode root;
    private Map<String, Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int index = ch - 'a';
            if (node.son[index] == null) {
                node.son[index] = new TrieNode();
            }
            node.son[index].val += delta;
            node = node.son[index];
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.son[index] == null) {
                return 0;
            }
            node = node.son[index];
        }
        return node.val;
    }

    @Test
    public void test() {
        String word = "apple";
        String word1 = "app";
        insert(word, 3);
        insert(word1, 2);
        int ap = sum("ap");
    }
}
