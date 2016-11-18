package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericStackImplementationUsingResizingArray;

public class GraphPath {
	
	private DFS dfsObject = null;
	//private BFS bfsObject = null;
	private GenericStackImplementationUsingResizingArray<Integer> pathStack = null;
	private int sourceVertex;
	
	public GraphPath(GraphAPIInterface graph,int sourceVertex)
	{
		this.sourceVertex = sourceVertex;
		dfsObject = new DFS(graph, sourceVertex);
		//bfsObject = new BFS(graph, sourceVertex);
	}
	
	public boolean isPathExists(int vertex)
	{
		return dfsObject.getMarked()[vertex];
		//return bfsObject.getMarked()[vertex];
	}
	
	public Iterable<Integer> path(int vertex)
	{
		if((dfsObject.getMarked()[vertex]) == false)
				return null;
		else
		{
			pathStack = new GenericStackImplementationUsingResizingArray<Integer>();
			int i = vertex;
			while(i!=sourceVertex)
			{
				pathStack.push(i);
				i = dfsObject.getEdgeTo()[i];
			}
			pathStack.push(sourceVertex);
			return pathStack;
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
		
		/*graph.addEdge(6, 6);
		graph.addEdge(12, 12);*/
		
		GraphPath path = new GraphPath(graph, 0);
		System.out.println(path.isPathExists(6));
		System.out.println(path.isPathExists(10));
		
		StringBuilder result = new StringBuilder();
		
		for(int i:path.path(6))
			result = result.append(i).append(",");
		
		System.out.println(result.toString().substring(0,result.length()-1));
		
	}
	

}
