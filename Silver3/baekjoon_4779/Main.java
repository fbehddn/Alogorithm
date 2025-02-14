package Silver3.baekjoon_4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) {
			int len = (int) Math.pow(3, Integer.parseInt(str));
			answer = new StringBuilder();
			for (int i = 0; i < len; i++) {
				answer.append("-");
			}
			recursive(0, len);
			System.out.println(answer);
		}
	}

	private static void recursive(int start, int size) {
		if (size == 1) return;
		int newSize = size / 3;
		for (int i = start + newSize; i < start + newSize * 2; i++) {
			answer.setCharAt(i, ' ');
		}
		recursive(start, newSize);
		recursive(start + newSize * 2, newSize);
	}
}
