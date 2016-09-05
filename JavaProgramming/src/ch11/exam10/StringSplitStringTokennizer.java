package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokennizer {

	public static void main(String[] args) {
		String data = "홍길동,이수홍,박연수,감자바,최명호";

		String[] dataArray = data.split(",");
		System.out.println(dataArray.length);
		for (String name : dataArray) {
			System.out.println(name);
		}

		StringTokenizer st = new StringTokenizer(data, ",");
		// System.out.println(st);
		System.out.println(st.countTokens());

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}

		data = "홍길동&이수홍,박연수,감자바-최명호";

		dataArray = data.split("&|,|-");
		System.out.println(dataArray.length);
		for (String name : dataArray) {
			System.out.println(name);
		}
	}

}
