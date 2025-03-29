package Silver3.baekjoon_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int weight = Integer.parseInt(st.nextToken());
				queue.add(new int[]{i, weight});
			}

			int cnt = 0;

			boolean isMax = false;
			while (!isMax) {
				int[] arr = queue.peek();
				int[] max = new int[]{arr[0], arr[1]};

				for (int i = 0; i < queue.size(); i++) {
					if (queue.get(i)[1] > max[1]) {
						max[0] = queue.get(i)[0];
						max[1] = queue.get(i)[1];
					}
				}

				int[] poll = queue.poll();
				if (poll[1] == max[1]) {
					cnt++;
					if (M == max[0]) {
						sb.append(cnt).append("\n");
						isMax = true;
					}
				} else if (poll[1] < max[1]) {
					queue.add(new int[]{poll[0], poll[1]});
				}
			}
		}
		System.out.println(sb);
	}
}
