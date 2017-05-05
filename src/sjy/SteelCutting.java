package sjy;

public class SteelCutting {
	private int[] price;
	public SteelCutting(int[] price) {
		this.price = price;
	}
	public int bottonUpCutRod(int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		for (int j = 1; j <= n; j ++) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i ++) {
				q = Math.max(q, price[i] + r[j - i]);
			}
			r[j] = q;
		}
		return r[n];
	}
	public static void main(String[] args) {
		int[] price = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		SteelCutting sc = new SteelCutting(price);
		System.out.println(sc.bottonUpCutRod(7));
	}
}
