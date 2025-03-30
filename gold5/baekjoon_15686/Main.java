package gold5.baekjoon_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int size;
	static int chicken;
	static int curChicken;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		chicken = Integer.parseInt(st.nextToken());

		map = new int[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					curChicken++;
				}
			}
		}
		dfs(curChicken - chicken);
		System.out.println(result);
	}

	private static void dfs(int rest) {
		if (rest == 0) {
			int totalDist = bfs();
			if (totalDist < result) {
				result = totalDist;
			}
			return;
		}
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					dfs(rest - 1);
					map[i][j] = 2;
				}
			}
		}
	}

	private static int bfs() {
		int totalDist = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (map[i][j] == 1) {
					int dist = spread(new int[]{i, j});
					totalDist += dist;
				}
			}
		}
		return totalDist;
	}

	private static int spread(int[] arr) {
		int dist = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(arr);
		visited = new boolean[size + 1][size + 1];
		visited[arr[0]][arr[1]] = true;
		while (!queue.isEmpty()) {
			dist++;
			int level = queue.size();
			for (int k = 0; k < level; k++) {
				int[] poll = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = poll[0] + dx[i];
					int nextY = poll[1] + dy[i];
					if (nextX >= 1 && nextX <= size && nextY >= 1 && nextY <= size) {
						if (map[nextX][nextY] == 2) {
							return dist;
						} else if ((map[nextX][nextY] == 0 || map[nextX][nextY] == 1) && !visited[nextX][nextY]) {
							queue.add(new int[]{nextX, nextY});
							visited[nextX][nextY] = true;
						}
					}
				}
			}
		}
		return 0;
	}
}
