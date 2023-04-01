package Bronze2.baekjoon_1076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String > map = new HashMap<>(){{
            put("black","0");
            put("brown", "1");
            put("red", "2");
            put("orange", "3");
            put("yellow", "4");
            put("blue", "6");
            put("violet", "7");
            put("grey", "8");
            put("white", "9");
        }};

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        long result = Long.parseLong(map.get(str1)+map.get(str2));
        result *= Math.pow(10, Long.parseLong(map.get(str3)));

        System.out.println(result);
    }
}
