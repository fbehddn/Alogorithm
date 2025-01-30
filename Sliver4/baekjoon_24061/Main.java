package Sliver4.baekjoon_24061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int[] result;
	static int[] temp;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		temp = new int[size];
		result = new int[size];
		K = Integer.parseInt(st.nextToken());

		StringTokenizer numbers = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(numbers.nextToken());
		}

		mergeSort(arr, 0, arr.length - 1);
		if (cnt < K) {
			System.out.println("-1");
		} else {
			for (int i : result) {
				System.out.print(i + " ");
			}
		}
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int i = start, j = mid + 1;
		int k = 0;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= end) {
			temp[k++] = arr[j++];
		}

		i = start;
		k = 0;
		while (i <= end) {
			cnt++;
			arr[i++] = temp[k++];
			if (cnt == K) {
				for (int q = 0; q < arr.length; q++) {
					result[q] = arr[q];
				}
				break;
			}
		}
	}
}
