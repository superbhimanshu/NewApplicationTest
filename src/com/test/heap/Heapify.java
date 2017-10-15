package com.test.heap;

public class Heapify {

	public static int N = 5;
    public static void main(String...arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
 
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
	
	static class MaxHeap{
		
		int[] maxHeap;
		int size;
		int maxSize;
		public static final int FRONT = 1;
		public  MaxHeap(int max){
			this.maxSize = max;
			maxHeap = new int[this.maxSize + 1];
			size=0;
			maxHeap[0] = Integer.MAX_VALUE;
		}
		
		private int parentPos(int pos){
			return pos/2;
		}
		
		private int leftChildPos(int pos){
			
			return 2*pos;
		}
		
		private int rightChildPos(int pos){
			return 2*pos+1;
		}
		
		private boolean isLeaf(int pos){
			if(pos>=size/2 && pos<=size){
				return true;
			}
			return false;
		}
		
		private void swap(int fpos, int spos){
			int tmp;
			tmp = maxHeap[fpos];
			maxHeap[fpos] = maxHeap[spos];
			maxHeap[spos] = tmp;
		}
		
		public void insert(int value) {
			
			if(size<maxSize){
				maxHeap[++size] = value;
				int current = size;
				while(maxHeap[current] > maxHeap[parentPos(current)]){
					swap(current, parentPos(current));
					current = parentPos(current);
				}
			}
		}
		
		private void maxHeapify(int pos) {
			if(!isLeaf(pos)){
				if(maxHeap[pos]<maxHeap[leftChildPos(pos)] || maxHeap[pos] < maxHeap[rightChildPos(pos)]){
					if(maxHeap[leftChildPos(pos)] > maxHeap[rightChildPos(pos)]){
						swap(pos,leftChildPos(pos));
						maxHeapify(leftChildPos(pos));
					}else {
						swap(pos, rightChildPos(pos));
						maxHeapify(rightChildPos(pos));
					}
				}
			}
		}
		
		public void print(){
			for(int i=1;i<=size/2;i++){
				System.out.print(" PARENT : " + maxHeap[i] + " LEFT CHILD : " + maxHeap[2*i]
		                  + " RIGHT CHILD :" + maxHeap[2 * i  + 1]);
				System.out.println();
			}
		}
		
		public int remove(){
			int popped = maxHeap[FRONT];
			maxHeap[FRONT] = maxHeap[size--];
			maxHeapify(FRONT);
			return popped;
		}
		
	    public void maxHeap()
	    {
	        for (int pos = (size / 2); pos >= 1; pos--)
	        {
	            maxHeapify(pos);
	        }
	    }
	}

}
