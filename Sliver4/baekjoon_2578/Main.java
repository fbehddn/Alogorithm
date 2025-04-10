package Sliver4.baekjoon_2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] chulsoo;
	static int[][] repoter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		chulsoo = new int[5][5];
		repoter = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				chulsoo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				repoter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result++;
				int number = repoter[i][j];
				findChulsoo(number);
				if (bingo()){
					System.out.println(result);
					return;
				};
			}
		}
	}

	private static boolean bingo() {
		int cnt = 0;

		//row
		for (int i = 0; i < 5; i++) {
			int check = 0;
			for (int j = 0; j < 5; j++) {
				if (chulsoo[i][j] == 0) check++;
			}
			if (check == 5) cnt++;
			if (cnt >=3) return true;
		}

		//col
		for (int i = 0; i < 5; i++) {
			int check = 0;
			for (int j = 0; j < 5; j++) {
				if (chulsoo[j][i] == 0) check++;
			}
			if (check == 5) cnt++;
			if (cnt >= 3) return true;
		}

		// '\'
		if (chulsoo[0][0] == 0 && chulsoo[1][1] == 0 && chulsoo[2][2] == 0
			&& chulsoo[3][3] == 0 && chulsoo[4][4] == 0) {
			cnt++;
			if (cnt >= 3) return true;
		}

		// '/'
		if (chulsoo[0][4] == 0 && chulsoo[1][3] == 0 && chulsoo[2][2] == 0
			&& chulsoo[3][1] == 0 && chulsoo[4][0] == 0) {
			cnt++;
			if (cnt >= 3) return true;
		}
		return false;
	}

	private static void findChulsoo(int number) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (chulsoo[i][j] == number) {
					chulsoo[i][j] = 0;
					return;
				}
			}
		}
	}
}
