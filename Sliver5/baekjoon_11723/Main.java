package Sliver5.baekjoon_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> numbers = new HashSet<>();

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			String[] str = br.readLine().split(" ");
			switch (str[0]) {
				case "add": {
					numbers.add(Integer.parseInt(str[1]));
					break;
				}
				case "remove": {
					numbers.remove(Integer.parseInt(str[1]));
					break;
				}
				case "check": {
					if (numbers.contains(Integer.parseInt(str[1]))) {
						sb.append("1").append("\n");
					}else sb.append("0").append("\n");
					break;
				}
				case "toggle": {
					if (numbers.contains(Integer.parseInt(str[1]))) {
						numbers.remove(Integer.parseInt(str[1]));
					} else numbers.add(Integer.parseInt(str[1]));
					break;
				}
				case "all": {
					numbers.clear();
					for (int i = 1; i <= 20; i++) {
						numbers.add(i);
					}
					break;
				}
				case "empty": {
					numbers.clear();
				}
			}
		}
		System.out.println(sb);
	}
}
