package a10_avl;

public class AVLTree {

	private AVLNode root;

	private int size;

	public int getSize() {
		return size;
	}

	public void add(Comparable info) {
		root = add(info, root);
	}

	public AVLNode add(Comparable info, AVLNode parent) {
		if (parent == null) {
			parent = new AVLNode(info);
			;
		} else {
			int comp = info.compareTo(parent.getInfo());
			if (comp > 0) {
				parent.setRight(add(info, parent.getRight()));
			} else if (comp < 0) {
				parent.setLeft(add(info, parent.getLeft()));
			}
		}
		parent = balance(parent);
		return parent;
	}

	private AVLNode balance(AVLNode node) {
		if (node.getFactor() == 2) {
			System.out.println("desbalanceou pra direita");
			if (node.getRight().getFactor() > 0)
				node = doLeftRotation(node);
			else
				node = doDoubleLeftRotation(node);
		} else if (node.getFactor() == -2) {
			System.out.println("desbalanceou pra esquerda");
			if (node.getLeft().getFactor() < 0)
				node = doRightRotation(node);
			else
				node = doDoubleRightRotation(node);
		}
		node.updateHeight();
		return node;
	}

	private AVLNode doRightRotation(AVLNode node) {
		System.out.println("rotacionando pra direita");
		AVLNode result = node.getLeft();
		node.setLeft(result.getRight());
		result.setRight(node);
		node.updateHeight();
		result.updateHeight();
		return result;
	}

	private AVLNode doLeftRotation(AVLNode node) {
		System.out.println("rotacionando pra esquerda");
		AVLNode result = node.getRight();
		node.setRight(result.getLeft());
		result.setLeft(node);
		node.updateHeight();
		result.updateHeight();
		return result;
	}

	private AVLNode doDoubleRightRotation(AVLNode node) {
		node.setLeft(doLeftRotation(node.getLeft()));
		return doRightRotation(node);
	}

	private AVLNode doDoubleLeftRotation(AVLNode node) {
		node.setRight(doRightRotation(node.getRight()));
		return doLeftRotation(node);
	}

	public AVLNode search(Comparable info) {
		return search(this.root, info);
	}

	private AVLNode search(AVLNode node, Comparable info) {
		if (node == null) {
			return null;
		} else if (node.getInfo().equals(info)) {
			return node;
		} else {
			int comp = info.compareTo(node.getInfo());
			if (comp > 0) {
				return search(node.getRight(), info);
			} else if (comp < 0) {
				return search(node.getLeft(), info);
			} else {
				return null;
			}
		}
	}

	public AVLNode min() {
		return minBelow(root);
	}

	private AVLNode minBelow(AVLNode node) {
		if (node != null) {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	public AVLNode max() {
		return maxBelow(root);
	}

	private AVLNode maxBelow(AVLNode node) {
		if (node != null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
	}

	public AVLNode next(AVLNode node) {
		AVLNode result = null;
		if (node.getRight() != null) {
			result = minBelow(node.getRight());
		} else {
			AVLNode parent = node.getParent();
			while (parent.getInfo().compareTo(node.getInfo()) < 0) {
				parent = parent.getParent();
			}
			result = parent;
		}
		return result;
	}

	public void remove(Comparable info) {
		searchToRemove(root, info);
	}

	private AVLNode searchToRemove(AVLNode node, Comparable info) {
		AVLNode result = null;
		if (node.getInfo().equals(info)) {
			result = remove(node);
		} else {
			int comp = info.compareTo(node.getInfo());
			if (comp > 0) {
				node.setRight(searchToRemove(node.getRight(), info));
			} else if (comp < 0) {
				node.setLeft(searchToRemove(node.getLeft(), info));
			}
			result = balance(node);
		}
		return result;
	}

	private AVLNode remove(AVLNode node) {
		AVLNode parent = node.getParent();
		if (isLeaf(node)) {
			// Não tem nenhum filho
			// Remove do pai este nó
			if (parent.getLeft() == node) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
			size--;
			return null;
		} else {
			AVLNode child = null;
			if (node.getLeft() != null && node.getRight() != null) {
				// Tem os dois filhos
				child = maxBelow(node.getLeft());
				remove(child);
				replace(node, child);
			} else {
				// Tem apenas um filho, o nó a substituir será o filho
				if (node.getLeft() != null) {
					child = node.getLeft();
				} else {
					child = node.getRight();
				}
				if (parent.getLeft() == node) {
					parent.setLeft(child);
				} else {
					parent.setRight(child);
				}
				size--;
			}
			// Desliga os filhos no antigo nó
			node.setLeft(null);
			node.setRight(null);
			return child;
		}
	}

	private void replace(AVLNode oldNode, AVLNode newNode) {
		if (oldNode.getLeft() != newNode) {
			newNode.setLeft(oldNode.getLeft());
		}
		if (oldNode.getRight() != newNode) {
			newNode.setRight(oldNode.getRight());
		}

		AVLNode oldParent = oldNode.getParent();
		if (oldParent.getLeft() == oldNode) {
			oldParent.setLeft(newNode);
		} else {
			oldParent.setRight(newNode);
		}
	}

	public boolean isLeaf(AVLNode node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		buildStringPreOrder(root, sb, 1);
		return sb.toString();
	}

	private void buildStringInOder(AVLNode node, StringBuilder sb) {
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

	private void buildStringPreOrder(AVLNode node, StringBuilder sb, int level) {
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

	private void buildStringPostOrder(AVLNode node, StringBuilder sb, int level) {
		if (node.getLeft() != null) {
			buildStringPostOrder(node.getLeft(), sb, level + 1);
		}
		if (node.getRight() != null) {
			buildStringPostOrder(node.getRight(), sb, level + 1);
		}
//		sb.append("\n");
//		for (int i = 0; i < level; ++i) {
//			sb.append("  ");
//		}
		sb.append(" ");
		sb.append(node.getInfo());
	}
}
