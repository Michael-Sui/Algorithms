package sjy;

public class CountSort {
	public void countSort(int[] A, int[] B, int k) {
		int[] C = new int[k + 1];
		for (int i = 0; i <= k; i ++) {
			C[i] = 0;
		}
		for (int j = 0; j < A.length; j ++) {
			C[A[j]] ++;
		}
		for (int i = 1; i < C.length; i ++) {
			C[i] += C[i - 1];
		}
		for (int j = A.length - 1; j >= 0; j --) {
			B[C[A[j]] - 1] = A[j];
			C[A[j]] --;
		}
	}
}
