package a04_01_arvore_binaria_expressao;

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
		FindVisitor visitor = new FindVisitor(info);
		traversalPreOrder(visitor);
		return visitor.result;
	}

	class FindVisitor extends BTAbstractVisitor {

		private Object info;
		private BTNode result;

		public FindVisitor(Object info) {
			this.info = info;
		}

		public void visit(BTNode node) {
			if (node.getInfo().equals(info)) {
				this.result = node;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringVisitor visitor = new StringVisitor(sb);
		traversalInOrder(visitor);
		return sb.toString();
	}

	class StringVisitor extends BTAbstractVisitor {

		private StringBuilder sb;

		public StringVisitor(StringBuilder sb) {
			this.sb = sb;
		}

		public void beforeLeft(BTNode node) {
			sb.append("(");
		}

		public void afterRight(BTNode node) {
			sb.append(")");
		}

		public void visit(BTNode node) {
			sb.append(node.getInfo());
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
			visitor.beforeLeft(node);
			traversalPreOrder(node.getLeft(), visitor);
			visitor.afterLeft(node);
		}
		if (node.getRight() != null) {
			visitor.beforeRight(node);
			traversalPreOrder(node.getRight(), visitor);
			visitor.afterRight(node);
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

	public void traversalPostOrder(BTVisitor visitor) {
		traversalPostOrder(root, visitor);
	}

	private void traversalPostOrder(BTNode node, BTVisitor visitor) {
		if (node != null) {
			if (node.getLeft() != null) {
				visitor.beforeLeft(node);
				traversalPostOrder(node.getLeft(), visitor);
				visitor.afterLeft(node);
			}
			if (node.getRight() != null) {
				visitor.beforeRight(node);
				traversalPostOrder(node.getRight(), visitor);
				visitor.afterRight(node);
			}
			visitor.visit(node);
		}
	}

	public BinaryTree copy() {
		BinaryTree copyTree = new BinaryTree();
		if (root != null) {
			copyTree.creatRoot(root.getInfo());
		}
		doCopy(root, copyTree.getRoot(), copyTree);

		return copyTree;
	}

	private void doCopy(BTNode thisNode, BTNode copyNode, BinaryTree copyTree) {
		if (thisNode.getLeft() != null) {
			BTNode copyLeft = copyTree.insertLeft(thisNode.getLeft().getInfo(), 
					copyNode);
			doCopy(thisNode.getLeft(), copyLeft, copyTree);
		}
		if (thisNode.getRight() != null) {
			BTNode copyRight = copyTree.insertRight(thisNode.getRight().getInfo(), 
					copyNode);
			doCopy(thisNode.getRight(), copyRight, copyTree);
		}
	}
}














