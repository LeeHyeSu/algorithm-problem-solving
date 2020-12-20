import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
        	String s = sc.next();
        	String t = String.valueOf(s.charAt(0));
        	for(int j = 1; j < s.length(); j++) {
        		if(s.charAt(j-1) != s.charAt(j) &&
        			t.indexOf(s.charAt(j)) != -1) {
        			break;
        		}
        		t += s.charAt(j);
        	}
        	if(s.equals(t)) cnt++;
        }
        System.out.println(cnt);    
    }
}