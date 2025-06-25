package Gold4.baekjoon_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0;
		int sum = arr[left];
		int minlen = Integer.MAX_VALUE;
		while (right <= N - 1) {
			if (sum >= target) {
				if (right - left < minlen) minlen = right - left;
				sum -= arr[left];
				left++;
			} else {
				right++;
				if (right <= N - 1) {
					sum += arr[right];
				}
			}
		}
		if (minlen == Integer.MAX_VALUE) {
			System.out.println("0");
		} else System.out.println(minlen+1);
	}
}
