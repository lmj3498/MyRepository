package ch11.exam10;

public class StringBuilderExample {

	public static void main(String[] args) {
		String data = "a";
		data += "b";
		data += "c";
		System.out.println(data);
		
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		System.out.println(sb);
		
		String data2 = "abc";
		StringBuilder sb2 = new StringBuilder(data2);
		sb2.insert(1, "0");
		data2 = sb.toString();
		System.out.println(data2);
		
	}

}
