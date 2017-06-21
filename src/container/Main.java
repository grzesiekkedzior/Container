/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author grzesiek
 */
public class Main {
	public static void main(String args[]) {

		Container<Integer> integer = new Container<>();

		

		for (int i = 0; i < 5; i++) {
			integer.addSorted(i);
		}
		integer.showAll();
		System.out.println("addSorted\n");
		
		

		for (int i = 0; i < 5; i++) {
			integer.addOnBack(i);
		}
		integer.showAll();
		System.out.println("addOnBack\n");

		for (int i = 0; i < 5; i++) {
			integer.add(i);
		}
		integer.showAll();
		System.out.println("add\n");

		for (int i = 0; i < 5; i++) {
			integer.removeNode(i);
		}
		integer.showAll();
		System.out.println("removeNode\n");
		for (int i = 0; i < 5; i++) {
			integer.addSorted(i);
		}
		integer.showAll();
		System.out.println("addSorted\n");
		
		for (int i = 0; i < 5; i++) {
			integer.removeNode(i + 1);
			integer.addOnBack(0);
		}
		integer.showAll();
		System.out.println("removeNode\n");
		// System.out.println("Sorted with add");
		System.out.println("show all");
		System.out.println("\n");
		integer.showAll();
		
		int a = integer.getNode(8);
		System.out.println(a);
		
		Container<String> str = new Container<>();
		
		for (int i = 0; i < 5; i++) {
			str.addSorted("A"+i);
		}
		str.showAll();
		System.out.println("addSorted\n");
		
		for (int i = 0; i < 5; i++) {
			str.add("A"+i);
		}
		str.showAll();
		System.out.println("add\n");
		
		for (int i = 0; i < 5; i++) {
			str.addOnBack("A"+i);
		}
		str.showAll();
		System.out.println("addOnBack\n");
		
		for (int i = 0; i < 5; i++) {
			str.removeNode(1);
		}
		str.showAll();
		System.out.println("removeNode\n");
		
		for (int i = 0; i < 5; i++) {
			str.addSorted("A"+i);
		}
		str.showAll();
		System.out.println("addSorted\n");
		
		String s = str.getNode(3);
		System.out.println(s);
	}
}
