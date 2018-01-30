package demo;

import graph.Graph;

public class Demo {

	public static void main(String[] args) {

		System.out.println("first test graph");
		Graph first = new Graph("text.txt");
		System.out.println(first.toString());
		System.out.println();
		if (!first.cycleSearch()) {
			first.deepSearch("D");
			System.out.println();
			first.broadSearch("D");
		}
		System.out.println();
		System.out.println("second test graph");
		Graph second = new Graph("text1.txt");
		System.out.println(second.toString());
		System.out.println();
		if (!second.cycleSearch()) {
			second.deepSearch("D");
			System.out.println();
			second.broadSearch("D");
		}
		System.out.println();
		System.out.println("third test graph");
		Graph third = new Graph("text2.txt");
		System.out.println(third.toString());
		System.out.println();
		if (!third.cycleSearch()) {
			third.deepSearch("D");
			System.out.println();
			third.broadSearch("D");
		}
		System.out.println();
		System.out.println("fourth test graph");
		Graph fourth = new Graph("text3.txt");
		System.out.println(fourth.toString());
		System.out.println();
		if (!fourth.cycleSearch()) {
			fourth.deepSearch("D");
			System.out.println();
			fourth.broadSearch("D");
		}
		/*
		 * System.out.println("---Dijkstra-Test---"); System.out.println("[A to D]");
		 * fourth.dijkstra("A", "D");
		 * 
		 * System.out.println("---Dijkstra-Test---"); System.out.println("[D to A]");
		 * fourth.dijkstra("D", "A");
		 */
		System.out.println();
		System.out.println("fifth test graph");
		Graph fifth = new Graph("example_1.txt");
		System.out.println(fifth.toString());
		System.out.println();
		if (!fifth.cycleSearch()) {
			fifth.deepSearch("D");
			System.out.println();
			fifth.broadSearch("D");
		}
		System.out.println();
		System.out.println("sixth test graph");
		Graph sixth = new Graph("example_2.txt");
		System.out.println(sixth.toString());
		System.out.println();
		if (!sixth.cycleSearch()) {
			sixth.deepSearch("D");
			System.out.println();
			sixth.broadSearch("D");
		}

	}

}
