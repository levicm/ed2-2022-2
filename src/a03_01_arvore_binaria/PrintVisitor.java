package a03_01_arvore_binaria;

public class PrintVisitor implements BTVisitor {

	public void visit(BTNode node) {
		System.out.print(" " + node.getInfo() + " ");
	}

	@Override
	public void beforeLeft(BTNode node) {
		System.out.print("(");
	}

	@Override
	public void afterLeft(BTNode node) {
	}

	@Override
	public void beforeRight(BTNode node) {
	}

	@Override
	public void afterRight(BTNode node) {
		System.out.print(")");
	}
}
