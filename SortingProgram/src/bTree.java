// The majority of the code for the bTree was 
// obtained from Ian Gauthier's Tutorial Number 5 
// video under Lecture Recordings in MyCourses 
// and slightly modified

import acm.program.*;

public class bTree {
	/**
	 * bTree class used to implement Sorting Algorithm of a list of names
	 * @author saviruperera
	 *
	 */
	
	/**
	 *  bNode is a helper class for structure
	 */
	public class bNode { // 3 instance variables, one being the String which will be the node value (a name)
		// each node has a left child and a right child(which are both also names)
		// left and right child are instance variables of type bNode in order to link it to a rootNode
		String nodeValue;
		bNode leftChild;
		bNode rightChild;
		
		/**
		 * This method constructs a bNode(creates an instance of it)
		 * @param input the String that will be stored as a node in the binary tree
		 */
		public bNode(String input) {
			nodeValue=input;
		}
	}
	
	bNode rootNode; // creates rootNode, equal to null
	
	/**
	 * This method adds new nodes to the binary tree
	 * @param newString the String is what will be stored as the node's value
	 */
	public void addNode(String newString) {
		
		bNode newNode = new bNode(newString);
		bNode currentNode = rootNode;
		if(currentNode==null) { // these lines of code set the first node added to the tree as the root node
			rootNode = newNode;
			return;
		}
		while(true) { // the while loop adds left and right children to the nodes if they are not occupied
			if (newString.compareTo(currentNode.nodeValue)<0) { // if argument is true, the new node is alphabetically before the previous node
				if(currentNode.leftChild==null) {
					currentNode.leftChild=newNode;
					break;
				} else {
					currentNode = currentNode.leftChild; // if the leftChild is occupied, the new root node becomes the left child and the loop repeats
				}
			} else {
				if(currentNode.rightChild==null) {
					currentNode.rightChild=newNode;
					break;
				} else {
					currentNode = currentNode.rightChild; // if the rightChild is occupied, the new root node becomes the right child and the loop repeats
				}
			}
		}
	}
	
	/**
	 * This method traverses the binary tree and sorts the string nodes in alphabetical order(A-Z)
	 * @param startNode The binary tree starts traversal from the root node
	 */
	public void displayInOrder(bNode startNode) { // this method uses a recursive algorithm to operate until all nodes are printed
		if (startNode.leftChild!=null) {
			displayInOrder(startNode.leftChild); 
		}
		link.println(startNode.nodeValue);
		if (startNode.rightChild!=null) {
			displayInOrder(startNode.rightChild);
		}
	}
	
	/**
	 * This method traverses the binary tree and sorts the string nodes in  reverse alphabetical order(Z-A)
	 * @param startNode The binary tree starts the traversal from the root node
	 */
	public void displayInReverseOrder(bNode startNode) { // a recursive algorithm is used to print the nodes
		if (startNode.rightChild!=null) {
			displayInReverseOrder(startNode.rightChild);
		}
		link.println(startNode.nodeValue);
		if (startNode.leftChild!=null) {
			displayInReverseOrder(startNode.leftChild);
		}
	}
	
	/**
	 * This method is essential to use the println function of ACM
	 * This method creates a link between the bTree class and the ConsoleProgram instance SortBuffer
	 * @param cLink takes an instance of ConsoleProgram as a parameter
	 */
	public void setDisplay(ConsoleProgram cLink) {
		link = cLink; 
	}
	
	private ConsoleProgram link; // private instance variable providing a link to consoleProgram instance
	
}
