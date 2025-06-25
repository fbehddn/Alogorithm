package Gold4.baekjoon_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int[][] map = new int[E][3];
		int[] parent = new int[V+1];

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(map, (a, b) -> a[2] - b[2]);

		int result = 0;
		for (int i = 0; i < E; i++) {
			int nodeA = map[i][0];
			int nodeB = map[i][1];
			int cost = map[i][2];
			if (findRoot(parent, nodeA) != findRoot(parent, nodeB)) {
				result += cost;
				union(parent, nodeA, nodeB);
			}
		}
		System.out.println(result);
	}

	private static void union(int[] parent, int nodeA, int nodeB) {
		int rootA = findRoot(parent, nodeA);
		int rootB = findRoot(parent, nodeB);
		if(rootA>rootB) parent[rootA] = rootB;
		else parent[rootB] = rootA;
	}

	private static int findRoot(int[] parent, int node) {
		if (parent[node] == node) return node;
		else return parent[node] = findRoot(parent, parent[node]);
	}
}
