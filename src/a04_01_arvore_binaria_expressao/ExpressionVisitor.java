package a04_01_arvore_binaria_expressao;

import java.util.Stack;

public class ExpressionVisitor extends BTAbstractVisitor  {
	
	private Stack<Double> stack = new Stack<Double>();
	
	public void visit(BTNode node) {
		if (node != null) {
			// Se a informação já for um número (folhas), empilha-o
			if (node.getInfo() instanceof Double) {
				stack.push((Double) node.getInfo());
			} else {
				Double value = null;
				// Desempilha os operandos
				Double right = stack.pop();
				Double left = stack.pop();
				// Executar a operação com os valores
				if (node.getInfo().equals("+")) {
					value = left + right;
				} else if (node.getInfo().equals("-")) {
					value = left - right;
				} else if (node.getInfo().equals("*")) {
					value = left * right;
				} else if (node.getInfo().equals("/")) {
					value = left / right;
				}
				// Empilha o resultado
				stack.push(value);
			}
		}
	}

	public Double getResult() {
		return stack.peek();
	}
	
}
