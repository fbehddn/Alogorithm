package Silver1.baekjoon_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());
		Queue<Integer> bridge = new LinkedList<>();
		Queue<Integer> wait = new LinkedList<>();
		int sec = 0;
		int bridgeWeight = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			wait.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < length; i++) {
			bridge.add(0);
		}

		while (!bridge.isEmpty()) {
			sec++;
			bridgeWeight -= bridge.poll();

			if (!wait.isEmpty()) {
				if (wait.peek() + bridgeWeight <= weight) {
					int truck = wait.poll();
					bridgeWeight += truck;
					bridge.add(truck);
				} else bridge.add(0);
			}
		}
		System.out.println(sec);
	}
}
