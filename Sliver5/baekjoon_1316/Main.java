package Sliver5.baekjoon_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count =0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j = 0; j<str.length(); j++) {
                int temp = count;
                for (int k = j + 2; k < str.length(); k++) {
                    if(ch[j] == ch[k]) {
                        count++;
                        break;
                    }
                }
                if(temp<count) break;

            }
        }

        System.out.println(N-count);

    }
}
