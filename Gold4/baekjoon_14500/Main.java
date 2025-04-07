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
				visited[i][j] = true;
				dfs(i, j, blocks[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(result);
	}

	private static void dfs(int row, int col, int sum, int depth) {
		if (depth == 4) {
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newRow = row + dx[i];
			int newCol = col + dy[i];
			if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c) {
				if (!visited[newRow][newCol]) {
					if (depth == 2) {
						visited[newRow][newCol] = true;
						dfs(row, col, sum + blocks[newRow][newCol], depth + 1);
						visited[newRow][newCol] = false;
					}
					visited[newRow][newCol] = true;
					dfs(newRow, newCol, sum + blocks[newRow][newCol], depth + 1);
					visited[newRow][newCol] = false;
				}
			}
		}
	}
}
