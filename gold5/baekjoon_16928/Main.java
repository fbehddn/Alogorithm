package gold5.baekjoon_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 또한 현재 내 위치에서 6칸을 실행하여, 사다리이고 뱀이 아니면 해당 칸으로 이동하고, 그렇지 않으면 6칸을 이동한다.(100 이하까지)
 */
public class Main {
	static Map<Integer, Integer> item = new HashMap<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		visited = new boolean[101];
		st = new StringTokenizer(br.readLine());
		int ledder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		for (int i = 0; i < ledder + snake; i++) {
			st = new StringTokenizer(br.readLine());
			item.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int result = bfs(1);
		System.out.println(result);
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
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