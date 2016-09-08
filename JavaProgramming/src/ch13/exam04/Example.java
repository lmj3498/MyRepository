package ch13.exam04;

import java.util.Date;

public class Example {

	public static void main(String[] args) {

		Map<String, Date> map = new HashMap<String, Date>();
		map.add("입학식", new Date(2016, 8, 16));
		Date date = map.get("입학식");

	}

}
