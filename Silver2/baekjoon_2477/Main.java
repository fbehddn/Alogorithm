package Silver2.baekjoon_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int maxWidth, maxHeight, maxWidthIdx, maxHeightIdx;
	static int[] length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		length = new int[6];
		int countPerSize = Integer.parseInt(br.readLine());
		maxWidth = 0;
		maxHeight = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if (direction == 1 || direction == 2) {
				length[i] = len;
				if (len > maxWidth) {
					maxWidth = len;
					maxWidthIdx = i;
				}
			} else if (direction == 3 || direction == 4) {
				length[i] = len;
				if (len > maxHeight) {
					maxHeight = len;
					maxHeightIdx = i;
				}
			}
		}
		int total = getTotalSize(maxWidthIdx, maxHeightIdx);
		int blank = getBlankSize(maxWidthIdx, maxHeightIdx);
		int result = (total - blank) * countPerSize;

		System.out.println(result);
	}

	private static int getTotalSize(int maxRowIdx, int maxColIdx) {
		return length[maxRowIdx] * length[maxColIdx];
	}

	private static int getBlankSize(int maxRowIdx, int maxColIdx) {
		int heightA, heightB, widthA, widthB;

		if (maxRowIdx == 0) {
			heightA = length[1];
			heightB = length[length.length - 1];
		} else if (maxRowIdx == length.length - 1) {
			heightA = length[length.length - 2];
			heightB = length[0];
		} else {
			heightA = length[maxRowIdx - 1];
			heightB = length[maxRowIdx + 1];
		}
		if (maxColIdx == 0) {
			widthA = length[1];
			widthB = length[length.length - 1];
		} else if (maxColIdx == length.length - 1) {
			widthA = length[length.length - 2];
			widthB = length[0];
		} else {
			widthA = length[maxColIdx - 1];
			widthB = length[maxColIdx + 1];
		}

		return Math.abs(heightA - heightB) * Math.abs(widthA - widthB);
	}
}
