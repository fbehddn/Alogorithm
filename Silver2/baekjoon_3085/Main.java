package Silver2.baekjoon_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] colors;
	static int result;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors = new char[N][N];
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				colors[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != N - 1) {
					if (colors[i][j] != colors[i][j + 1]) {
						queue.add(new Point(new int[]{i, j}, new int[]{i, j + 1}));
					}
				}
				if (i != 0) {
					if (colors[i][j] != colors[i - 1][j]) {
						queue.add(new Point(new int[]{i, j}, new int[]{i - 1, j}));
					}
				}
			}
		}
		result = 0;
		swap();
		System.out.println(result);
	}

	private static void swap() {
		while (!queue.isEmpty()) {
			char[][] charArr = new char[N][N];
			for (int i = 0; i < N; i++) {
				charArr[i] = Arrays.copyOf(colors[i], N);
			}
			Point point = queue.poll();
			int[] point1 = point.start;
			int[] point2 = point.end;
			char temp = charArr[point1[0]][point1[1]];
			charArr[point1[0]][point1[1]] = charArr[point2[0]][point2[1]];
			charArr[point2[0]][point2[1]] = temp;
			result = Math.max(result, getResult(charArr));
		}
	}

	private static int getResult(char[][] arr) {
		int result = 1;

		//row
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (j != N - 1) {
					if (arr[i][j] == arr[i][j + 1]) cnt++;
					else {
						result = Math.max(result, cnt);
						cnt = 1;
					}
				}
			}
			result = Math.max(result, cnt);
		}

		//세로
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (j != N - 1) {
					if (arr[j][i] == arr[j + 1][i]) cnt++;
					else {
						result = Math.max(result, cnt);
						cnt = 1;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		return result;
	}
}

class Point {
	int[] start, end;

	public Point(int[] start, int[] end) {
		this.start = start;
		this.end = end;
	}
}
