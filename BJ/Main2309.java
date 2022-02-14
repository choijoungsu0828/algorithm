package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main2309 {
	
	static int[] arr;
 	static boolean[] isSelected;
 	static int[] answer = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		// 난쟁이들의 키를 9칸짜리 배열에 삽입.
		isSelected = new boolean[9];
		for(int i = 0; i < arr.length; i++) { 
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		combine7(0, 0); // 9C7을 구하는 함수
		for(int i = 0; i < 7; i++) { // 100이 될때의 키들을 answer배열에 담는다.
			answer[i] = arr[answer[i]];
		}
		Arrays.sort(answer); // 오름차순 정렬
		for(int i : answer) {
			System.out.println(i);
		}
		sc.close();
		
 	}
	public static void combine7(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 9; i++) {
				if(isSelected[i]) {
					sum += arr[i];
				}
			}
			if(sum == 100) {
				int j = 0;
				for(int i = 0; i < 9; i++) {
					if(isSelected[i]) {
						answer[j] = i;
						j++;
					}
				}
			}
			return;
		}
		if(start-cnt > 2) {
			return;
		}
		isSelected[start] = true;
		combine7(cnt+1, start+1);
		isSelected[start] = false;
		combine7(cnt, start+1);
	}
}
