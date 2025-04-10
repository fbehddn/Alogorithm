package Sliver5.baekjoon_2669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] visited = new boolean[101][101];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int colA = Integer.parseInt(st.nextToken());
			int rowA = Integer.parseInt(st.nextToken());
			int colB = Integer.parseInt(st.nextToken());
			int rowB = Integer.parseInt(st.nextToken());

			for (int r = rowA; r < rowB; r++) {
				for (int c = colA; c < colB; c++) {
					visited[r][c] = true;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (visited[i][j]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
