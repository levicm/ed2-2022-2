package a02_arvore_binaria;

public class Program {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BTNode root = tree.creatRoot("+");

		BTNode prod = tree.insertLeft("*", root);
		tree.insertLeft("A", prod);
		tree.insertRight("B", prod);

		BTNode div = tree.insertRight("/", root);
		tree.insertLeft("C", div);
		tree.insertRight("D", div);
		
		System.out.println(tree);
		
		PrintVisitor printVisitor = new PrintVisitor();
		tree.traversalInOrder(printVisitor);
	}

}
