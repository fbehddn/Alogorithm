package Sliver4.baekjoon_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<Integer, Integer> map = new HashMap<>();

		int T = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			int number = Integer.parseInt(st.nextToken());
			map.put(number, map.getOrDefault(number, 0) + 1);
		}

		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			int query = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(query, 0)).append(" ");
		}

		System.out.println(sb);
	}
}
