package ch15.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		
		//Set 계열 컬렉션 생성
		Set<String> set = new HashSet<>();
		//Set<String> set = new TreeSet<>();
		//Set<String> set = new LinkedHashSet<>();

		//객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBatis");
		
		System.out.println(set.size());
		System.out.println();
		
		
		//객체를 일괄 처리하기
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			if(str.equals("JDBC")){
				iterator.remove();
			}
			System.out.println(str);
		}
		
		//객체를 일괄 처리하기
		for(String str : set){
			System.out.println(str);
			
			//향상된 for문 안에서는 절대 밑에처럼 쓰면 안됨
			/*if(str.equals("JDBC")){
				iterator.remove();
			}*/
		}
		System.out.println();
	}

}
