package Silver3.baekjoon_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = left + day - 1;

		int sum=0;
		for(int i=0; i<day; i++) {
			sum+=arr[i];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(sum, 1);
		while(right<N-1){
			right++;
			sum+=arr[right];
			sum-=arr[left];
			left++;
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		int max = 0;
		for (int n : map.keySet()) {
			max = max < n ? n : max;
		}
		if(max==0){
			System.out.println("SAD");
		}else{
			System.out.println(max);
			System.out.println(map.get(max));
		}
	}
}