package Silver1.baekjoon_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, length, weight;
	static Queue<int[]> bridge;
	static Queue<int[]> wait; //weight, current
	static int sec = 0;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());
		bridge = new LinkedList<>();
		wait = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			wait.add(new int[]{Integer.parseInt(st.nextToken()), 0});
		}

		while (!wait.isEmpty() || !bridge.isEmpty()) {
			sec++;

			for (int[] car : bridge) {
				car[1]++;
			}

			if (!bridge.isEmpty() && bridge.peek()[1] > length) {
				sum -= bridge.poll()[0];
			}

			if (!wait.isEmpty() && wait.peek()[0] + sum <= weight) {
				int[] next = wait.poll();
				next[1]++;
				sum += next[0];
				bridge.add(next);
			}
		}
		System.out.println(sec);
	}
}
