package a04_01_arvore_binaria_expressao;

public class BTNode {
	private Object info;
	private BTNode parent;
	private BTNode left;
	private BTNode right;
	
	public BTNode(Object info) {
		this.info = info;
	}
	
	public Object getInfo() {
		return info;
	}

	public BTNode getParent() {
		return parent;
	}

	public void setParent(BTNode parent) {
		this.parent = parent;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.valueOf(info);
	}
}
