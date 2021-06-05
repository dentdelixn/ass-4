package ru.arrs.graph;
import java.util.*;

 


public class MyWeightedGraph<Vertex> {
    private final boolean undirected;
    Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public MyWeightedGraph() {
        this.undirected = true;
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) { 
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops
        Edge<Vertex> edg = new Edge<Vertex>(source, dest, weight);
        
        
        map.get(source).add(edg);
              
    }
    public int getPosition(Vertex v) {
    	int position = 0;
    	for(Vertex ver: this.adj()) {
    		if(ver.equals(v)) {
    			break;
    		}
    		position++;
    	}
    	
    	return position;
    }
    public int getVerticesCount() {
    	return map.size();
    }

    
    
    public Vertex BFSearch(Vertex vertex, Vertex sec)
    { 
        boolean visited[] = new boolean[map.size()];
  
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
  
        visited[getPosition(vertex)]=true;
        queue.add(vertex);
         
        while (queue.size() != 0)
        { 
            vertex = queue.poll(); 
            if(vertex.equals(sec)) {
            	return vertex;
            }
            for(Vertex v : this.adj()) {
            	if(!visited[getPosition(v)]) {
            		visited[getPosition(vertex)] = true;
                    queue.add(v);
            	}
            }
             
        }
        return null;
    }
    public int getEdgesCount() {
    	int sum = 0;
    	 for(Vertex v: map.keySet()) {
    		 sum += map.get(v).size();
    	 }
    	 if(undirected) sum /= 2;
    	return sum;
    }

    public boolean hasVertex(Vertex v) {
    	 
    	return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
    	  if(!hasVertex(source) || !hasVertex(dest)) {
    		  return false;
    	  }
 
    	return this.map.get(source).contains(dest);
    }

    public Iterable<Vertex> adj() {
    	return map.keySet();
    }
    
    
    static class Edge<Vertex> {
    	private Vertex source;
    	private Vertex dest;
    	private Double weight;
    	
    	
    	public Edge(Vertex source, Vertex dest, Double weight) {
    		this.source = source;
    		this.dest = dest;
    		this.weight = weight;
    	}
    	public Vertex getSource() {
    		return source;
    	}
    	public void setSource(Vertex source) {
    		this.source = source;
    	}
    	public Vertex getDest() {
    		return dest;
    	}
    	public void setDest(Vertex dest) {
    		this.dest = dest;
    	}
    	public Double getWeight() {
    		return weight;
    	}
    	public void setWeight(Double weight) {
    		this.weight = weight;
    	}
    	 
    }
    
}
 