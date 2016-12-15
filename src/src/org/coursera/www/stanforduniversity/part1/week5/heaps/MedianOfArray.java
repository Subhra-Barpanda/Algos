package org.coursera.www.stanforduniversity.part1.week5.heaps;

import org.coursera.www.princetonuniversity.part1.week4.priorityqueues.MaxPriorityQueueUsingBinaryHeapTree;
import org.coursera.www.princetonuniversity.part1.week4.priorityqueues.MinPriorityQueueUsingBinaryHeapTree;

public class MedianOfArray 
{
	private MaxPriorityQueueUsingBinaryHeapTree<Integer> maxHeap = null;
	private MinPriorityQueueUsingBinaryHeapTree<Integer> minHeap = null;
	
	public MedianOfArray(int size)
	{
		maxHeap = new MaxPriorityQueueUsingBinaryHeapTree<Integer>(size+1);
		minHeap = new MinPriorityQueueUsingBinaryHeapTree<Integer>(size+1);
	}
	
	private void maintainHeaps(int number)
	{
		int tempValue = 0;
		if(minHeap.size() > 0 && number <= minHeap.extractMin())
			maxHeap.insert(number);
		else if(maxHeap.size() > 0 && number >= maxHeap.extractMax())
			minHeap.insert(number);
		else
			maxHeap.insert(number);
		
		if(minHeap.size() - maxHeap.size() > 1)
		{
			tempValue = minHeap.extractMin();
			minHeap.deleteMin();
			maxHeap.insert(tempValue);
		}
		else if(maxHeap.size() - minHeap.size() > 1)
		{
			tempValue = maxHeap.extractMax();
			maxHeap.deleteMax();
			minHeap.insert(tempValue);
		}	
	}
	
	public void getMedian(int[] inputArray)
	{
		for(int i=0;i<inputArray.length;i++)
		{
			maintainHeaps(inputArray[i]);
			if(maxHeap.size() > minHeap.size())
				System.out.println("Median is : "+maxHeap.extractMax());
			else if(minHeap.size() > maxHeap.size())
				System.out.println("Median is : "+minHeap.extractMin());
			else
				System.out.println("Median is : "+ maxHeap.extractMax() + " , "+ minHeap.extractMin());
		}
		
		StringBuilder result = new StringBuilder();
		for(Integer i:maxHeap)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println("MaxHeap is :" + (result.substring(0,result.length()-2)).toString());
		
		result = new StringBuilder();
		for(Integer i:minHeap)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println(("MinHeap is :" + result.substring(0,result.length()-2)).toString());
	}
	
	public static void main(String a[])
	{
		int[] input = new int[]{11,7,6,4,2,1,0};
		MedianOfArray newObj = new MedianOfArray(input.length);
		newObj.getMedian(input);
	}
}
