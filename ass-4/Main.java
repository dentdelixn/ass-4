package ru.arrs.graph;

public class Main {
	public static void main(String[] args) {
		   MyWeightedGraph<String> graph = new MyWeightedGraph<String>(true);

	        graph.addEdge("Almaty", "Astana", 2.1);
	        graph.addEdge("Almaty", "Shymkent", 7.2);
	        graph.addEdge("Shymkent", "Astana", 3.9);
	        graph.addEdge("Astana", "Kostanay", 3.5);
	        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
	        
	        
	       String j = graph.BFSearch("Almaty", "Kostanay");
	       System.out.println(j);
	      
	}
}
