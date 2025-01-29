package Silver3.baekjoon_24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int[] temp;
	static int cnt = 0;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		K = Integer.parseInt(st.nextToken());
		temp = new int[size];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, arr.length - 1);

		System.out.println(result);
	}

	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
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

		t=0;
		i = start;

		while(i <= end) {
			cnt++;
			if (cnt == K) {
				result = temp[t];
				break;
			}
			a[i++] = temp[t++];
		}
	}
}
