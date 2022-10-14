package a05_01_abb;

public class BinarySearchTree {

	public enum Side {
		LEFT, RIGHT;
	}

	private BSTNode root;

	public void add(Comparable info) {
		BSTNode newNode = new BSTNode(info);
		if (root == null) {
			root = newNode;
		} else {
			BSTNode node = root;
			while (node != null) {
				int comp = info.compareTo(node.getInfo());
				if (comp > 0) {
					if (node.getRight() == null) {
						node.setRight(newNode);
						newNode.setParent(node);
						break;
					} else {
						node = node.getRight();
					}
				} else if (comp < 0) {
					if (node.getLeft() == null) {
						node.setLeft(newNode);
						newNode.setParent(node);
						break;
					} else {
						node = node.getLeft();
					}
				}
			}
		}
	}

	public BSTNode search(Comparable info) {
		BSTNode node = root;
		while (node != null && !node.getInfo().equals(info)) {
			int comp = info.compareTo(node.getInfo());
			if (comp > 0) {
				node = node.getRight();
			} else if (comp < 0) {
				node = node.getLeft();
			}
		}
		return node;
	}

	public BSTNode min() {
		return minBelow(root);
	}

	private BSTNode minBelow(BSTNode node) {
		if (node != null) {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	public BSTNode max() {
		return maxBelow(root);
	}

	private BSTNode maxBelow(BSTNode node) {
		if (node != null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
	}
	
	public BSTNode next(BSTNode node) {
		BSTNode result = null;
		if (node.getRight() != null) {
			result = minBelow(node.getRight());
		} else {
			BSTNode parent = node.getParent();
			while (parent.getInfo().compareTo(node.getInfo()) < 0) {
				parent = parent.getParent();
			}
			result = parent;
		}
		return result;
	}
	
	public void remove(Comparable info) {
		BSTNode node = search(info);
		if (isLeaf(node)) {
			// N�o tem nenhum filho
			// Remove do pai este n�
			if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
			// Desliga o pai do n�
			node.setParent(null);
		} else {
			if (node.getLeft() != null && node.getRight() != null) {
				// Tem os dois filhos
				
			} else {
				// Tem apenas um filho
				BSTNode nodeToMove = null;
				if (node.getLeft() != null) {
					nodeToMove = node.getLeft(); 
				} else {
					nodeToMove = node.getRight(); 
				}
				nodeToMove.setParent(node.getParent());
				if (node.getParent().getLeft() == node) {
					node.getParent().setLeft(nodeToMove);
				} else {
					node.getParent().setRight(nodeToMove);
				}
				// Desliga o pai do n�
				node.setParent(null);
			}
		}
	}

	private Side getSideOfParent(BSTNode node) {
		if (node.getParent().getLeft() == node) {
			return Side.LEFT;
		} else {
			return Side.RIGHT;
		}
	}
	
	public boolean isLeaf(BSTNode node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
//		buildStringInOder(root, sb);
		buildStringPreOrder(root, sb, 1);
		return sb.toString();
	}

	private void buildStringInOder(BSTNode node, StringBuilder sb) {
		if (node != null) {
			if (node.getLeft() != null) {
				buildStringInOder(node.getLeft(), sb);
			}

			sb.append(" ");
			sb.append(node.getInfo());
			sb.append(" ");

			if (node.getRight() != null) {
				buildStringInOder(node.getRight(), sb);
			}
		}
	}

	private void buildStringPreOrder(BSTNode node, StringBuilder sb, int level) {
		sb.append("\n");
		for (int i = 0; i < level; ++i) {
			sb.append("  ");
		}
		sb.append(node.getInfo());
		if (node.getLeft() != null) {
			buildStringPreOrder(node.getLeft(), sb, level + 1);
		}
		if (node.getRight() != null) {
			buildStringPreOrder(node.getRight(), sb, level + 1);
		}
	}

}
