package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = {
			72,101,108,108,111,32,74,97,118,97	
		};
		/*String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,0,5);
		System.out.println(str2);*/
		
		//-----------------------------------
		/*String str3 = "홍길동";
		byte[] strBytes3 = str3.getBytes();
		String str4 = new String(strBytes3);
		System.out.println(str4);
		
		
		String str5 = "홍길동";
		byte[] strBytes5 = str5.getBytes("UTF-8");
		String str6 = new String(strBytes5,"UTF-8");
		System.out.println(str6);
		
		String str7 = "AB홍길동";
		byte[] strBytes6 = str5.getBytes("EUC-KR");
		String str8 = new String(strBytes5,"EUC-KR");
		System.out.println(str7);*/
		
		String str9 = "ab홍길동";
		byte[] strBytes7 = str9.getBytes("EUC-KR");
		String str10 = new String(strBytes7,2,6,"EUC-KR");
		System.out.println(str10);
		
		String str11 = "ab홍길동";
		byte[] strBytes8 = str11.getBytes("UTF-8");
		String str12 = new String(strBytes8,2,9,"UTF-8");
		System.out.println(str12);
		
	}
	

}
