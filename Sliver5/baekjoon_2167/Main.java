package Sliver5.baekjoon_2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int r, c;
	static int[][] numbers;
	static int[][] memo;
	static int T;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		numbers = new int[r + 1][c + 1];
		memo = new int[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + numbers[i][j];
			}
		}

		T = Integer.parseInt(br.readLine());
		sum(T);
		System.out.println(sb);
	}

	private static void sum(int t) throws IOException {
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int sum = memo[endR][endC] - memo[startR - 1][endC] - memo[endR][startC - 1] + memo[startR - 1][startC - 1];
			sb.append(sum).append("\n");
		}
	}
}
