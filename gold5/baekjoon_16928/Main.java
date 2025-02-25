package gold5.baekjoon_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Map<Integer, Integer> item = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());

		for (int i = 0; i < ladder + snake; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			item.put(from, to);
		}

		int result = bfs(1);
		System.out.println(result);
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101];

		queue.add(start);
		visited[start] = true;

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (cur == 100) return count;

				for (int dice = 1; dice <= 6; dice++) {
					int next = cur + dice;
					if (next > 100) continue;
					if (!visited[next]) {
						if (item.containsKey(next)) {
							queue.add(item.get(next));
							visited[item.get(next)] = true;
						} else {
							queue.add(next);
							visited[next] = true;
						}
					}
				}
			}
			count++;
		}
		return count;
	}
}