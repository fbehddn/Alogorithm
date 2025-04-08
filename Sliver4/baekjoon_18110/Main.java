package Sliver4.baekjoon_18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		if(N==0){
			System.out.println("0");
			return;
		}
		double command = 0.15;
		int remove = (int) Math.round(N * command);

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);

		double sum = 0;
		for (int i = remove; i < list.size() - remove; i++) {
			sum += list.get(i);
		}

		System.out.printf("%.0f", sum / (list.size() - remove * 2));
	}
}
