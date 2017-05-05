package sjy;

public class FindMaximumSubArray {
	private static class Data {
		public int max_left;
		public int max_right;
		public int max_sum;
		public Data(int max_left, int max_right, int max_sum) {
			this.max_left = max_left;
			this.max_right = max_right;
			this.max_sum = max_sum;
		}
		@Override
		public String toString() {
			return "[" + max_left + "," + max_right + "," + max_sum + "]";
		}
	}
	public static Data findMaxiumSubArray(int[] A, int low, int high) {
		if (low == high) {
			return new Data(low, high, A[low]);
		} else {
			int mid = (low + high) / 2;
			Data left = FindMaximumSubArray.findMaxiumSubArray(A, low, mid);
			Data right = FindMaximumSubArray.findMaxiumSubArray(A, mid + 1, high);
			Data cross = FindMaximumSubArray.findMaxCrossingSubarray(A, low, mid, high);
			if (left.max_sum >= right.max_sum && left.max_sum >= cross.max_sum) {
				return left;
			} else if (right.max_sum >= left.max_sum && right.max_sum >= cross.max_sum) {
				return right;
			} else {
				return cross;
			}
		}
	}
	public static Data findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
		int left_sum = Integer.MIN_VALUE;
		int max_left = 0;
		int sum = 0;
		for (int i = mid; i >= low; i --) {
			sum += A[i];
			if (sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}
		int right_sum = Integer.MIN_VALUE;
		int max_right = 0;
		int sum1 = 0;
		for (int i = mid + 1; i <= high; i ++) {
			sum1 += A[i];
			if (sum1 > right_sum) {
				right_sum = sum1;
				max_right = i;
			}
		}
		return new Data(max_left, max_right, left_sum + right_sum);
	}
	public static int[] convert(int[] A) {
		int[] re = new int[A.length];
		re[0] = 0;
		for (int i = 1; i < A.length; i ++) {
			re[i] = A[i] - A[i - 1];
		}
		return re;
	}
	public static void main(String[] args) {
		//More details in the page 38.
		int[] A = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
		A = FindMaximumSubArray.convert(A);
		System.out.println(FindMaximumSubArray.findMaxiumSubArray(A, 1, A.length - 1));
	}
}
