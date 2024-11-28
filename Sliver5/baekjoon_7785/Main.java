package Sliver5.baekjoon_7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> log = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if (log.contains(name)) log.remove(name);
            else log.add(name);

        }

        ArrayList<String> result = new ArrayList<>(log);
        Collections.sort(result, Collections.reverseOrder());

        for (String s : result) {
            System.out.println(s);
        }
    }
}
