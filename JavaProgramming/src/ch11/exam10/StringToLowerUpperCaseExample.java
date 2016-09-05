package ch11.exam10;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		String oldStr = "Java Programming";
		
		String newStr = oldStr.toLowerCase();
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
		
		System.out.println(oldStr.equals("java programming"));
		System.out.println(oldStr.toLowerCase().equals("java programming".toLowerCase()));
		System.out.println(oldStr.toUpperCase().equals("java programming".toUpperCase()));
		
		String targetStr = "          Java Programming         ";
		System.out.println(oldStr == targetStr);
		System.out.println(oldStr.equals(targetStr));
		System.out.println(oldStr.equals(targetStr.trim()));
		
		
		
	}

}
