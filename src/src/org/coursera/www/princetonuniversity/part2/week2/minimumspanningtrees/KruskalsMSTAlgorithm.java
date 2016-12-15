package org.coursera.www.princetonuniversity.part2.week2.minimumspanningtrees;

import org.coursera.www.princetonuniversity.part1.week1.WeightedQuickUnion;
import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericQueueImplementationUsingLinkedList;
import org.coursera.www.princetonuniversity.part1.week4.priorityqueues.MinPriorityQueueUsingBinaryHeapTree;

public class KruskalsMSTAlgorithm 
{
	private GenericQueueImplementationUsingLinkedList<UndirectedEdge> MSTQueue = null;
	private MinPriorityQueueUsingBinaryHeapTree<UndirectedEdge> minHeap = null;
	private WeightedQuickUnion UF = null;
	private int noOfVertices;
	private double MSTWeight = 0.0d;
	
	public KruskalsMSTAlgorithm(UndirectedWeightedGraph graph)
	{
		MSTQueue = new GenericQueueImplementationUsingLinkedList<>();
		minHeap = new MinPriorityQueueUsingBinaryHeapTree<>(graph.getNoOfEdges());
		UF = new WeightedQuickUnion(graph.getNoOfVertices());
		this.noOfVertices = graph.getNoOfVertices();
		for(UndirectedEdge edge:graph.getAllEdges())
		{
			minHeap.insert(edge);
		}
		computeMST();
	}
	
	private void computeMST()
	{
		while(MSTQueue.size() != noOfVertices-1)
		{
			UndirectedEdge minEdge = minHeap.extractMin();
			int v = minEdge.getOneVertex();
			int w = minEdge.getOtherVertex(v);
			if(!UF.isConnected(v, w))
			{
				minHeap.deleteMin();
				UF.union(v, w);
				MSTQueue.enqueue(minEdge);
				MSTWeight = MSTWeight + minEdge.getWeight();
			}
			else
				minHeap.deleteMin();
		}
	}
	
	public Iterable<UndirectedEdge> getMSTEdges()
	{
		return MSTQueue;
	}
	
	public double getMSTWeigth()
	{
		return MSTWeight;
	}
	
	public static void main(String[] args)
	{
		UndirectedWeightedGraph graph = new UndirectedWeightedGraph(8);
		
		graph.addEdge(new UndirectedEdge(0, 2, 0.26));
		graph.addEdge(new UndirectedEdge(0, 4, 0.38));
		graph.addEdge(new UndirectedEdge(0, 6, 0.58));
		graph.addEdge(new UndirectedEdge(0, 7, 0.16));
		graph.addEdge(new UndirectedEdge(1, 2, 0.36));
		graph.addEdge(new UndirectedEdge(1, 3, 0.29));
		graph.addEdge(new UndirectedEdge(1, 5, 0.32));
		graph.addEdge(new UndirectedEdge(1, 7, 0.19));
		graph.addEdge(new UndirectedEdge(2, 3, 0.17));
		graph.addEdge(new UndirectedEdge(2, 6, 0.40));
		graph.addEdge(new UndirectedEdge(2, 7, 0.34));
		graph.addEdge(new UndirectedEdge(3, 6, 0.52));
		graph.addEdge(new UndirectedEdge(4, 5, 0.35));
		graph.addEdge(new UndirectedEdge(4, 6, 0.93));
		graph.addEdge(new UndirectedEdge(4, 7, 0.37));
		graph.addEdge(new UndirectedEdge(5, 7, 0.28));
		
		/*for(UndirectedEdge edge:graph.getConnectedEdges(7))
		{
			System.out.println(edge);
		}*/
		
		/*for(UndirectedEdge edge:graph.getAllEdges())
		{
			System.out.println(edge);
		}*/
		
		KruskalsMSTAlgorithm mst = new KruskalsMSTAlgorithm(graph);
		
		for(UndirectedEdge edge:mst.getMSTEdges())
		{
			System.out.println(edge);
		}
		
		System.out.println(mst.getMSTWeigth());
		
	}
	
	
}
