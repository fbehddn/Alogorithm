package Gold4.baekjoon_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] copyMap;
	static int N, M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int area = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		installWall(3);
		System.out.println(area);
	}

	private static void installWall(int wall) {
		if (wall == 0) {
			spread();
			area = Math.max(getSafetyArea(), area);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					installWall(wall-1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static int getSafetyArea() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					temp++;
				}
			}
		}
		return temp;
	}

	private static void spread() {
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.offer(new int[]{i, j});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2;
						q.add(new int[]{nx, ny});
					}
				}
			}
		}
	}
}
