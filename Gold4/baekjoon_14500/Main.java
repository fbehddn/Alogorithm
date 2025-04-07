package Gold4.baekjoon_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[][] blocks;
	static int result = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int block = 4;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		blocks = new int[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int sum = blocks[i][j];
				visited[i][j] = true;
				dfs(i, j, block - 1, sum);
			}
		}
		System.out.println(result);
	}

	private static void dfs(int row, int col, int block, int sum) {
		if (block == 0) {
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newRow = row + dx[i];
			int newCol = col + dy[i];
			if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c) {
				if (!visited[newRow][newCol]) {
					sum += blocks[newRow][newCol];
					visited[newRow][newCol] = true;
					block--;
					dfs(newRow, newCol, block, sum);
					block++;
					sum -= blocks[newRow][newCol];
					visited[newRow][newCol] = false;
				}
			}
		}
	}
}
