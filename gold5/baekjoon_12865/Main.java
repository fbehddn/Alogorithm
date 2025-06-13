package gold5.baekjoon_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] thing;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		thing = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			thing[i][0] = w;
			thing[i][1] = v;
		}

		dfs(0, 0, 0);
		System.out.println(result);
	}

	private static void dfs(int depth, int size, int value) {
		if (depth == N) {
			result = Math.max(result, value);
			return;
		}
		if (size + thing[depth][0] <= K) {
			dfs(depth + 1, size + thing[depth][0], value + thing[depth][1]);
		}
		dfs(depth + 1, size, value);
	}
}
