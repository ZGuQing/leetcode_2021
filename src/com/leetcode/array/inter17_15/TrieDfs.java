package com.leetcode.array.inter17_15;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 4:22 下午
 * @Version 1.0
 */
public class TrieDfs {

    //树结点
    class TreeNode{
        private boolean isWord;
        private TreeNode[]son;
        TreeNode(){
            this.isWord = false;
            this.son = new TreeNode[26];
        }
    }
    //字典树类
    class Tree{
        private TreeNode root;
        Tree(){
            this.root = new TreeNode();
        }
        public void insert(String word){
            TreeNode curr = root;
            for(int i=0;i<word.length();i++){
                int node = word.charAt(i)-'a';
                if(curr.son[node]==null)    curr.son[node] = new TreeNode();
                curr = curr.son[node];
            }
            curr.isWord = true;//标记尾结点
        }
        public TreeNode getRoot(){
            return root;
        }
    }
    private Tree tree;
    boolean flag=false;//出现过别的单词
    boolean finish = false; //是否完成搜索
    public String longestWord(String[] words) {
        this.tree = new Tree();
        Arrays.sort(words,(o1,o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(),o1.length());
            }
        });
        //构造字典树
        for(String x:words){
            tree.insert(x);
        }
        for(int i=0;i<words.length;i++)
        {
            flag=false;//对每个单词进行搜索
            if(words[i].length()==0) continue;
            dfs(0,words[i],tree.getRoot());//传入当前字符索引，需要开始搜索的结点
            if(finish) return words[i];
        }
        return "";
    }
    private void dfs(int index,String word,TreeNode r){
        if(index>=word.length())    return ;
        int i = word.charAt(index)-'a';
        r= r.son[i];
        if(r==null) return;
        if(index==word.length()-1){
            if(flag&&r.isWord)  finish = true;  //如果字符是单词并且前一部分由单词构成
        }
        if(r.isWord&&!flag)//当前结点是单词，但是之前不是单词构成的
        {
            flag=true;
            dfs(index+1,word,tree.getRoot());//从下一个字符开始，从头结点开始搜索是否可有新的单词构成
            if(finish) return;
            flag=false;
        }
        else if(r.isWord&&flag)//当前是单词并且已经有单词构成
        {
            dfs(index+1,word,tree.getRoot());
            if(finish) return;
        }
        dfs(index+1,word,r);//一般情况
        if(finish) return;
    }

    @Test
    public void test() {
        String[] s = new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
        longestWord(s);
    }
}
