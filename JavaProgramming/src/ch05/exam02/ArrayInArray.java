package ch05.exam02;

public class ArrayInArray {

	public static void main(String[] args) {
		int[][] scores = new int[2][3];
		
		System.out.println("배열의 깅이");
		System.out.println(scores.length);
		System.out.println(scores[0].length);
		System.out.println(scores[1].length);
		
		
		System.out.println("항목값 접근 이용");
		System.out.println(scores[0][0]);
		System.out.println(scores[0][1]);
		System.out.println(scores[0][2]);
		
		System.out.println(scores[1][0]);
		System.out.println(scores[1][1]);
		System.out.println(scores[1][2]);
		
		
		System.out.println("for문 이용");
		for(int i = 0;i<scores.length;i++){
			for(int j=0;j<scores[i].length;j++){
				System.out.println(scores[i][j]);
			}
		}
		
		System.out.println("값 변경");
		scores[0][1] = 50;
		
		
	}

}
