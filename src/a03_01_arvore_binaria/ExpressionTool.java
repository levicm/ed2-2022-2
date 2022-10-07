package a03_01_arvore_binaria;

public class ExpressionTool {
	
	public static Double evaluate(BTNode root) {
		if (root != null) {
			// Se a informação já for um número (folhas), retorna-o
			if (root.getInfo() instanceof Double) {
				return (Double) root.getInfo();
			}
			// Avalia os nós
			Double left = evaluate(root.getLeft());
			Double right = evaluate(root.getRight());
			// Executar a operação com o resultado dos nós
			if (root.getInfo().equals("+")) {
				return left + right;
			} else if (root.getInfo().equals("-")) {
				return left - right;
			} else if (root.getInfo().equals("*")) {
				return left * right;
			} else if (root.getInfo().equals("/")) {
				return left / right;
			}
		}
		return null;
	}
}
