package sjy;

public class MergeSort {
	public <T extends Comparable<T>> void merge(T[] list, int p, int q, int r) {
		T[] listNew = list.clone();
		int i, j, k;
		for (i = p, j = q + 1, k = p; i <= q && j <= r; k ++) {
			if (list[i].compareTo(list[j]) > 0) {
				listNew[k] = list[j];
				j ++;
			} else {
				listNew[k] = list[i];
				i ++;
			}
		}
		if (i <= q) {
			for (; i <= q; i ++, k ++) {
				listNew[k] = list[i];
			}
		} else {
			for (; j <= r; j ++, k ++) {
				listNew[k] = list[j];
			}
		}
		for (int i0 = p; i0 <= r; i0 ++) {
			list[i0] = listNew[i0];
		}
	}
	public <T extends Comparable<T>> void sort(T[] list, int p, int q) {
		if (list == null || list.length <= 1 || p == q) {
			return;
		}
		int mid = (q + p) / 2;
		sort(list, p, mid);
		sort(list, mid + 1, q);
		merge(list, p, mid, q);
	}
}
