package a09_prova_01_abb;

public class Program {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.add(37);
		bst.add(20);
		bst.add(10);
		bst.add(80);
		bst.add(100);
		bst.add(90);
		bst.add(30);
		bst.add(180);
		bst.add(5);

		System.out.println(bst);
		BSTNode node = bst.search(30);
		System.out.println("Buscando 30: " + node);
		
		BSTNode next = bst.next(node);
		System.out.println("Sucessor: " + next);

		System.out.println("Sucessor de 90: " + bst.next(bst.search(90)));
		System.out.println("Sucessor de 20: " + bst.next(bst.search(20)));
		System.out.println("Sucessor de 100: " + bst.next(bst.search(100)));
		
		bst.remove(10);
		System.out.println(bst);
		
		bst.remove(5);
		System.out.println(bst);

		bst.remove(80);
		System.out.println(bst);
		
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.add(50);
		bst2.add(30);
		bst2.add(85);
		bst2.add(20);
		bst2.add(60);
		bst2.add(90);
		bst2.add(10);
		bst2.add(80);
		bst2.add(70);
		System.out.println("Árvore para testar remoção");
		System.out.println(bst2);
		
		bst2.remove(85);
		System.out.println("Depois de remover 85:");
		System.out.println(bst2);

		bst2.remove(20);
		System.out.println("Depois de remover 20:");
		System.out.println(bst2);

		System.out.println("Depois de remover 10:");
		bst2.remove(10);
		System.out.println(bst2);
	}

}
