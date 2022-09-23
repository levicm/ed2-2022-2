package a02_arvore_binaria;

import a01_arvore.Nodo;

public class BinaryTree {

	private BTNode root;
	private int size = 0;

	public BTNode creatRoot(Object info) {
		if (root != null) {
			throw new RuntimeException("Raiz já existe!");
		}
		root = new BTNode(info);
		size++;
		return root;
	}

	public BTNode getRoot() {
		return root;
	}

	public BTNode insertLeft(Object info, BTNode parent) {
		if (parent.getLeft() != null) {
			throw new RuntimeException("Nodo esquerdo já existe!");
		}
		BTNode node = new BTNode(info);
		node.setParent(parent);
		parent.setLeft(node);
		size++;
		return node;
	}

	public BTNode insertRight(Object info, BTNode parent) {
		if (parent.getRight() != null) {
			throw new RuntimeException("Nodo direito já existe!");
		}
		BTNode node = new BTNode(info);
		node.setParent(parent);
		parent.setRight(node);
		size++;
		return node;
	}

	public int degree(BTNode node) {
		int result = 0;
		if (node.getLeft() != null) {
			result++;
		}
		if (node.getRight() != null) {
			result++;
		}
		return result;
	}

	public int level(BTNode node) {
		int result = 1;
		BTNode parent = node.getParent();
		while (parent != null) {
			result++;
			parent = parent.getParent();
		}
		return result;
	}

	public BTNode find(Object info) {
		return findPreOrder(root, info);
	}

	private static BTNode findPreOrder(BTNode node, Object info) {
		BTNode result = null;
		if (node != null) {
			if (node.getInfo().equals(info)) {
				result = node;
			}
			if (result == null) {
				result = findPreOrder(node.getLeft(), info);
			}
			if (result == null) {
				result = findPreOrder(node.getRight(), info);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		buildStringInOder(root, sb);
		return sb.toString();
	}

	private void buildStringInOder(BTNode node, StringBuilder sb) {
		if (node != null) {
			sb.append("(");
			if (node.getLeft() != null) {
				buildStringInOder(node.getLeft(), sb);
			}

			sb.append(" ");
			sb.append(node.getInfo());
			sb.append(" ");

			if (node.getRight() != null) {
				buildStringInOder(node.getRight(), sb);
			}
			sb.append(")");
		}
	}

	public void traversalPreOrder(BTVisitor visitor) {
		traversalPreOrder(root, visitor);
	}

	private void traversalPreOrder(BTNode node, BTVisitor visitor) {
		if (node != null) {
			visitor.visit(node);
		}
		if (node.getLeft() != null) {
			traversalPreOrder(node.getLeft(), visitor);
		}
		if (node.getRight() != null) {
			traversalPreOrder(node.getRight(), visitor);
		}
	}

	public void traversalInOrder(BTVisitor visitor) {
		traversalInOrder(root, visitor);
	}

	private void traversalInOrder(BTNode node, BTVisitor visitor) {
		if (node != null) {
			if (node.getLeft() != null) {
				visitor.beforeLeft(node);
				traversalInOrder(node.getLeft(), visitor);
				visitor.afterLeft(node);
			}
			visitor.visit(node);
			if (node.getRight() != null) {
				visitor.beforeRight(node);
				traversalInOrder(node.getRight(), visitor);
				visitor.afterRight(node);
			}
		}
	}

}
