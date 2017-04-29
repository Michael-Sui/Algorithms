package sjy;

import java.util.Arrays;

public class HeapSort {
	private int heapSize;
	public int parent(int i) {
		return (int)Math.floor(i - 1 / 2);
	}
	public int left(int i) {
		return 2 * i + 1;
	}
	public int right(int i) {
		return 2 * i + 2;
	}
	public void maxHeapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l <= heapSize - 1 && A[l] > A[i]) {
			largest = l;	
		}
		if (r <= heapSize - 1 && A[r] > A[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(A, largest);
		}
	}
	public void buildMaxHeap(int[] A) {
		heapSize = A.length;
		for (int i = parent(heapSize - 1); i >= 0; i --) {
			maxHeapify(A, i);
		}
	}
	public void heapSort(int[] A) {
		buildMaxHeap(A);
		int step = 1;
		for (int i = A.length - 1; i > 0; i --) {
			int temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapSize --;
			System.out.println("Step" + (step ++) + ":" + Arrays.toString(A));
			maxHeapify(A, 0);
		}
	}
}
