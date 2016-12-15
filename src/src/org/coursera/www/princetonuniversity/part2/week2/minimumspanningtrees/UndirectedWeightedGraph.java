package org.coursera.www.princetonuniversity.part2.week2.minimumspanningtrees;

import java.util.LinkedList;

public class UndirectedWeightedGraph 
{
	private int noOfVertices;
	private int noOfEdges;
	private LinkedList<UndirectedEdge>[] connectedEdges = null;
	
	@SuppressWarnings("unchecked")
	public UndirectedWeightedGraph(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		connectedEdges = (LinkedList<UndirectedEdge>[]) new LinkedList[noOfVertices];
		
		for(int i=0;i<noOfVertices;i++)
			connectedEdges[i] = new LinkedList<UndirectedEdge>();
	}
	
	public void addEdge(UndirectedEdge edge)
	{
		int v = edge.getOneVertex();
		int w = edge.getOtherVertex(v);
		noOfEdges++;
		connectedEdges[v].add(edge);
		connectedEdges[w].add(edge);
	}
	
	public Iterable<UndirectedEdge> getConnectedEdges(int vertex)
	{
		return connectedEdges[vertex];
	}
	
	public int getNoOfVertices()
	{
		return noOfVertices;
	}
	
	public int getNoOfEdges()
	{
		return noOfEdges;
	}
	
	public Iterable<UndirectedEdge> getAllEdges()
	{
		LinkedList<UndirectedEdge> allEdgesIterable = new LinkedList<UndirectedEdge>();
		for(int i=0;i<noOfVertices;i++)
		{
			for(UndirectedEdge edge:getConnectedEdges(i))
			{
				if(!allEdgesIterable.contains(edge))
					allEdgesIterable.add(edge);
			}
		}
		return allEdgesIterable;
	}

}
