package Bronze2.baekjoon_10820;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input=null;

        while ((input = br.readLine()) != null) {
            int lower=0,upper=0,num=0,space=0;

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i)>='a' && input.charAt(i)<='z') lower++;
                if(input.charAt(i)>='A' && input.charAt(i)<='Z') upper++;
                if(input.charAt(i)>='0' && input.charAt(i)<='9') num++;
                if(input.charAt(i)==' ') space++;
            }
            sb.append(lower + " " + upper + " " + num + " " + space + "\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
