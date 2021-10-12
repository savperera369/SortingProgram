// Sorting Program
// Created by Saviru Perera-260966369
// The println code was taken from the ECSE 202 Assignment 2 pdf

import acm.program.*;

public class SortBuffer extends ConsoleProgram {
	
	public void run() {
		
		// println statements below give instructions to user on how to use program
		println("Text Sorting Program: ECSE 202 Assignment 2");
		println("Enter text to be sorted, line by line. A blank line terminates.");
		println("You can cut and paste text into this window.");
		
		// create an instance of the bTree class
		bTree myTree = new bTree();
		
		// while loop reads in as many names as user wants and stores them in a string variable input
		// each string is added to the binary tree
		while(true) {
			String input = readLine("\nEnter a name: ");
			if (input.equals("")) break; // program terminates if blank input is given
			myTree.addNode(input);
		}
		
		// allows the bTree class to be linked to the console program
		myTree.setDisplay(this);
		
		// displays names in sort order (A-Z)
		println("\nText in Sort Order: \n");
		myTree.displayInOrder(myTree.rootNode);
		
		// displays names in reverse sort order (Z-A)
		println("\nText in Reverse Sort Order: \n");
		myTree.displayInReverseOrder(myTree.rootNode);
		
		println("\nProgram Terminated.");
	}

}
