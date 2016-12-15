package org.coursera.www.princetonuniversity.part2.week2.minimumspanningtrees;

public class UndirectedEdge implements Comparable<UndirectedEdge>
{
	private int v,w;
	private double weight;
	
	public UndirectedEdge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int getOneVertex()
	{
		return v;
	}
	
	public int getOtherVertex(int vertex)
	{
		if(vertex == v)
			return w;
		
		return v;
	}

	@Override
	public int compareTo(UndirectedEdge edge) {
		
		if(this.weight > edge.weight)
			return 1;
		else if(this.weight < edge.weight)
			return -1;
		else
			return 0;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(v).append("--").append(w).append(" has weight ").append(weight);
		return result.toString();
	}

}
