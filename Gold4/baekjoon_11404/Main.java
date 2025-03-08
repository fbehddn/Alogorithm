package Gold4.baekjoon_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int city, bus;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		city = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());

		result = new int[city + 1][city + 1];

		for (int i = 1; i <= city; i++) {
			for (int j = 1; j <= city; j++) {
				if (i == j) result[i][j] = 0;
				else result[i][j] = 10_000_001;
			}
		}

		for (int i = 0; i < bus; i++) {
			st = new StringTokenizer(br.readLine());
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (result[city1][city2] > cost) result[city1][city2] = cost;

		}

		for (int exchange = 1; exchange <= city; exchange++) {
			for (int start = 1; start <= city; start++) {
				for (int end = 1; end <= city; end++) {
					if (result[start][end] > result[start][exchange] + result[exchange][end]) {
						result[start][end] = result[start][exchange] + result[exchange][end];
					}
				}
			}
		}

		for (int i = 1; i <= city; i++) {
			for (int j = 1; j <= city; j++) {
				if (result[i][j] == 10_000_001) System.out.print(0 + " ");
				else System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
