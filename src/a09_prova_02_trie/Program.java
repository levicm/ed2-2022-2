package a09_prova_02_trie;

public class Program {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.put("amo", 50);
		trie.put("amor", 27);
		trie.put("amora", 83);
		trie.put("abre", 30);
		
		System.out.println(trie);
		System.out.println(trie.get("amor"));
		System.out.println(trie.get("amaria"));
		System.out.println(trie.get("amo"));
		
		trie.remove("amor");
		System.out.println(trie);
		trie.remove("amora");
		System.out.println(trie);
		trie.remove("amo");
		System.out.println(trie);
	}

	
	public static void testChars() {
		char valor1 = 'a';
		char valor2 = 'b';
		System.out.println(valor1);
		System.out.println(valor2);
		System.out.println((int) valor1);
		System.out.println((int) valor2);
		int valor3 = 99;
		System.out.println(valor3);
		System.out.println((char) valor3);
		
	}
}
