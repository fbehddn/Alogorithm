package gold5.baekjoon_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[][] map;
	static long result; // 경우의 수가 많을 수 있으므로 long 사용

	// 방향벡터: index 0 → 오른쪽, index 1 → 아래, index 2 → 대각선 (아래-오른쪽)
	static int[] dR = {0, 1, 1};
	static int[] dC = {1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];

		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기 상태: (0,0)-(0,1) (가로 상태)
		Node startNode = new Node(new int[]{0, 0}, new int[]{0, 1});
		bfs(startNode);
		System.out.println(result);
	}

	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int tailRow = curNode.tail[0];
			int tailCol = curNode.tail[1];
			int headRow = curNode.head[0];
			int headCol = curNode.head[1];

			// 머리가 도착점에 도달하면 경우의 수 증가
			if (headRow == size - 1 && headCol == size - 1) {
				result++;
				continue;
			}

			// 파이프 상태 판별:
			// 가로: tailRow == headRow && tailCol != headCol
			// 세로: tailCol == headCol && tailRow != headRow
			// 대각선: 그 외
			if (tailRow == headRow && tailCol != headCol) { // 가로 상태
				// 오른쪽 이동 (인덱스 0)
				int newRow = headRow + dR[0];
				int newCol = headCol + dC[0];
				if (newCol < size && map[headRow][headCol + 1] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
				// 대각선 이동 (인덱스 2)
				newRow = headRow + dR[2];
				newCol = headCol + dC[2];
				if (headRow + 1 < size && headCol + 1 < size &&
					map[headRow][headCol + 1] == 0 &&
					map[headRow + 1][headCol] == 0 &&
					map[headRow + 1][headCol + 1] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
			} else if (tailCol == headCol && tailRow != headRow) { // 세로 상태
				// 아래 이동 (인덱스 1)
				int newRow = headRow + dR[1];
				int newCol = headCol + dC[1];
				if (newRow < size && map[headRow + 1][headCol] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
				// 대각선 이동 (인덱스 2)
				newRow = headRow + dR[2];
				newCol = headCol + dC[2];
				if (headRow + 1 < size && headCol + 1 < size &&
					map[headRow][headCol + 1] == 0 &&
					map[headRow + 1][headCol] == 0 &&
					map[headRow + 1][headCol + 1] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
			} else { // 대각선 상태
				// 오른쪽 이동 (인덱스 0)
				int newRow = headRow + dR[0];
				int newCol = headCol + dC[0];
				if (newCol < size && map[headRow][headCol + 1] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
				// 아래 이동 (인덱스 1)
				newRow = headRow + dR[1];
				newCol = headCol + dC[1];
				if (newRow < size && map[headRow + 1][headCol] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
				// 대각선 이동 (인덱스 2)
				newRow = headRow + dR[2];
				newCol = headCol + dC[2];
				if (headRow + 1 < size && headCol + 1 < size &&
					map[headRow][headCol + 1] == 0 &&
					map[headRow + 1][headCol] == 0 &&
					map[headRow + 1][headCol + 1] == 0) {
					queue.add(new Node(new int[]{headRow, headCol}, new int[]{newRow, newCol}));
				}
			}
		}
	}
}

class Node {
	int[] tail;
	int[] head;

	public Node(int[] tail, int[] head) {
		this.tail = tail;
		this.head = head;
	}
}
