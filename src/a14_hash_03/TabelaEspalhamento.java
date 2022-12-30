package a14_hash_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static int SIZE = 26;

	private List<List<Object>> tabela = new ArrayList<List<Object>>();

	public TabelaEspalhamento() {
		for (int i = 0; i < SIZE; ++i) {
			List<Object> lista = new LinkedList<Object>();
			tabela.add(lista);
		}
	}

	public void adiciona(Object chave) {
		if (!contem(chave)) {
			int indice = calculaIndice(chave);
			List<Object> lista = tabela.get(indice);
			lista.add(chave);
		}
	}

	public void remove(Object chave) {
		int indice = calculaIndice(chave);
		List<Object> lista = tabela.get(indice);
		lista.remove(chave);
	}

	public boolean contem(Object chave) {
		int indice = calculaIndice(chave);
		List<Object> lista = tabela.get(indice);
		return lista.contains(chave);
	}

	private int calculaIndice(Object chave) {
		int valor = calculaValorChave(chave);
		int resultado = valor % SIZE;
		System.out.println(chave + ":" + valor + ":" + resultado);
		return resultado;
	}

	private int calculaValorChave(Object chave) {
		return Math.abs(chave.hashCode());
	}

	public String toString() {
		return tabela.toString();
	}
}
