import java.util.Scanner;

public class Main {
    static int n;
    static String start = "\"재귀함수가 뭔가요?\"\n";
    static String mid1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String mid2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String mid3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static String end = "라고 답변하였지.\n";
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		
		recursion(0);
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.println(sb);
	}
	
	static void recursion(int num) {
		makeSentence(num, start);
		
		if (num == n) {
			makeSentence(num, answer);
			makeSentence(num, end);
			return;
		}
		
		makeSentence(num, mid1);
		makeSentence(num, mid2);
		makeSentence(num, mid3);
		
		recursion(num + 1);
		makeSentence(num, end);
	}
	
	static void makeSentence(int num, String text) {
		for (int i = 0; i < num; i++) {
			sb.append("____");
		}
		sb.append(text);
	}

}
