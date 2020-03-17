/**
 * 線形探索
 * 2020/01/27 作成
 */
public class ArgoSearchLinear {
	public static int search(int[] data, int target) {
		int ret = 0;
		while (data[ret] != target) {
			ret ++;
		}
    return ret;
	}
	public static void main(String[] args) {
		int[] data = {
			14, 67, 2, 3, 64
		};
		System.out.println(search(data,64));
	}
}
