import java.io.*;
import java.util.*;

public class Main {
	static int n, max = 0;
	static String[] words;
	static boolean[] visited = new boolean[10];
	static HashMap<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		words = new String[n];
		
		// 입력으로 들어온 단어들의 알파벳을 Key, 자릿수를 Value로 한 Map설정
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			int len = words[i].length();
			for (int j = 0; j < len; j++) {
				char ch = words[i].charAt(j);
				map.put(ch, (int) (map.getOrDefault(ch, 0) + Math.pow(10, len-j-1)));
			}
		}
		
		// Map의 Value를 기준으로 내림차순 정렬한 KeySetList 생성 
		List<Character> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		
		// 자릿수가 큰 알파벳 순으로 9부터 하나씩 숫자를 줄여가며 곱해준 것을 더함
		int ans = 0;
		int cnt = 9;
		for (Character key : keySetList) {
			ans += map.get(key) * cnt--;
		}
		System.out.println(ans);
	}

}
