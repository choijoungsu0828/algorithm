package com.ssafy.day0215;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_Jungol_1828_냉장고_최종수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Chemical[] chemicals = new Chemical[n];
		for(int i = 0; i < n; i++) {
			chemicals[i] = new Chemical(sc.nextInt(), sc.nextInt());
		}
		/*
		Arrays.sort(chemicals, new Comparator<Chemical>() {
			@Override
			public int compare(Chemical o1, Chemical o2) {
				return o2.min - o1.min;
			}
		});
		*/
		Arrays.sort(chemicals,(o1, o2) -> o2.min - o1.min);
		int min = chemicals[0].min;
		int cnt = 1;
		for(int i = 1; i < n; i++) {
			if(chemicals[i].max < min) {
				min = chemicals[i].min;
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
/*
class Chemical implements Comparable<Chemical>{
	int min;
	int max;
	Chemical(int min, int max) {
		this.min = min;
		this.max = max;
	}
	@Override
	public int compareTo(Chemical o) {
		return o.min - this.min;
	}
}
*/

class Chemical {
	int min;
	int max;
	Chemical(int min, int max) {
		this.min = min;
		this.max = max;
	}
}