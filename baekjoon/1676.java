import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
    	/*
    	 * 뒷자리에 0이 n개 있다는 의미는 2와 5가 n개씩 짝지어 존재한다는 것
    	 * 팩토리얼 값을 보면 2는 5보다 작은 수여서 연속된 수를 곱하게 되면 
    	 * 자연스레 모든 값들의 소인수 분해들은 2의 개수가 5의 개수보다 많다
    	 * 즉, 기본적으로 5의 개수에 따라 값이 변화함
    	 * 단순히 5로 나눌 것이 아니라 반복문을 통해 5로 나누면서 누적합
    	 */
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int num = Integer.parseInt(br.readLine());
    	int count = 0;
    	
    	while (num >= 5) {
    		count += num / 5;     // n까지 5의 배수의 개수
    		num /= 5;
    	}
    	
    	System.out.println(count);
    	
    }
    
}