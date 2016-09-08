package ch13.exam06;

public class Util {

	public static <K,V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		
		
		return keyCompare && valueCompare;
	}

	/*public static boolean compare(Pair<String, String> p1, Pair<String, String> p2) {

		return false;
	}

	public static boolean compare(Pair<String, String> p1, Pair<String, String> p2) {

		return false;
	}*/
	
	public static <K,V> Pair<K,V> max(Pair<K,V> p1, Pair<K,V> p2){
		
		return p2;

	}
	
}
