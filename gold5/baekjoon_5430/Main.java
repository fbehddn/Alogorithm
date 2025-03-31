package gold5.baekjoon_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String command = br.readLine();
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			deque = new ArrayDeque<>();

			for (int i = 0; i < size; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			AC(command, deque);
		}
		System.out.println(result);
	}

	private static void AC(String command, ArrayDeque<Integer> deque) {
		boolean direction = true; // true -> idx:0 가리키고 있음
		for (char cmd : command.toCharArray()) {
			if (cmd == 'R') {
				direction = !direction;
			} else if (cmd == 'D') {
				if (deque.isEmpty()) {
					result.append("error\n");
					return;
				}
				if(direction) {
					deque.pollFirst();
				} else deque.pollLast();
			}
		}
		makePrint(deque, direction);
	}

	private static void makePrint(ArrayDeque<Integer> deque, boolean direction) {
		result.append("[");
		if (!deque.isEmpty()) {
			if (direction) {
				result.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					result.append(',').append(deque.pollFirst());
				}
			} else {
				result.append(deque.pollLast());
				while (!deque.isEmpty()) {
					result.append(',').append(deque.pollLast());
				}
			}
		}
		result.append("]").append("\n");
	}
}
