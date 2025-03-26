package Sliver5.baekjoon_1193;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int floor = 1;
		int temp = 1;
		while (x > 0) {
			if (x - temp > 0) {
				x -= temp;
				temp++;
				floor++;
			}else break;
		}

		int sum = floor + 1;
		if (floor % 2 == 0) {
			int mother = floor+1;
			for (int i = 0; i < x; i++) {
				mother--;
			}
			System.out.println(sum - mother + "/" + mother);
		} else {
			int mother = 0;
			for (int i = 0; i < x; i++) {
				mother++;
			}
			System.out.println(sum - mother + "/" + mother);
		}
	}
}
