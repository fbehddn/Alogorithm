package Silver3.baekjoon_10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int idx = -1;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.printf("-1");
			return;
		}
		int j = 0;
		for (int i = arr.length - 1; i >= idx; i--) {
			if (arr[i] > arr[idx - 1]) {
				j = i;
				break;
			}
		}

		swap(idx - 1, j);
		sort(idx, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void sort(int start, int end) {
		while (start < end) {
			swap(start, end);
			start++;
			end--;
		}
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
