package Sliver5.baekjoon_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt((br.readLine()));
		int[][] hw = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				hw[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++){
			int rank = 1;
			for(int j=0; j<N; j++){
				if(i==j) continue;
				if(hw[i][0]< hw[j][0] && hw[i][1]< hw[j][1]) rank++;
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}
}
