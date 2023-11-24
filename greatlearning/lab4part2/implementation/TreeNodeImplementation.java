package com.greatlearning.lab4part2.implementation;

public class TreeNodeImplementation {
	public static class TreeNode {
		int data;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int item) {
			data = item;
			left = right = null;
		}
	}

	private TreeNode rightRotate(TreeNode root) {
		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		return newRoot;
	}

	public TreeNode convertToSkewed(TreeNode root) {
		if (root == null) {
			return null;
		}

		root.left = convertToSkewed(root.left);

		while (root.left != null) {
			root = rightRotate(root);
		}

		root.right = convertToSkewed(root.right);

		return root;
	}

	public void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}
}