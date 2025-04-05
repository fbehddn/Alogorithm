package Silver2.baekjoon_18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, block;
	static int maxHeight = 0;
	static int result = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		block = Integer.parseInt(st.nextToken());
		map = new int[r][c];

		int max = 0;
		int min = 256;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		for (int i = min; i <= max; i++) {
			checkBlock(i);
		}
		System.out.print(result + " " + maxHeight);
	}

	private static void checkBlock(int height) {
		int sec = 0;
		int b = block;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sec > result) return;

				if (map[i][j] < height) {
					int sub = height - map[i][j];
					sec += sub;
					b -= sub;
				} else if (map[i][j] > height) {
					int sub = map[i][j] - height;
					sec += sub * 2;
					b += sub;
				}
			}
		}
		if (b < 0) return;

		if (sec < result) {
			result = sec;
			maxHeight = height;
		} else if (sec == result && maxHeight < height) {
			maxHeight = height;
		}
	}
}
