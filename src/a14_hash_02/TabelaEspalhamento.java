package a14_hash_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static int SIZE = 26;

	private List<List<String>> tabela = new ArrayList<List<String>>();

	public TabelaEspalhamento() {
		for (int i = 0; i < SIZE; ++i) {
			List<String> lista = new LinkedList<String>();
			tabela.add(lista);
		}
	}

	public void adiciona(String chave) {
		if (!contem(chave)) {
			int indice = calculaIndice(chave);
			List<String> lista = tabela.get(indice);
			lista.add(chave);
		}
	}

	public void remove(String chave) {
		int indice = calculaIndice(chave);
		List<String> lista = tabela.get(indice);
		lista.remove(chave);
	}

	public boolean contem(String chave) {
		int indice = calculaIndice(chave);
		List<String> lista = tabela.get(indice);
		return lista.contains(chave);
	}

	private int calculaIndice(String chave) {
		int valor = calculaValorChave(chave);
		int resultado = valor % SIZE; 
		System.out.println(chave.toLowerCase().charAt(0) + ":" + valor +":"+resultado);
		return resultado;
	}

	private int calculaValorChave(String chave) {
		int resultado = 1;
		for (int i = 0; i < chave.length(); ++i) {
			resultado += (int) Math.pow((int) chave.toLowerCase().charAt(i) - 96, i);
		}
		return resultado;
	}

	public String toString() {
		return tabela.toString();
	}
}
