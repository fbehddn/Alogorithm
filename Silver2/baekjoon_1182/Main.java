package Silver2.baekjoon_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, target, result;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;
		dfs(0,0);

		if(target==0){
			System.out.println(result-1);
			return;
		}
		System.out.println(result);
	}

	private static void dfs(int depth, int sum) {
		if(depth==N){
			if(sum==target) result++;
			return;
		}
		dfs(depth + 1, sum);
		dfs(depth + 1, sum + arr[depth]);
	}
}
