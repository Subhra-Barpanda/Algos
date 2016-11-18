package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

public class ConnectedComponents {
	
	private int count = 0;
	DFSInner dfsObject = null;
	private int[] idArray = null;
	
	
	public ConnectedComponents(GraphAPIInterface graph)
	{
		idArray = new int[graph.getNoOfVertices()];
		dfsObject = new DFSInner(graph, 0);
		for(int i=1;i<graph.getNoOfVertices();i++)
		{
			if(dfsObject.getMarked()[i] == false)
			{
				++count;
				idArray[i] = count;
				dfsObject.DFSForVertex(graph, i);
			}
			else
				continue;
		}
	}
	
	public boolean isConnected(int sourceVertex,int endVertex)
	{
		return idArray[sourceVertex] == idArray[endVertex];
	}
	
	private class DFSInner {
		
		private boolean[] marked = null;
		private int[] edgeTo = null;
		
		public boolean[] getMarked() {
			return marked;
		}
		
		public DFSInner(GraphAPIInterface graph,int sourceVertex)
		{
			marked = new boolean[graph.getNoOfVertices()];
			edgeTo = new int[graph.getNoOfVertices()];
			DFSForVertex(graph,sourceVertex);
			
		}
		
		
		private void DFSForVertex(GraphAPIInterface graph, int sourceVertex) {
			marked[sourceVertex] = true;
			for(int vertex:graph.iterateOverAdjVertices(sourceVertex))
			{
				if(!marked[vertex])
				{
					DFSForVertex(graph,vertex);
					edgeTo[vertex] = sourceVertex;
					idArray[vertex] = count;
				}
			}
			
		}

	}
	
	public static void main(String args[])
	{
		GraphAPIInterface graph = new UndirectedGraph(13);
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
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		System.out.println(cc.isConnected(7, 8));
		System.out.println(cc.isConnected(0, 12));
		System.out.println(cc.isConnected(8, 12));
		System.out.println(cc.isConnected(9, 12));
		System.out.println(cc.isConnected(0, 6));
	}
}
