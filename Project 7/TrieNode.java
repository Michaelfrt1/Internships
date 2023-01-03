/**
 * @param <T>
 * Trie TrieNode class creates Nodes for the Trie class to use.
 */
public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] children;

    /**
     * Constructor
     * initialize data to null
     * initialize the children to an array with 26 spaces (all null).
     */
    public TrieNode() {
        data = null;
        children = new TrieNode[26];
    }

    /**
     * A public T getData() method that gets the data.
     * @return data T
     */
    public T getData() {
        return data;
    }

    /**
     * A public void setData(T data) method that sets the data.
      */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * A public TrieNode<T> getChild(char letter) method which returns the TrieNode<T> associated with the given letter.
     * @param letter char
     * @return children[i], which is the letter that is desired from the Trie, type TrieNode<T>
     */
    public TrieNode<T> getChild(char letter) {
        if (letter < 'a' || letter > 'z') {
            return null;
        }
        int i = letter - 'a';
        if (children[i] == null) {
            children[i] = new TrieNode<>();
        }
        return children[i];
    }
}



