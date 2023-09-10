class Trie {

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode root = new TrieNode();

    private TrieNode find(String prefix) {
        TrieNode node = root;
        for (final char c : prefix.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                return null;
            node = node.children[i];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

};

// O(len(longest string) * queries)
