package Sliver5.baekjoon_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		command += ".";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'X') {
				stack.push(i);
			} else if (command.charAt(i) == '.') {
				while (!stack.isEmpty()) {
					if (stack.size() % 2 == 0) {
						if (stack.size() >= 4) {
							stack.pop();
							stack.pop();
							stack.pop();
							stack.pop();
							sb.append("AAAA");

						} else if (stack.size() == 2) {
							stack.pop();
							stack.pop();
							sb.append("BB");
						}
					} else {
						System.out.println(-1);
						return;
					}
				}
				if (i != command.length() - 1) {
					sb.append('.');
				}
			}
		}
		System.out.println(sb);
	}
}
