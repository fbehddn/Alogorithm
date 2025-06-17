package Silver3.baekjoon_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;
		int count = 0;

		while(left < right){
			int sum = arr[left] + arr[right];
			if(target == sum){
				count++;
				left++;
				right--;
			}else if (target < sum) {
				right--;
			}else{
				left++;
			}
		}
		System.out.println(count);
	}
}
