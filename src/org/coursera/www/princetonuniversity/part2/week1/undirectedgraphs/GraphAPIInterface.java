package org.coursera.www.princetonuniversity.part2.week1.undirectedgraphs;

public interface GraphAPIInterface {

	public void addEdge(int fromVertex,int toVertex);
	public Iterable<Integer> iterateOverAdjVertices(int sourceEdge);
	public int getNoOfVertices();
	public int getNoOfEdges();
}
