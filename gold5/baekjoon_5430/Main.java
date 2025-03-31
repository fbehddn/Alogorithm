package gold5.baekjoon_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
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

			boolean direction = true; // true -> 머리 가리키고 있음
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
					case 'R': {
						if(direction) {
							direction = false;
						}else{
							direction = true;
						}
						break;
					}
					case 'D': {
						if (list.isEmpty()) {
							sb = new StringBuilder();
							sb.append("error");
							break;
						} else {
							if (direction) {
								list.remove(0);
								break;
							} else {
								list.remove(list.size() - 1);
							}
							break;
						}
					}
				}
			}
			for(int i=0; i<list.size(); i++){
				if(direction){
					sb.append(list.get(i));
				}else
					sb.append(list.get(list.size() - i - 1));
				if(i != list.size() - 1){
					sb.append(",");
				}
			}
			if (!sb.toString().equals("error")) {
				sb.append(']');
			}
			result.append(sb).append("\n");
		}
		System.out.println(result);
	}
}
