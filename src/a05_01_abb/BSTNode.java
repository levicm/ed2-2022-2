package a05_01_abb;

public class BSTNode {
	private Comparable info;
	private BSTNode parent;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(Comparable info) {
		this.info = info;
	}
	
	public Comparable getInfo() {
		return info;
	}

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.valueOf(info);
	}
}
