package a01_arvore;

public class Programa {

	public static void main(String[] args) {
		Nodo tcc = new Nodo("TCC CCOMP");
		Nodo capa = new Nodo("Capa", tcc);
		Nodo resumo = new Nodo("Resumo", tcc);
		Nodo cap1 = new Nodo("1 - Introdução", tcc);
		Nodo cap11 = new Nodo("1.1 - Objetivos", cap1);
		Nodo cap111 = new Nodo("1.1.1 - Geral", cap11);
		Nodo cap112 = new Nodo("1.1.2 - Específicos", cap11);

		Nodo cap2 = new Nodo("2 - Desenvolvimento", tcc);
		Nodo cap3 = new Nodo("3 - Conclusão", tcc);
		Nodo cap31 = new Nodo("3.1 - Trabalhos futuros", cap3);
		Nodo cap32 = new Nodo(null, cap3);
		
		System.out.println(tcc);
		System.out.println("TCC é raiz? "+ tcc.isRaiz());
		System.out.println("TCC é folha? "+ tcc.isFolha());
		System.out.println("cap112 é raiz? "+ cap112.isRaiz());
		System.out.println("cap112 é folha? "+ cap112.isFolha());
		System.out.println("Nível de cap112: " + cap112.getNivel());
		
		System.out.println(cap1);
		
//		cap1.remove();
		cap11.remove();
		System.out.println(tcc);
	}

}
