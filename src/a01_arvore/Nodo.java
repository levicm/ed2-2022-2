package a01_arvore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Nodo {
	private Object info;
	private Nodo pai;
	private List<Nodo> filhos = new ArrayList<Nodo>();
	
	public Nodo(Object info) {
		this.info = info;
	}
	
	public Nodo(Object info, Nodo pai) {
		this.info = info;
		this.pai = pai;
		this.pai.filhos.add(this);
	}
	
	public Object getInfo() {
		return info;
	}
	
	public Nodo getPai() {
		return pai;
	}
	
	public List<Nodo> getFilhos() {
		return filhos;
	}
	
	public void addFilho(Nodo nodo) {
		filhos.add(nodo);
		nodo.pai = this;
	}
	
	public void addFilho(int indice, Nodo nodo) {
		filhos.add(indice, nodo);
		nodo.pai = this;
	}
	
	public boolean isRaiz() {
		return pai == null;
	}
	
	public boolean isFolha() {
		return filhos.size() == 0;
	}
	
	public int getNivel() {
		int resultado = 1;
		Nodo acima = pai;
		while (acima != null) {
			resultado++;
			acima = acima.pai;
		}
		return resultado;
	}
	
	public void remove() {
		if (pai != null) {
			int indice = pai.getFilhos().indexOf(this); 
			pai.getFilhos().remove(this);
			
			for (Nodo filho : filhos) {
				pai.addFilho(indice++, filho);
			}

			pai = null;
		}
	}

	public void removeTudo() {
		if (pai != null) {
			pai.getFilhos().remove(this);
			pai = null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringPreOrdem(sb, 0);
		return sb.toString();
	}
	
	private void montaStringPreOrdem(StringBuilder sb, int nivel) {
		sb.append("\n");
		for (int i = 0; i < nivel; ++i) {
			sb.append("  ");
		}
		sb.append(info);
		for (Nodo filho : filhos) {
			filho.montaStringPreOrdem(sb, nivel + 1);
		}
	}

	private static void montaStringPreOrdemRec(Nodo nodo, StringBuilder sb) {
		sb.append(nodo.info.toString());
		for (Nodo filho : nodo.filhos) {
			montaStringPreOrdemRec(filho, sb);
		}
	}
	
}
