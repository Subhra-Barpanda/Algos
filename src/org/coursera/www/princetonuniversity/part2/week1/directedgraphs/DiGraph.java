package org.coursera.www.princetonuniversity.part2.week1.directedgraphs;

import java.util.LinkedList;

import org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs.GraphAPIInterface;

public class DiGraph implements GraphAPIInterface{
	
	private LinkedList<Integer>[] linkedComponents = null;
	private int noOfVertcices;
	private int noOfEdges;
	
	@SuppressWarnings("unchecked")
	public DiGraph(int noOfVertices)
	{
		this.noOfVertcices = noOfVertices;
		linkedComponents = (LinkedList<Integer>[])new LinkedList[noOfVertices];
		for(int i=0;i<noOfVertices;i++)
		{
			linkedComponents[i] = new LinkedList<Integer>();
		}
	}

	@Override
	public void addEdge(int fromVertex, int toVertex) {
		linkedComponents[fromVertex].add(toVertex);
		noOfEdges++;
		
	}
	
	public void addEdgeReverse(int fromVertex, int toVertex, LinkedList<Integer>[] reverseLinkedComponents) {
		reverseLinkedComponents[fromVertex].add(toVertex);
	}

	@Override
	public Iterable<Integer> iterateOverAdjVertices(int sourceEdge) {
		return linkedComponents[sourceEdge];
	}

	@Override
	public int getNoOfVertices() {
		return noOfVertcices;
	}

	@Override
	public int getNoOfEdges() {
		return noOfEdges;
	}
	
	public DiGraph reverse()
	{
		DiGraph reverseGraph = new DiGraph(noOfVertcices);
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] reverseLinkedComponents = (LinkedList<Integer>[])new LinkedList[getNoOfVertices()];
		for(int i=0;i<getNoOfVertices();i++)
		{
			reverseLinkedComponents[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<getNoOfVertices();i++)
		{
			for(int j:iterateOverAdjVertices(i))
			{
				addEdgeReverse(j,i,reverseLinkedComponents);
			}
		}
		reverseGraph.noOfVertcices = noOfVertcices;
		reverseGraph.noOfEdges = noOfEdges;
		reverseGraph.linkedComponents = reverseLinkedComponents;
		return reverseGraph;
		
	}

}
