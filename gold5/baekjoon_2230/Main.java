package gold5.baekjoon_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);
		System.out.println(two_pointer());
	}

	private static int two_pointer() {
		int start = 0;
		int end = 1;
		int result = Integer.MAX_VALUE;

		while (end < numbers.length && start <= end) {
			int distance = numbers[end] - numbers[start];
			if (distance == M) {
				result = M;
				break;
			}
			if (distance >= M) {
				start++;
				result = Math.min(distance, result);
			} else {
				end++;
			}
		}
		return result;
	}
}
