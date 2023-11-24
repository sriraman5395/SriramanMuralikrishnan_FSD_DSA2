package com.greatlearning.lab4.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructionOrderImplementation {
	public List<Stack<Integer>> getConstructionOrder(int totalFloors, int[] floorSizes) {
		List<Stack<Integer>> constructionOrder = new ArrayList<>();

		for (int i = 0; i < totalFloors; i++) {
			int floorSize = floorSizes[i];

			Stack<Integer> currentDayConstruction = new Stack<>();
			currentDayConstruction.push(floorSize);

			for (int j = i - 1; j >= 0; j--) {
				Stack<Integer> previousDayConstruction = constructionOrder.get(j);

				while (!previousDayConstruction.isEmpty()
						&& currentDayConstruction.peek() > previousDayConstruction.peek()) {
					currentDayConstruction.addAll(reverseStack(previousDayConstruction));
				}
			}

			constructionOrder.add(reverseStack(currentDayConstruction));
		}

		return constructionOrder;
	}

	private Stack<Integer> reverseStack(Stack<Integer> stack) {
		Stack<Integer> reversed = new Stack<>();
		while (!stack.isEmpty()) {
			reversed.push(stack.pop());
		}
		return reversed;
	}

}
