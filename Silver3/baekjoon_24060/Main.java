package Silver3.baekjoon_24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int K;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = new int[Integer.parseInt(st.nextToken())];
		K = Integer.parseInt(st.nextToken());
		temp = new int[A.length];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(A, 0, A.length - 1);

		for (int i : A) {
			System.out.print(i + " ");
		}
	}

	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(A, start, mid, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				temp[t++] = a[i++];
			} else {
				temp[t++] = a[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = a[i++];
		}
		while (j <= end) {
			temp[t++] = a[j++];
		}

		for (int k = 0; k < t; k++) {
			a[start + k] = temp[k];
		}
	}
}
