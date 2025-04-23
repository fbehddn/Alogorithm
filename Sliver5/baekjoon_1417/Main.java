package Sliver5.baekjoon_1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}
		int[] vote = new int[N];
		for (int i = 0; i < N; i++) {
			vote[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;

		while (true) {
			int max = 0;
			int idx = -1;
			for (int i = 1; i < vote.length; i++) {
				if (max < vote[i]) {
					max = vote[i];
					idx = i;
				}
			}
			if (vote[0] > max) break;
			vote[idx]--;
			vote[0]++;
			result++;
		}
		System.out.println(result);
	}
}
