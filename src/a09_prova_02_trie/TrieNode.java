package a09_prova_02_trie;

public class TrieNode {
	public static final int LETTERS = 256;
	private Object value;
	private TrieNode[] next = new TrieNode[LETTERS];
	private int size = 0;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public int getSize() {
		return size;
	}

	public TrieNode getNext(char letter) {
		return this.next[letter];
	}

	public void setNext(char letter, TrieNode node) {
		this.next[letter] = node;
		size++;
	}
	
	public void removeNext(char letter) {
		this.next[letter] = null;
		size--;
	}
	
	@Override
	public String toString() {
		return "[" + value + "]";
	}
}
