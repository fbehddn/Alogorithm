package Sliver4.baekjoon_1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long result = 0;
		for(int i = 1; i <= N; i++) {
			if(1<=i && i<=9) result += 1;
			else if (10<=i && i<=99) result += 2;
			else if (100<=i && i<=999) result += 3;
			else if (1000<=i && i<=9999) result += 4;
			else if (10000<=i && i<=99999) result += 5;
			else if (100000<=i && i<=999999) result += 6;
			else if (1000000<=i && i<=9999999) result += 7;
			else if (10000000<=i && i<=99999999) result += 8;
			else result += 9;
		}

		System.out.println(result);
	}
}
