package Sliver5.baekjoon_4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static char[] mo = {'a', 'e', 'i', 'o', 'u'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String command = br.readLine();
		while (!command.equals("end")) {
			makeSentence(command);

			if (checkSentence(command)) {
				makeTrueResult();
			} else makeFalseResult();

			command = br.readLine();
		}
		System.out.println(sb);
	}

	private static boolean checkSentence(String command) {
		boolean hasMo = false;
		for (char c : command.toCharArray()) {
			if (isMoeum(c)) {
				hasMo = true;
				break;
			}
		}
		if (!hasMo) return false;

		int moCount = 0;
		int jaCount = 0;
		for (
			int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			boolean isMo = isMoeum(c);
			if (isMo) {
				moCount++;
				jaCount = 0;
			} else {
				jaCount++;
				moCount = 0;
			}
			if (moCount == 3 || jaCount == 3) return false;
		}

		for (
			int i = 1; i < command.length(); i++) {
			char prev = command.charAt(i - 1);
			char curr = command.charAt(i);
			if (prev == curr && (prev != 'e' && prev != 'o')) {
				return false;
			}
		}

		return true;
	}

	private static boolean isMoeum(char c) {
		for (char m : mo) {
			if (c == m) return true;
		}
		return false;
	}

	private static void makeFalseResult() {
		sb.append("is not acceptable.").append("\n");
	}

	private static void makeTrueResult() {
		sb.append("is acceptable.").append("\n");
	}

	private static void makeSentence(String command) {
		sb.append("<" + command + "> ");
	}
}
