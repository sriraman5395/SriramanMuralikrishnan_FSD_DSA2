package com.greatlearning.lab4.main;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.greatlearning.lab4.implementation.ConstructionOrderImplementation;

public class OrderOfConstruction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building: ");
		int totalFloors = scanner.nextInt();

		int[] floorSizes = new int[totalFloors];

		for (int i = 0; i < totalFloors; i++) {
			System.out.println("Enter the floor size given on day : " + (i + 1) );
			floorSizes[i] = scanner.nextInt();
		}

		ConstructionOrderImplementation constructionOrderService = new ConstructionOrderImplementation();
		List<Stack<Integer>> constructionOrder = constructionOrderService.getConstructionOrder(totalFloors, floorSizes);

		System.out.println("\nThe order of construction is as follows:\n");

		for (int i = 0; i < totalFloors; i++) {
			System.out.println("Day: " + (i + 1));
			Stack<Integer> currentDayConstruction = constructionOrder.get(i);
			if (currentDayConstruction.isEmpty()) {
				System.out.println("");
			} else {
				while (!currentDayConstruction.isEmpty()) {
					System.out.print(currentDayConstruction.pop() + " ");
				}
				System.out.println();
			}
		}

		scanner.close();
	}
}