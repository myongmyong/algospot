package bracketS2;

import java.util.Scanner;
import java.util.Stack;

public class Others {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			System.out.println(wellMatched(sc.next()) ? "YES" : "NO");
		}
		sc.close();

	}

	public static boolean wellMatched(String str) {
		Stack<Character> openStack = new Stack<Character>();
		String opening = "({[", closing = ")}]";

		for (int i = 0; i < str.length(); i++) {
			char bracket = str.charAt(i);
			if (opening.indexOf(bracket) != -1) {
				openStack.push(bracket);
			} else {
				if (openStack.empty())
					return false;
				if (opening.indexOf(openStack.peek()) != closing.indexOf(bracket))
					return false;
				openStack.pop();
			}
		}
		return openStack.empty();
	}
}
