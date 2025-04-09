package Silver2.baekjoon_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int height = 1; height <= N; height++) {
			int left = Integer.parseInt(st.nextToken());
			int count = 0;

			for (int i = 0; i < N; i++) {
				if (line[i] == 0) {
					if (count == left) {
						line[i] = height;
						break;
					}
					count++;
				}
			}
		}

		for (int h : line) {
			System.out.print(h + " ");
		}
	}
}
