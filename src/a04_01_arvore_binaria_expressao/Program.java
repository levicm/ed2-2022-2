package a04_01_arvore_binaria_expressao;

public class Program {

	public static void main(String[] args) {
		BinaryTree tree1 = getTree1();
		System.out.println(tree1);

		ExpressionVisitor evaluator = new ExpressionVisitor();
		tree1.traversalPostOrder(evaluator);
		System.out.println(evaluator.getResult());

		BinaryTree tree2 = getTree2();
		System.out.println(tree2);
		ExpressionVisitor evaluator2 = new ExpressionVisitor();
		tree2.traversalPostOrder(evaluator2);
		System.out.println(evaluator2.getResult());
	}
	
	private static BinaryTree getTree1() {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft(2.0, prod);
		tree.insertRight(5.0, prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft(24.0, div);
		tree.insertRight(8.0, div);
		return tree;
	}

	private static BinaryTree getTree2() {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft(5.0, prod);
		tree.insertRight(9.0, prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft(15.0, div);
		
		BTNode menos = tree.insertRight("-", div);
		tree.insertLeft(41.0, menos);
		tree.insertRight(38.0, menos);

		return tree;
	}
}
