package Gold4.baekjoon_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, apple, L;
	static int[][] map; //사과 -> 1, 뱀 -> 2
	static HashMap<Integer, Character> direction;
	static Queue<int[]> tail;
	static int sec = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apple = Integer.parseInt(br.readLine());

		map = new int[N][N];
		direction = new HashMap<>();
		tail = new LinkedList<>();

		StringTokenizer st;
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row - 1][col - 1] = 1; //사과 위치
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			direction.put(sec, ch);
		}
		map[0][0] = 2;
		tail.add(new int[]{0, 0});
		start(0, 0, 0);
		System.out.println(sec);
	}

	private static void start(int row, int col, int beforeHead) {
		int newHead = checkDirection(beforeHead);
		sec++;

		int nextRow = 0;
		int nextCol = 0;
		if (newHead == 0) {
			nextRow = row;
			nextCol = col + 1;
		} else if (newHead == 1) {
			nextRow = row + 1;
			nextCol = col;
		} else if (newHead == 2) {
			nextRow = row;
			nextCol = col - 1;
		} else if (newHead == 3) {
			nextRow = row - 1;
			nextCol = col;
		}

		if (!checkCanMove(nextRow, nextCol)) {
			return;
		} else {
			move(nextRow, nextCol);
		}
		start(nextRow, nextCol, newHead);
	}

	private static int checkDirection(int beforeHead) {
		if (direction.containsKey(sec))
			return changeDirection(beforeHead, direction.get(sec));
		return beforeHead;
	}

	private static int changeDirection(int beforeHead, char direction) {
		// 0 오른쪽, 1 아래, 2 왼쪽, 3 위
		int newHead = beforeHead;
		if (beforeHead == 0) {
			if (direction == 'D') {
				newHead = 1;
			} else if (direction == 'L') {
				newHead = 3;
			}
		} else if (beforeHead == 1) {
			if (direction == 'D') {
				newHead = 2;
			} else if (direction == 'L') {
				newHead = 0;
			}
		} else if (beforeHead == 2) {
			if (direction == 'D') {
				newHead = 3;
			} else if (direction == 'L') {
				newHead = 1;
			}
		} else if (beforeHead == 3) {
			if (direction == 'D') {
				newHead = 0;
			} else if (direction == 'L') {
				newHead = 2;
			}
		}
		return newHead;
	}

	private static boolean checkCanMove(int nextRow, int nextCol) {
		if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
			return false;
		} else if (map[nextRow][nextCol] == 2) {
			return false;
		}
		return true;
	}

	private static void move(int nextRow, int nextCol) {
		tail.add(new int[]{nextRow, nextCol});
		if (map[nextRow][nextCol] != 1) {
			int[] poll = tail.poll();
			int tailRow = poll[0];
			int tailCol = poll[1];
			map[tailRow][tailCol] = 0;
		}
		map[nextRow][nextCol] = 2;
	}
}