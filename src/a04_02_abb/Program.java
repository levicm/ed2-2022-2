package a04_02_abb;

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
		System.out.println("Buscando 30: " + bst.search(30));
		System.out.println("Minimo: " + bst.min());
		System.out.println("Maximo: " + bst.max());
	}

}
