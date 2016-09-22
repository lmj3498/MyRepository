package ch18.exam15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		//----------------------------------------------------------------------------------
		
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Member member2 = (Member) ois.readObject();
		
		fis.close();
		ois.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMpassword());
		System.out.println(member2.getMage());
		System.out.println(member2.getNation());// 복원이 아님 원래 클래스에 붙어 있던 정젖 데이터이기 때문에 접근 가능 -> 원래 다른 프로그램에서는 안됨
		
		
	}

}
