package Sliver5.baekjoon_1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[10];
		String[] str = br.readLine().split("");

		for (int i = 0; i < str.length; i++) {
			int need = Integer.parseInt(str[i]);
			if (need == 6 || need == 9) {
				if (numbers[6] >= numbers[9]) numbers[9]++;
				else numbers[6]++;
			} else{ numbers[need]++;}

		}
		int max = Integer.MIN_VALUE;
		for (int i : numbers) {
			if (i > max) max = i;
		}
		System.out.println(max);
	}
}
