package a03_01_arvore_binaria;

public class ExpressionEvaluator {
	
	private BinaryTree tree;

	public ExpressionEvaluator(BinaryTree tree) {
		this.tree = tree;
	}
	
	public Integer evaluate() {
		return ExpressionTool.evaluate(tree.getRoot());
	}
}
