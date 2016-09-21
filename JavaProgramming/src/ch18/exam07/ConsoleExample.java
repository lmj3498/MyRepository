package ch18.exam07;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		Console console = System.console();
		System.out.print("아이디를 입력하세요 : ");
		String id = console.readLine();
		
		System.out.print("패스워드를 입력하세요 : ");
		char[] password = console.readPassword();
		
		System.out.println("입력된 내용");
		System.out.println(id);
		System.out.println(password);
		
	}

}
