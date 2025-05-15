package Gold4.baekjoon_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		for (int i = 0; i < N; i++) {
			int target = numbers[i];
			int left = 0;
			int right = numbers.length - 1;

			while (left < right) {
				if (left == i || right == i) {
					if (left == i) left++;
					else right--;
				} else {
					int sum = numbers[left] + numbers[right];
					if (sum > target) right--;
					else if (sum < target) left++;
					else {
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
