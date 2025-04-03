package Sliver4.baekjoon_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= N; i++) {
			if (isSosu(i)) {
				for (int j = 1; j <= N; j++) {
					int num = i * j;
					if (num < arr.length && arr[num] != 0) {
						arr[num] = 0;
						K--;
						if (K == 0) {
							System.out.println(num);
							return;
						}
					}
				}
			}
		}
	}

	private static boolean isSosu(int num) {
		if (num == 0) return false;

		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) count++;
		}
		return count == 2;
	}
}
