package bracketS2;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();
		sc.nextLine();
		String[] strArr = new String[init];
		boolean isCorrect = false;
			
		for (int i = 0; i < init; i++) {
			strArr[i] = sc.nextLine();
		}
		
		//문자열을 담은 배열을 for문을 돌리면서 수행결과를 출력합니다.
		for(String str : strArr){
			isCorrect = checkBracket(str);
			if(isCorrect){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	public static boolean checkBracket(String exp) {
		BracketStack s = new BracketStack();
		int expSize = exp.length();
		//for문을 돌면서 비교대상이 되는 testCh 변수와
		//Stack에서 가장 최근의 괄호를 반환하여 testCh와 비교하는 openPair
		char testCh, openPair;

		for (int i = 0; i < expSize; i++) {
			//문자열에서 i번째 문자를 testCh에 담는다.
			testCh = exp.charAt(i);
			//testCh가 (,{,[ 중 하나면 Stack에 집어넣는다.
			if (testCh == '(' || testCh == '{' || testCh == '[') {
				s.push(testCh);
			} else if (testCh == ')' || testCh == '}' || testCh == ']') {
				//testCh가 ),},] 중 하나면 먼저 Stack이 비었는지 확인한다.
				//Stack이 비어있으면, 쌍이 맞지 않으므로, false를 반환한다.
				if (s.isEmpty()) {
					return false;	
				} else {
					//Stack이 비어있지 않으면, 맨 위의 문자를 반환한다.
					openPair = s.pop();
					//쌍이 성립하지 않는 or 조건식을 작성하여, 하나라도 true면 false를 반환한다.
					if (openPair == '(' && testCh != ')' || openPair == '{' && testCh != '}'
							|| openPair == '[' && testCh != ']') {
						return false;
					}
				}
			}
		}
		//for문을 종료하고, Stack이 비어있으면 true를 반환한다.
		if (s.isEmpty()) {
			return true;
		}
		return false;
	}

}

//최근에 자료구조 배우면서 Stack을 배워서... 한번 구현해봤습니다.
class BracketStack {
	private BracketNode top;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(char item) {
		BracketNode newNode = new BracketNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	public char pop() {
		if (isEmpty()) {
			return 0;
		} else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}
}

class BracketNode {
	public char data;
	public BracketNode link;
}