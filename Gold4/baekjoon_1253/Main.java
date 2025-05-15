package Gold4.baekjoon_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] numbers;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		for (int i = 0; i < N; i++) {
			int target = numbers[i];
			int left = 0;
			int right = numbers.length - 1;
			function(left, right, target, i);
		}
		System.out.println(result);
	}

	private static void function(int left, int right, int target, int targetIdx) {
		if (left == targetIdx) left++;
		if (right == targetIdx) right--;
		if (left == right) return;

		if (numbers[left] + numbers[right] > target) {
			right--;
			function(left, right, target, targetIdx);
		} else if (numbers[left] + numbers[right] < target) {
			left++;
			function(left, right, target, targetIdx);
		} else result++;
	}
}
