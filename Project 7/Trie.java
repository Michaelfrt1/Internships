/**
 * This class is meant to represent a data structure that will be used throughout the project.
 * Useful for searching for specific key sets.
 * Uses the created TrieNode class.
*/
public class Trie<T> {

    private TrieNode<T> root;

    /** constructor that initializes the root to a new node from the TrieNode Class.*/
    public Trie() {
        root = new TrieNode();
    }

    /**
     * private function that takes a string and returns the appropriate trieNode
     * @param s, String
     */
    private TrieNode<T> getNode(String s) {
        TrieNode<T> node = root;
        for (int i = 0; i < s.length(); i++) {
            node = node.getChild(s.charAt(i));
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    /**
     * public function that gets the data currently stored on the TrieNode associated with the input string
     * @param s, String
     * @return node.getData(), which is the data at the accosted node, type T
     */
    public T get(String s) {
        TrieNode<T> node = getNode(s);
        if (node == null) {
            return null;
        }
        return node.getData();
    }

    /**
     * add data for type variable that is associated with string input
     * @param input, String
     * @param data, T
     * @return the new data put into the Trie, type T
     */
    public T put(String input, T data)
    {
        TrieNode<T> assc_node = getNode(input);
        assc_node.setData(data);
        return assc_node.getData();
    }

}
