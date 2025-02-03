package Sliver5.baekjoon_10815;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;


		int N = Integer.parseInt(br.readLine());
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}


		int M = Integer.parseInt(br.readLine());
		int[] numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		for (int i = 0; i < numbers.length; i++) {
			sb.append(binarySearch(numbers[i])).append(" ");
		}

		System.out.println(sb);
	}

	private static int binarySearch(int target) {
		int start = 0, end = cards.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == cards[mid]) {
				return 1;
			} else if (target < cards[mid]) {
				end = mid - 1;
			} else if (target > cards[mid]) {
				start = mid + 1;
			}
		}
		return 0;
	}
}
