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
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		int j = arr.length - 1;
		while (j > 0 && arr[j] <= arr[i - 1]) {
			j--;
		}
		swap(i - 1, j);
		reverse(i, arr.length - 1);
		for (int i1 : arr) {
			System.out.print(i1 + " ");
		}
	}

	private static void reverse(int start, int end) {
		while(start < end) {
			swap(start++, end--);
		}
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
