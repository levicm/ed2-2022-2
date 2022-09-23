package a02_arvore_binaria;

public class ExpressionEvalProgram {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft(2, prod);
		tree.insertRight(5, prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft(7, div);
		tree.insertRight(8, div);
		
		evaluate(root);
		System.out.println(tree);
	}

	private static Integer evaluate(BTNode root) {
		Integer left = null;
		if (root.getLeft() != null) {
			left = evaluate(root.getLeft());
		}
		Integer right = null;
		if (root.getRight() != null) {
			right = evaluate(root.getRight());
		}
		if (root.getInfo() instanceof Integer) {
			return (Integer) root.getInfo();
		}
		// Concluir a operação
		return null;
	}
	
	

}
