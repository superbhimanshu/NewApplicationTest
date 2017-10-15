package com.test.heap.practice;

public class HeapPractice {

	public static void main(String[] args) {

	}

	
	static class MaxHeap {
		
		int maxSize;
		int size;
		int[] maxHeap;
		static final int Front = 1;
		
		public MaxHeap(int size){
			maxSize = size;
			this.size =0;
			maxHeap = new int[maxSize];
			maxHeap[0]= Integer.MAX_VALUE;
		}
		
		public int parent(int pos){
			return pos/2;
		}
		public int leftChild(int pos){
			return 2*pos;
		}
		public int rightChild(int pos){
			return 2*pos+1;
		}
		
		public void swap(int fpos, int spos){
			int temp = maxHeap[fpos];
			maxHeap[fpos] = maxHeap[spos];
			maxHeap[spos] = temp;
		}
		
		public void insert (int val){
			if(size < maxSize){
				maxHeap[++size] = val;
				int pos = size;
				while(maxHeap[parent(pos)] < maxHeap[pos]){
					swap(parent(pos), pos);
					pos = parent(pos);
				}
				
			}
		}
		
		public boolean isLeaf(int pos){
			if(pos>=size/2 && pos<=size){
				return true;
			}
			return false;
		}
		
		public void remove() {
			int popped = maxHeap[Front];
			maxHeap[Front] = maxHeap[size];
			size--;
			maxifyHeap(Front);
		}
		
		public void maxifyHeap(int pos){
			if(!isLeaf(pos)){
				if((maxHeap[leftChild(pos)] > maxHeap[pos]) && (maxHeap[leftChild(pos)] > maxHeap[rightChild(pos)])){
					swap(pos, leftChild(pos));
					maxifyHeap(leftChild(pos));
				}else if((maxHeap[rightChild(pos)] > maxHeap[pos]) && (maxHeap[rightChild(pos)] > maxHeap[leftChild(pos)])){
					swap(pos,rightChild(pos));
					maxifyHeap(rightChild(pos));
				}
				
			}
		}
	}
}
