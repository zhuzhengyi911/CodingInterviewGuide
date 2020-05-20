package leetcode.dictionarytree.topic208_Trie;

import java.util.HashMap;

/**
 * @program: CodingInterviewGuide
 * @description: TrieNode
 * @author: Zhu Zheng-yi
 * @create: 2020-05-10 16:38
 **/

public class TrieNode {

    private HashMap<Character,TrieNode> links;

    private boolean isEnd;

    public TrieNode(){
        links = new HashMap<>();
    }

    public boolean containsKey(char ch) {
        return links.containsKey(ch);
    }

    public TrieNode get(char ch){
        return links.get(ch);
    }

    public void put(char ch , TrieNode node){
        links.put(ch, node);
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
