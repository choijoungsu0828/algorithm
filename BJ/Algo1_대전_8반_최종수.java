import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_대전_8반_최종수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 횟수 입력 받음.
		StringTokenizer st;
		// t번의 테스트 케이스 동안 반복문
		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 종이컵의 수 입력받음
			int target = Integer.parseInt(st.nextToken()); // 간식의 위치 입력받음
			int k = Integer.parseInt(st.nextToken()); // 컵을 움직이는 횟수 입력받음
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 바꿀 위치 a
				int b = Integer.parseInt(st.nextToken()); // 바꿀 위치 b
				if(a != target && b != target) { // 바꿀 위치 두개중 1개라도 target과 같지 않다면 확인할 필요 없음.
					continue;
				}
				// 바꿀 컵 중 첫번째 컵이 간식일경우
				if(a == target) {
					target = b; // 간식을 b로 바꾼다.
					continue; // 다음 문장 실행하지 않음.
				}
				// 바꿀 컵 중 두번째 컵이 간식일 경우
				if(b == target) {
					target = a; // 간식을 a로 바꾼다.
					continue; // 다음 문장 실행하지 않음.
				}
			}
			System.out.println("#" + (tc+1) + " " + target); // 결과 출력
		}
	}
}
