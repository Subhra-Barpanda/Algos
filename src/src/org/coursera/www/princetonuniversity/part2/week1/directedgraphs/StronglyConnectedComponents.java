package org.coursera.www.princetonuniversity.part2.week1.directedgraphs;

public class StronglyConnectedComponents {
	
	private int[] idArray = null;
	private int count = 0;
	private boolean[] marked = null;
	
	public StronglyConnectedComponents(DiGraph graph)
	{
		idArray = new int[graph.getNoOfVertices()];
		marked = new boolean[graph.getNoOfVertices()];
		TopologicalSort topSort = new TopologicalSort(graph.reverse());
		DFS dfsObject = new DFS();
		for(int i:topSort.getTopologicalOrder())
		{
			if(!marked[i])
			{
				dfsObject.DFSForVertex(graph, i);
				count++;
			}
		}
	}
	
	public boolean isStronglyConnected(int v,int w)
	{
		return idArray[v] == idArray[w];
	}
	
	private class DFS
	{
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
			idArray[sourceVertex] = count;
		}
	}
	
	public static void main(String args[])
	{
		DiGraph graph = new DiGraph(22);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 4);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
		graph.addEdge(7, 9);
		graph.addEdge(8, 6);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		graph.addEdge(11, 12);
		graph.addEdge(12, 9);
		
		StronglyConnectedComponents scc = new StronglyConnectedComponents(graph);
		System.out.println(scc.isStronglyConnected(7, 8));
		System.out.println(scc.isStronglyConnected(0, 12));
		System.out.println(scc.isStronglyConnected(8, 12));
		System.out.println(scc.isStronglyConnected(9, 12));
		System.out.println(scc.isStronglyConnected(0, 6));
		
		System.out.println(scc.isStronglyConnected(8, 6));
		System.out.println(scc.isStronglyConnected(0, 1));
		System.out.println(scc.isStronglyConnected(0, 5));
	}
}
