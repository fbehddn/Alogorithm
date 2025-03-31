package Sliver4.baekjoon_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<Integer> circle = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			circle.add(i);
		}

		int index = 0;
		while (!circle.isEmpty()) {
			index = (index + K - 1) % circle.size();
			sb.append(circle.get(index));
			circle.remove(index);
			if (!circle.isEmpty()) {
				sb.append(", ");
			}
		}
		System.out.println("<" + sb + ">");
	}
}
