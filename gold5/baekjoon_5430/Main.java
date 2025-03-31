package gold5.baekjoon_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		String str;
		int size;
		List<Integer> list;

		while (T-- > 0) {
			str = br.readLine();
			size = Integer.parseInt(br.readLine());
			list = new ArrayList<>();

			String original = br.readLine();
			String replace = original.replace("[", "");
			String res = replace.replace("]", "");
			String[] strs = res.split(",");
			for (int i = 0; i < size; i++) {
				list.add(Integer.parseInt(strs[i]));
			}

			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
					case 'R': {
						Collections.reverse(list);
						break;
					}
					case 'D': {
						if (list.isEmpty()) {
							result.append("error").append('\n');
							break;
						}
						list.remove(0);
						break;
					}
				}
			}

			if (!list.isEmpty()) {
				result.append('[');

				for (int i = 0; i < list.size(); i++) {
					result.append(list.get(i));
					if (i != list.size() - 1) result.append(',');
				}

				result.append(']').append('\n');
			}
		}
		System.out.println(result);
	}
}
