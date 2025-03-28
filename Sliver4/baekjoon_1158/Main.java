package Sliver4.baekjoon_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> circle = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			circle.add(i);
		}
		int idx = 0;
		while (!circle.isEmpty()) {
			idx = (idx + K - 1) % circle.size();
			sb.append(circle.get(idx));
			circle.remove(idx);
			if(!circle.isEmpty()) {
				sb.append(", ");
			}
		}
		System.out.println("<" + sb + ">");
	}
}
