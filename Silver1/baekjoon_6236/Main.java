package Silver1.baekjoon_6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 일수
		int M = Integer.parseInt(st.nextToken()); // 최대 인출 횟수
		int[] spend = new int[N];

		int low = 0;
		long high = 0;

		for (int i = 0; i < N; i++) {
			spend[i] = Integer.parseInt(br.readLine());
			low = Math.max(low, spend[i]);
			high += spend[i];
		}

		long answer = high;

		while (low <= high) {
			long mid = (low + high) / 2;
			if (countWithdraw(spend, mid) <= M) {
				answer = mid;
				high = mid - 1;
			} else {
				low = (int) mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static int countWithdraw(int[] spend, long k) {
		int count = 1;
		long cash = k;

		for (int s : spend) {
			if (cash < s) {
				count++;
				cash = k;
			}
			cash -= s;
		}
		return count;
	}
}
