package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericQueueImplementationUsingLinkedList;

public class BFS {
	
	private boolean[] marked = null;
	private int[] edgeTo = null;
	GenericQueueImplementationUsingLinkedList<Integer> BFSQueue = null;
	
	public BFS(GraphAPIInterface graph,int sourceIndex)
	{
		marked = new boolean[graph.getNoOfVertices()];
		edgeTo = new int[graph.getNoOfVertices()];
		BFSQueue = new GenericQueueImplementationUsingLinkedList<Integer>();
		marked[sourceIndex] = true;
		BFSQueue.enqueue(sourceIndex);
		BFSForVertex(graph,sourceIndex);
	}

	private void BFSForVertex(GraphAPIInterface graph, int sourceIndex) {
		
		while(BFSQueue.peek() != null)
		{
			int vertex = BFSQueue.dequeue();
			for(int i:graph.iterateOverAdjVertices(vertex))
			{
				if(marked[i] != true)
				{
					marked[i] = true;
					BFSQueue.enqueue(i);
					edgeTo[i] = vertex;
				}
			}
		}
		
	}

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
	

}
