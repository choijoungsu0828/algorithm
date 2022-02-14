package silver;

import java.util.Scanner;

/**
 * 정규식 사용
 * replaceall
 * @author joung
 *
 */

public class Main2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=" , " ");
		System.out.println(str.length());
		
		/*
		char[] arr = sc.nextLine().toCharArray();
		int answer = 0;
		for(int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'c':
				answer++;
				if(i == arr.length - 1) {
					break;
				}
				if(arr[i+1]  == '=' || arr[i+1] == '-') {
					i++;
				}
				break;
			case 'd':
				answer++;
				if(i == arr.length - 1) {
					break;
				}
				if(arr[i+1] == '-') {
					i++;
					break;
				}			
				if(i == arr.length - 3) {
					if(!(arr[i+1] == 'z')) {
						break;
					}
				}
				if(i < arr.length - 2) {
					if(arr[i+1] == 'z' && arr[i+2] == '=') {
						i++;
						break;
					}
				}
				break;
			case 'l':
			case 'n':
				answer++;
				if(i == arr.length - 1) {
					break;
				}
				if(arr[i+1] == 'j') {
					i++;
				}		
				break;
			case 's':
			case 'z':
				answer++;
				if(i == arr.length - 1) {
					break;
				}
				if(arr[i+1] == '=') {
					i++;
				}	
				break;
			default:
				if(!(arr[i] == '=') && !(arr[i] == '-')) {
					answer++;
				}
			}
		}
		System.out.println(answer);
		*/
		sc.close();
	}
}
