package Sliver4.baekjoon_10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(sc.next());
			if(number!=0) {
				stack.push(number);
				result += number;
			}
			else {
				Integer pop = stack.pop();
				result -= pop;
			}
		}

		System.out.println(result);
	}
}
