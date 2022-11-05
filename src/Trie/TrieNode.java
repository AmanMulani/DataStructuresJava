package Trie;

public class TrieNode {

    public String word;
    public int[] nextAlphabets;

    public TrieNode() {
        this.word = null;
        nextAlphabets = new int[26];
    }
}
