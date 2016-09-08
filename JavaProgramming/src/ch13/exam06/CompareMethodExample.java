package ch13.exam06;

public class CompareMethodExample {

	public static void main(String[] args) {
//		boolean result = Util.compare(new Pair<String,String>("이명진","이명진"), new Pair<String,String>("이명진","이명진"));

		Pair<String, String> p1 = new Pair<String,String>("이명진","김정호");
		Pair<String, String> p2 = new Pair<String,String>("김정호","이명진");
		
		boolean result = Util.compare(p1, p2);
		System.out.println(result);
	}

}
