package Bronze2.baekjoon_10870;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int result = fibo(n);
		System.out.println(result);
	}

	private static int fibo(int n) {
		if (n == 1) return 1;
		else if (n == 0) return 0;
		else return fibo(n - 1) + fibo(n - 2);
	}
}
