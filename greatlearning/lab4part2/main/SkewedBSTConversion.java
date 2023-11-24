package com.greatlearning.lab4part2.main;

import com.greatlearning.lab4part2.implementation.TreeNodeImplementation;


public class SkewedBSTConversion {
	public static void main(String[] args) {

		TreeNodeImplementation.TreeNode root = new TreeNodeImplementation.TreeNode(50);
		root.left = new TreeNodeImplementation.TreeNode(30);
		root.right = new TreeNodeImplementation.TreeNode(60);
		root.left.left = new TreeNodeImplementation.TreeNode(10);
		root.right.left = new TreeNodeImplementation.TreeNode(55);

		TreeNodeImplementation implementation = new TreeNodeImplementation();

		root = implementation.convertToSkewed(root);

		implementation.printInOrder(root);
	}
}