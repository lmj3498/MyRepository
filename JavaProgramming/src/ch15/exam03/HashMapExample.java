package ch15.exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		//Map 계열 컬렉션 생성
		Map<String,Integer> map = new HashMap<String,Integer>();
		//Map<String,Integer> map = new Hashtable<String,Integer>();
		
		
		//엔트리 추가
		map.put("홍길동", 85);
		map.put("추가을", 90);
		map.put("홍길동", 95);//덮어써짐
		map.put("감자바", 81);
		System.out.println(map.size());
		System.out.println();
		
		//객체(값) 얻기
		int score = map.get("홍길동");
		System.out.println(score);
		System.out.println();
		
		//모든 엔트리 일괄처리
		Set<Entry<String, Integer>>  set1 = map.entrySet();//import java.util.Map.Entry; 이면 그냥 Entry
		
		for(Entry<String, Integer> entry:set1){
			String key = entry.getKey();
			int value =  entry.getValue();
			System.out.println(key +" : "+value);
		}
		System.out.println();
		
		Set<String> set2 = map.keySet();
		for(String key : set2){
			int value = map.get(key);
			System.out.println(key +" : "+value);
		}
		System.out.println();
		
		//객체 삭제
		map.remove("홍길동");
		
		Set<String> set3 = map.keySet();
		for(String key : set3){
			int value = map.get(key);
			System.out.println(key +" : "+value);
		}
		System.out.println();
		
	}

}
