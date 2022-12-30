package a10_hash_01;

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
//		System.out.println(chave.toLowerCase().charAt(0) + ":" + ((byte)chave.toLowerCase().charAt(0))+":"+(chave.toLowerCase().charAt(0) % SIZE));
		return chave.toLowerCase().charAt(0) % SIZE;
	}

	public String toString() {
		return tabela.toString();
	}
}
