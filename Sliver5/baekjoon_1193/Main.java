package Sliver5.baekjoon_1193;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int floor = 1;

		while (x - floor > 0) {
			x -= floor;
			floor++;
		}

		int sum = floor + 1;

		int son, mother;

		if (floor % 2 == 0) {
			son = x;
			mother = sum - x;
		} else {
			son = sum - x;
			mother = x;
		}
		System.out.println(son+"/"+mother);
	}
}
