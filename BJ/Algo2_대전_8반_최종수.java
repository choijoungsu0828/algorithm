import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Algo2_대전_8반_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n개의 동아리 수 입력 받음
		int s = Integer.parseInt(st.nextToken()); // 팀의 합산 점수 컷
		int m = Integer.parseInt(st.nextToken()); // 개인별 점수 컷
		int cnt = 0;
		// 동아리 수 만큼 반복문 실행
		for(int i = 0; i < n; i++) {
			boolean cut = true; // 컷을 통과했는지 여부
			int[] stat = new int[3]; // 3명의 팀원의 능력치를 담을 3칸짜리 배열 생성
			st = new StringTokenizer(br.readLine());
			int statSum = 0; // 3명의 팀원의 능력치 합.
			for(int k = 0; k < 3; k++) { // 배열에 팀원의 능력치 입력하면서 합 계산
				stat[k] = Integer.parseInt(st.nextToken());
				if(stat[k] < m) { // 개인의 능력치가 컷을 넘지 못하면
					cut = false; // 불가하다로 바꿈.
					break;
				}
				statSum += stat[k]; // 팀별 스탯 합 구하기
			}
			if(statSum < s) { // 팀의 합컷을 통과하지 못한다면
				cut = false; // 불가하다로 바꿈.
			}
			if(cut) {
				for(int k = 0; k < 3; k++) {
					sb.append(stat[k] + " ");
				}
				cnt++;
			}
		}
		System.out.println(cnt); // list의 사이즈는 가입한 동아리의 수
		System.out.println(sb);
	}
}
