package Silver1.baekjoon_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int mid = 0; mid < N; mid++) {
			for (int start = 0; start < N; start++) {
//				if(start == mid) continue;
				for (int end = 0; end < N; end++) {
//					if(end == mid) continue;
					if (arr[start][mid] == 1 && arr[mid][end] == 1) {
						arr[start][end] = 1;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int num : arr[i]) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
