package Silver2.baekjoon_2108;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] numbers = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = 0;

		for (int i = 0; i < N; i++) {
			int number = sc.nextInt();
			numbers[i] = number;
			sum += number;
			map.put(number, map.getOrDefault(number, 0) + 1);
		}

		double avg = (double) sum / (double) N;
		avg = avg < 0 && avg > -0.5 ? 0 : avg;

		int maxFreq = 0;
		for (int key : map.keySet()) {
			if (map.get(key) > maxFreq) {
				maxFreq = map.get(key);
			}
		}

		List<Integer> freqList = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == maxFreq) {
				freqList.add(key);
			}
		}

		Collections.sort(freqList);
		int freq = freqList.size() >= 2 ? freqList.get(1) : freqList.get(0);

		Arrays.sort(numbers);
		int mid = numbers[numbers.length / 2];
		int max_min = numbers[numbers.length - 1] - numbers[0];

		System.out.printf("%.0f\n", avg);
		sb.append(mid).append("\n").append(freq).append("\n").append(max_min);
		System.out.println(sb);
	}
}
