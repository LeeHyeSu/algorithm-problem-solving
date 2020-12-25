import java.util.Scanner;

public class Main {	
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] w = new int[N];
    	int[] h = new int[N];
    	int[] k = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		w[i] = sc.nextInt();
    		h[i] = sc.nextInt();
    		k[i] = 1;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(w[i] < w[j] && h[i] < h[j]) {
    				k[i]++;
    			}
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		System.out.print(k[i] + " ");
    	}
    }
}