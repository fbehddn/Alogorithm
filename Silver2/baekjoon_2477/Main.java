package Silver2.baekjoon_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int maxRow, maxCol, maxRowIdx, maxColIdx;
	static int[] length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		length = new int[6];
		int countPerSize = Integer.parseInt(br.readLine());
		maxRow = 0;
		maxCol = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if (direction == 1 || direction == 2) {
				length[i] = len;
				if (len > maxRow) {
					maxRow = len;
					maxRowIdx = i;
				}
			} else if (direction == 3 || direction == 4) {
				length[i] = len;
				if (len > maxCol) {
					maxCol = len;
					maxColIdx = i;
				}
			}
		}
		int total = getTotalSize(maxRowIdx, maxColIdx);
		int blank = getBlankSize(maxRowIdx, maxColIdx);
		int result = (total - blank) * countPerSize;

		System.out.println(result);
	}

	private static int getTotalSize(int maxRowIdx, int maxColIdx) {
		return length[maxRowIdx] * length[maxColIdx];
	}

	private static int getBlankSize(int maxRowIdx, int maxColIdx) {
		int colA = 0;
		int colB = 0;
		int rowA = 0;
		int rowB = 0;

		if (maxRowIdx == 0) {
			colA = length[1];
			colB = length[length.length - 1];
		} else if (maxRowIdx == length.length - 1) {
			colA = length[length.length - 2];
			colB = length[0];
		} else {
			colA = length[maxRowIdx - 1];
			colB = length[maxRowIdx + 1];
		}
		if (maxColIdx == 0) {
			rowA = length[1];
			rowB = length[length.length - 1];
		} else if (maxColIdx == length.length - 1) {
			rowA = length[length.length - 2];
			rowB = length[0];
		} else {
			rowA = length[maxColIdx - 1];
			rowB = length[maxColIdx + 1];
		}

		return Math.abs(colA - colB) * Math.abs(rowA - rowB);
	}
}
