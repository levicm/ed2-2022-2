package a02_arvore_binaria;

public interface BTVisitor {
	public void beforeLeft(BTNode node);
	public void afterLeft(BTNode node);
	
	public void beforeRight(BTNode node);
	public void afterRight(BTNode node);

	public void visit(BTNode node);
}
