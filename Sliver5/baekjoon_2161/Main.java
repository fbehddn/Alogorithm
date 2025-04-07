package Sliver5.baekjoon_2161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			queue.addLast(i);
		}
		while (queue.size() > 1) {
			result.add(queue.pollFirst());
			queue.addLast(queue.pollFirst());
		}
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.print(queue.poll());
	}
}
