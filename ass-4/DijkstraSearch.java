package ru.arrs.graph;

import java.util.HashSet;
import java.util.Set;

import ru.arrs.graph.MyWeightedGraph.Edge;

public class DijkstraSearch<Vertex> {
	MyWeightedGraph<Vertex> graph;
	public DijkstraSearch(MyWeightedGraph<Vertex> graph) {
		this.graph = graph; 
	}
	public void search(Vertex source) {
		Set<Vertex> Q = new HashSet<>();
		for(Vertex vertex : graph.adj()) {
			Q.add(vertex);
		}
		
		while(!Q.isEmpty()) {
			Edge<Vertex> u = this.getVertexWithMinimumWeight((Set<Edge<Vertex>>) graph.map.get(source));
			for(Vertex vertex: graph.adj()) {
				Edge<Vertex> edge = (Edge<Vertex>) graph.map.get(vertex);
				if(edge.getWeight() > u.getWeight() + this.getDistance(u.getSource(), edge.getSource())) {
					Q.add(edge.getSource());
				}
			}
		}
	}
	 private double getDistance(Vertex node, Vertex target) {
	        for (Vertex edge : graph.adj()) {
	            if (((Edge<Vertex>) graph.map.get(edge)).getDest().equals(target))
	                return ((Edge<Vertex>) edge).getWeight();
	        }

	        throw new RuntimeException("Not found!");
	    }
	 private Edge<Vertex> getVertexWithMinimumWeight(Set<Edge<Vertex>> vertices) {
	        Edge<Vertex> minimum = null;
	        for (Edge vertex : vertices) {
	            if (minimum == null)
	                minimum = vertex;
	            else {
	               if(minimum.getWeight() < vertex.getWeight()) {
	            	   minimum = vertex;
	               }
	            }
	        }
	        return minimum;
	    }
	 
}
