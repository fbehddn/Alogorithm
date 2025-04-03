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
			if (arr[i] == 0) continue;
			for (int j = i; j <= N; j += i) {
				if (arr[j] != 0) {
					arr[j] = 0;
					K--;
					if (K == 0) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}
}
