package a04_02_abb;

public class BinarySearchTree {

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
		BSTNode node = root;
		if (node != null) {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	public BSTNode max() {
		BSTNode node = root;
		if (node != null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
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
