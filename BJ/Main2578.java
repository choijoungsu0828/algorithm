package silver;

import java.util.Scanner;

public class Main2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] bingo = new int[5][5];
		int[] call = new int[25];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < 25; i++) {
			call[i] = sc.nextInt();
		}
		int bingoCnt = 0;
		for(int i = 0; i < 25; i++) {
			outer : { 
				for(int j = 0; j < 5; j++) {
					for(int k = 0; k < 5; k++) {
						if(bingo[j][k] == call[i]) {
							bingo[j][k] = 0;
							// 대각선 빙고 확인
							if(j==k) {
								for(int q = 0; q < 4; q++) {
									if(!(bingo[q][q] == bingo[q+1][q+1])) {
										break;
									}
									if(q == 3) {
										bingoCnt++;
									}
								}
							}
							if(j+k == 4) {
								for(int q = 0; q < 4; q++) {
									if(!(bingo[q][4-q] == bingo[q+1][4-q-1])) {
										break;
									}
									if(q == 3) {
										bingoCnt++;
									}
								}
							}
							// 세로줄 빙고 확인
							for(int q = 0; q < 4; q++) {
								if(!(bingo[q][k] == bingo[q+1][k])) {
									break;
								}
								if(q == 3) {
									bingoCnt++;
								}
							}
							// 가로줄 빙고 확인
							for(int q = 0; q < 4; q++) {
								if(!(bingo[j][q] == bingo[j][q+1])) {
									break;
								}
								if(q == 3) {
									bingoCnt++;
								}
							}
							break outer;
						}
					}
				}
			}
			if(bingoCnt >= 3) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
