package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

import java.util.LinkedList;

public class UndirectedGraph implements GraphAPIInterface{
	
	private int noOfVertices;
	private int noOfEdges;
	private LinkedList<Integer>[] listOfConnectedVertices= null;
	
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		listOfConnectedVertices = (LinkedList<Integer>[]) new LinkedList[noOfVertices];
		for(int i = 0;i<noOfVertices;i++)
			listOfConnectedVertices[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int fromVertex,int toVertex)
	{
		listOfConnectedVertices[fromVertex].add(toVertex);
		if(fromVertex != toVertex)
			listOfConnectedVertices[toVertex].add(fromVertex);
		noOfEdges++;
	}
	
	public Iterable<Integer> iterateOverAdjVertices(int sourceEdge)
	{
		return listOfConnectedVertices[sourceEdge];
	}
	
	public int getNoOfVertices()
	{
		return noOfVertices;
	}
	
	public int getNoOfEdges()
	{
		return noOfEdges;
	}
	
	public int getDegreeOfVertex(int sourceVertex)
	{
		return listOfConnectedVertices[sourceVertex].size();
	}
	
	public int getMaxDegree()
	{
		int maxDegree = 0;
		for(int i=0;i<noOfVertices;i++)
		{
			if(listOfConnectedVertices[i].size() > maxDegree)
				maxDegree = listOfConnectedVertices[i].size();
		}
		
		return maxDegree;
	}
	
	public int getAverageDegree()
	{
		return (2 * noOfEdges)/noOfVertices;
	}
	
	public int getCountOfSelfLoops()
	{
		int count = 0;
		
		for(int i=0;i<noOfVertices;i++)
		{
			for(int adjVertex:iterateOverAdjVertices(i))
			{
				if(adjVertex == i)
					count++;
			}
		}
		
		return count;
	}
	
	public static void main(String args[])
	{
		UndirectedGraph graph = new UndirectedGraph(13);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);
		
		graph.addEdge(6, 6);
		graph.addEdge(12, 12);
		
		System.out.println(graph.getNoOfEdges());
		System.out.println(graph.getNoOfVertices());
		StringBuilder result = new StringBuilder();
		for(int i:graph.iterateOverAdjVertices(0))
			result = result.append(i).append(",");
		
		System.out.println(result.toString().substring(0,result.length()-1));
		System.out.println(graph.getMaxDegree());
		System.out.println(graph.getCountOfSelfLoops());
		
	}
	
	
}
