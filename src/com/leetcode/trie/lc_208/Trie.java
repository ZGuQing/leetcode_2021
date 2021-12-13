package com.leetcode.trie.lc_208;

import org.junit.Test;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/7 9:33 下午
 * @Version 1.0
 */
public class Trie {
    private Trie[] son;
    private boolean isEnd;

    public Trie() {
        son = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.son[index] == null) {
                node.son[index] = new Trie();
            }
            node = node.son[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.son[index] == null) {
                return null;
            }
            node = node.son[index];
        }
        return node;
    }

    @Test
    public void test() {
        String word = "apple";
        String word1 = "apale";
        insert(word);
        insert(word1);
        boolean search = search(word);
    }
}
