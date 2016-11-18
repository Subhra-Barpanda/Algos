package org.coursera.www.princetonuniversity.part2.week1.directedgraphs;

import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericStackImplementationUsingResizingArray;

public class TopologicalSort {
	
	GenericStackImplementationUsingResizingArray<Integer> postOrderStack = null;
	
	public TopologicalSort(DiGraph graph)
	{
		postOrderStack = new GenericStackImplementationUsingResizingArray<Integer>();
		DFS dfsObject = new DFS(graph,0);
		for(int i=1;i<graph.getNoOfVertices();i++)
		{
			if(!dfsObject.marked[i])
			{
				dfsObject.DFSForVertex(graph,i);
			}
		}
	}
	
	public Iterable<Integer> getTopologicalOrder()
	{
		return postOrderStack;
	}
	
	private class DFS
	{
		private boolean[] marked = null;
		
		public DFS(DiGraph graph,int sourceVertex)
		{
			marked = new boolean[graph.getNoOfVertices()];
			DFSForVertex(graph,sourceVertex);
		}
		
		private void DFSForVertex(DiGraph graph, int sourceVertex) 
		{
			marked[sourceVertex] = true;
			for(int connectedVertex:graph.iterateOverAdjVertices(sourceVertex))
			{
				if(!marked[connectedVertex])
				{
					DFSForVertex(graph,connectedVertex);
				}
			}
			postOrderStack.push(sourceVertex);
		}
	}
	
	public static void main(String[] args)
	{
		DiGraph graph = new DiGraph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(0, 2);
		graph.addEdge(1, 4);
		graph.addEdge(3, 6);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 2);
		graph.addEdge(5, 2);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		
		TopologicalSort topSort = new TopologicalSort(graph);
		StringBuilder result = new StringBuilder();
		for(int i:topSort.getTopologicalOrder())
		{
			result.append(i).append(", ");
		}
		System.out.println(result.toString().substring(0,result.length()-2));
	}

}
