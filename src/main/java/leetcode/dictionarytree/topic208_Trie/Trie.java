package leetcode.dictionarytree.topic208_Trie;

/**
 * @program: CodingInterviewGuide
 * @description: 208. 实现 Trie (前缀树)
 * @author: Zhu Zheng-yi
 * @create: 2020-05-10 16:35
 **/

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 时间复杂度: O(m) , m为键长
     * 空间复杂度: O(m)
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0){
            return;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();

    }

    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) {
            return true;
        }

        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }


    public static void main(String[] args) {

        Trie trie = new Trie();

//        String[] in = new String[]{
//                "Trie", "insert", "search", "search", "startsWith", "insert", "search"
//        };
//
//        for (String s : in){
//            trie.insert(s);
//        }

        trie.insert(null);
        trie.insert("apple");


        System.out.println(trie.search("apple"));



    }

}
