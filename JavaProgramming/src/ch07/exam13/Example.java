package ch07.exam13;

public class Example {
	
	
	public static void main(String[] args) {
		//Phone phone = new Phone();
		SmartPhone p1 = new SmartPhone();
		p1.number = "010-123-4567";
		p1.ring();
		p1.sendVoice();
		p1.receiveVoice();
		p1.internet();
		
		System.out.println();
		HomePhone p2 = new HomePhone();
		p2.number = "010-123-4567";
		p2.ring();
		p2.sendVoice();
		p2.receiveVoice();
		p2.address = "서울시 송파구 가락동 IT 벤처 타워 서관 12층";
		
	}

}
