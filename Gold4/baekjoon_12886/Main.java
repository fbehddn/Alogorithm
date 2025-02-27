package Gold4.baekjoon_12886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B, C;
	static boolean[][] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		visited = new boolean[1501][1501];

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		if ((A + B + C) % 3 != 0) {
			System.out.println(result);
			return;
		}
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{A, B, C});
		visited[A][B] = true;
		visited[B][A] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
			if (a == b && b == c) {
				result = 1;
				return;
			}
			if (a != b) {
				int na = a > b ? a - b : a + a;
				int nb = b > a ? b - a : b + b;
				if (!visited[na][nb]) {
					queue.add(new int[]{na, nb, c});
					visited[na][nb] = true;
					visited[nb][na] = true;
				}

			}
			if (a != c) {
				int na = a > c ? a - c : a + a;
				int nc = c > a ? c - a : c + c;
				if (!visited[na][nc]) {
					queue.add(new int[]{na, b, nc});
					visited[na][nc] = true;
					visited[nc][na] = true;
				}
			}
			if (b != c) {
				int nb = b > c ? b - c : b + b;
				int nc = c > b ? c - b : c + c;
				if (!visited[nb][nc]) {
					queue.add(new int[]{a, nb, nc});
					visited[nb][nc] = true;
					visited[nc][nb] = true;
				}
			}
		}
	}
}
