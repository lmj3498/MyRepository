package ch11.exam10;

public class StringIndexOfExample {

	public static void main(String[] args) {
		
		String subject = "자바 프로그래밍";
		
		boolean result1 = subject.contains("자바");
		if(result1){
			System.out.println("자바와 관련된 책이군요");
		}else{
			System.out.println("다른 전공의 책이군요");
		}
		
		int result2 = subject.indexOf("자바");
		if(result2 != -1){
			System.out.println("자바와 관련된 책이군요");
		}else{
			System.out.println("다른 전공의 책이군요");
		}
		int startIndex1 = subject.indexOf("자바");
		int endIndex1 = startIndex1+2;
		String token1 = subject.substring(startIndex1, endIndex1);
		System.out.println(token1);
		
		String find = "프로그래밍";
		int startIndex2 = subject.indexOf(find);
		int endIndex2 = startIndex2+find.length();
		String token2 = subject.substring(startIndex2, endIndex2);
		System.out.println(token2);
		
		
		int startIndex3 = subject.indexOf(find);
		String token3 = subject.substring(startIndex3);
		System.out.println(token3);
	}

}
