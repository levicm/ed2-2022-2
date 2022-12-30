package a10_avl;

public class AVLNode {
	private Comparable info;
	private int height; 
	private AVLNode parent;
	private AVLNode left;
	private AVLNode right;

	public AVLNode(Comparable info) {
		this.info = info;
	}

	public Comparable getInfo() {
		return info;
	}
	
	public int getHeight() {
		return height;
	}
	
	protected void setHeight(int height) {
		this.height = height;
	}
	
	public int getFactor() {
		return getHeight(right) - getHeight(left);
	}

	public AVLNode getParent() {
		return parent;
	}

	public void setParent(AVLNode parent) {
		this.parent = parent;
	}

	public AVLNode getLeft() {
		return left;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
		if (left != null) {
			left.setParent(this);
		}
	}

	public AVLNode getRight() {
		return right;
	}

	public void setRight(AVLNode right) {
		this.right = right;
		if (right != null) {
			right.setParent(this);
		}
	}

	public void updateHeight() {
		System.out.print("atualizando altura. Era " + this.height);
        this.height = Math.max(getHeight(left), getHeight(right)) + 1;
		System.out.println(" e foi para " + this.height);
	}
	
	static public int getHeight(AVLNode node) {
		if (node != null) {
			return node.height;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(info);
	}
}
