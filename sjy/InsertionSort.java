package sjy;

public class InsertionSort {
	public <T extends Comparable<T>> void sort(T[] list) {
		for (int i = 1; i < list.length; i ++) {
			T item = list[i];
			int position = i;
			while (position > 0 && list[position - 1].compareTo(item) > 0) {
				list[position] = list[position - 1];
				position --;
			}
			list[position] = item;
		}
	}
}
