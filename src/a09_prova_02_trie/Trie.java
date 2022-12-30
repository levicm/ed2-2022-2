package a09_prova_02_trie;

public class Trie {

	private TrieNode root;
	private int size;

	public Trie() {
		root = new TrieNode();
	}
	
	public int getSize() {
		return size;
	}

	public TrieNode put(String key, Object value) {
		return put(root, key, value, 0);
	}

	private TrieNode put(TrieNode node, String key, Object value, int position) {
		if (position == key.length()) {
			if (node.getValue() == null) {
				size++;
			}
			node.setValue(value);
			return node;
		} else {
			char c = key.charAt(position);
			TrieNode nextNode = node.getNext(c);
			if (nextNode == null) {
				nextNode = new TrieNode();
				node.setNext(c, nextNode);
			}
			return put(nextNode, key, value, position + 1);
		}
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	public Object get(String key) {
		TrieNode node = get(root, key, 0);
		if (node != null) {
			return node.getValue();
		} else {
			return null;
		}
	}
	
	private TrieNode get(TrieNode node, String key, int position) {
		if (position == key.length()) {
			return node;
		} else {
			char c = key.charAt(position);
			TrieNode nextNode = node.getNext(c);
			if (nextNode == null) {
				return null;
			}
			return get(nextNode, key, position + 1);
		}
	}
	
	public void remove(String key) {
		remove(root, key, 0);
	}

	private boolean remove(TrieNode node, String key, int position) {
		if (position == key.length()) {
			node.setValue(null);
			size--;
			return true;
		} else {
			char c = key.charAt(position);
			TrieNode nextNode = node.getNext(c);
			if (nextNode == null) {
				return false;
			}
			boolean result = remove(nextNode, key, position + 1);
			if (result) {
				if (nextNode.getSize() == 0 && nextNode.getValue() == null) {
					node.removeNext(c);
				} else {
					result = false;
				}
			}
			return result;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(root)");
		buildString(root, sb, 1);
		return sb.toString();
	}

	private void buildString(TrieNode node, StringBuilder sb, int level) {
		if (node.getValue() != null) {
			sb.append(node);
		}
		for (int i = 0; i < TrieNode.LETTERS; ++i) {
			TrieNode next = node.getNext((char) i);
			if (next != null) {
				sb.append("\n");
				for (int j = 0; j < level; ++j) {
					sb.append("  ");
				}
				sb.append("(");
				sb.append((char) i);
				sb.append(")");
				buildString(next, sb, level + 1);
			}
		}
	}
}















