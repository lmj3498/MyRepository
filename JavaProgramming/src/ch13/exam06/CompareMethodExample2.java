package ch13.exam06;

public class CompareMethodExample2 {

	public static void main(String[] args) {

		Pair<String, String> p1 = new Pair<String, String>("이명진", "김정호");
		Pair<String, String> p2 = new Pair<String, String>("김정호", "김정호");
		Pair<String, String> result1 = Util.max(p1, p2);// max 리턴하도록

		Pair<String, Integer> p3 = new Pair<String, Integer>("이명진", 20);
		Pair<String, Integer> p4 = new Pair<String, Integer>("김정호", 10);
		Pair<String, Integer> result2 = Util.max(p3, p4);// max 리턴하도록

		System.out.println(result1.getKey() + " , " + result1.getValue());
		System.out.println(result2.getKey() + " , " + result2.getValue());

	}

}
