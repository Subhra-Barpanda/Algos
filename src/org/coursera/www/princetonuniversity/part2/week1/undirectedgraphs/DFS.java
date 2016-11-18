package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

public class DFS {
	
	private boolean[] marked = null;
	private int[] edgeTo = null;
	
	public boolean[] getMarked() {
		return marked;
	}

	public void setMarked(boolean[] marked) {
		this.marked = marked;
	}

	public int[] getEdgeTo() {
		return edgeTo;
	}

	public void setEdgeTo(int[] edgeTo) {
		this.edgeTo = edgeTo;
	}
	
	public DFS(GraphAPIInterface graph,int sourceVertex)
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
			}
		}
		
	}

}
