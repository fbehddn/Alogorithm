package Sliver5.baekjoon_7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> log = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            log.put(st.nextToken(), st.nextToken());
        }

        ArrayList<String> result = new ArrayList<>();
        for (String s : log.keySet()) {
            if (log.get(s).equals("enter")) {
                result.add(s);
            }
        }
        Collections.sort(result, Collections.reverseOrder());

        for (String s : result) {
            System.out.println(s);
        }
    }
}
