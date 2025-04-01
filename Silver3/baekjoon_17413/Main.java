package Silver3.baekjoon_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();

		boolean inner = false;
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append('<');
				inner = true;
			} else if (command.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(' ');
			} else if (command.charAt(i) == '>') {
				result.append('>');
				inner = false;
			} else {
				if (inner) {
					result.append(command.charAt(i));
				} else {
					stack.push(command.charAt(i));
				}
			}
		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		System.out.println(result);
	}
}
