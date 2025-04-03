package Sliver4.baekjoon_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] button;
	static int[][] students; //성별, 버튼

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		button = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		students = new int[N][2];
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < S; i++) {
			if (students[i][0] == 1) {
				int b = students[i][1];
				for (int j = 1; j < button.length; j++) {
					if (checkMult(b, j)) {
						if (button[j] == 0) {
							button[j] = 1;
						} else button[j] = 0;
					}
				}
			} else if (students[i][0] == 2) {
				int b = students[i][1];
				if (button[b] == 0) {
					button[b] = 1;
				} else button[b] = 0;
				int count = 1;
				checkSame(b, count);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (i!=1 && i % 20 == 1) sb.append("\n");
			sb.append(button[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void checkSame(int b, int count) {
		int left = b - count;
		int right = b + count;
		if (left >= 1 && right <= N) {
			if (button[left] == button[right]) {
				if (button[left] == 0) {
					button[left] = 1;
				} else button[left] = 0;
				if (button[right] == 0) {
					button[right] = 1;
				} else button[right] = 0;
				checkSame(b, count + 1);
			}
		}
	}

	private static boolean checkMult(int b, int idx) {
		return idx % b == 0;
	}
}
