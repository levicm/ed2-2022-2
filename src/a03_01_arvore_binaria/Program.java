package a03_01_arvore_binaria;

public class Program {

	public static void main(String[] args) {
		BinaryTree tree1 = getTree1();
		System.out.println(tree1);
		System.out.println(tree1.hashCode());
		System.out.println(ExpressionTool.evaluate(tree1.getRoot()));

		BinaryTree tree2 = getTree2();
		System.out.println(tree2);
		ExpressionEvaluator evaluator = new ExpressionEvaluator(tree2);
		System.out.println(evaluator.evaluate());
		
		BinaryTree tree3 = tree1.copy();
		System.out.println(tree3);
		System.out.println(tree3.hashCode());
	}
	
	private static BinaryTree getTree1() {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft(2, prod);
		tree.insertRight(5, prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft(24, div);
		tree.insertRight(8, div);
		return tree;
	}

	private static BinaryTree getTree2() {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft(5, prod);
		tree.insertRight(9, prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft(15, div);
		
		BTNode menos = tree.insertRight("-", div);
		tree.insertLeft(41, menos);
		tree.insertRight(38, menos);

		return tree;
	}
}
