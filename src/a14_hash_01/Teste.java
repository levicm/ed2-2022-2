package a14_hash_01;

public class Teste {

	public static void main(String[] args) {
		TabelaEspalhamento te = new TabelaEspalhamento();
		te.adiciona("abacaxi");
		te.adiciona("abacaxi");
		te.adiciona("melancia");
		te.adiciona("banana");
		te.adiciona("abacate");
		te.adiciona("graviola");
		te.adiciona("melao");
		te.adiciona("a�a�");
		System.out.println(te);

		if (!te.contem("abacaxi")) {
			System.out.println("Erro! N�o encontrou abacaxi");
		}
		te.remove("melancia");
		System.out.println(te);
		if (te.contem("melancia")) {
			System.out.println("Erro! Ainda encontrou melancia");
		}
	}

}
