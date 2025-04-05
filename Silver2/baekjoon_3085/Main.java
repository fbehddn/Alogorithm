package Silver2.baekjoon_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] colors;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				colors[i][j] = str.charAt(j);
			}
		}

		result = 0;
		function();
		System.out.println(result);
	}

	private static void function() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j < N - 1) {
					swap(i, j, i, j + 1);
					getMaxCount();
					swap(i, j + 1, i, j);

				}
				if (i < N - 1) {
					swap(i, j, i + 1, j);
					getMaxCount();
					swap(i + 1, j, i, j);
				}
			}
		}
		result = Math.max(result, getMaxCount());
	}

	public static void swap(int row1, int col1, int row2, int col2) {
		char temp = colors[row1][col1];
		colors[row1][col1] = colors[row2][col2];
		colors[row2][col2] = temp;
	}

	private static int getMaxCount() {
		int maxCount = 1;
		//row
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (colors[i][j] == colors[i][j + 1]) cnt++;
				else cnt = 1;
				maxCount = Math.max(maxCount, cnt);
			}
		}

		//세로
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (colors[j][i] == colors[j + 1][i]) cnt++;
				else cnt = 1;
				maxCount = Math.max(maxCount, cnt);
			}
		}
		return maxCount;
	}
}
