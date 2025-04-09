package Sliver5.baekjoon_8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] rank = new int[N + 1];
		int[][] medal = new int[N + 1][5];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 4; j++) {
				medal[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (medal[i][2] < medal[j][2]) rank[medal[i][1]]++;
				else if (medal[i][2] == medal[j][2]) {
					if (medal[i][3] < medal[j][3]) rank[medal[i][1]]++;
					else if (medal[i][3] == medal[j][3]) {
						if (medal[i][4] < medal[j][4]) rank[medal[i][1]]++;
					}
				}
			}
		}
		System.out.println(rank[M] + 1);
	}
}
