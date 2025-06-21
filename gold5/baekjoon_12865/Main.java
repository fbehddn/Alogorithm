package gold5.baekjoon_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] thing;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		thing = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			thing[i][0] = w;
			thing[i][1] = v;
		}
		/**
		 * weigh, value
		 */
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= K; k++) {
				int itemWeight = thing[i][0];
				if (itemWeight > k) dp[i][k] = dp[i - 1][k];
				else {
					dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - itemWeight] + thing[i][1]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}
