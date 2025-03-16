package Silver1.baekjoon_1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());  // 인원 수
		M = Integer.parseInt(st.nextToken());  // 친구 관계 수

		friends = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}

		int minSum = Integer.MAX_VALUE;
		int person = -1;

		for (int i = 1; i <= N; i++) {
			int sum = bfs(i);
			if (sum < minSum) {
				minSum = sum;
				person = i;
			}
		}

		System.out.println(person);
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : friends[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[cur] + 1;
					queue.add(next);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += dist[i];
		}
		return sum;
	}
}
