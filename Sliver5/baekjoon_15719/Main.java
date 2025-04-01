package Sliver5.baekjoon_15719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] numbers = new boolean[N + 1];

		int result = 0;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (numbers[number]) {
				result = number;
			}
			numbers[number] = true;
		}
		System.out.println(result);
	}
}
