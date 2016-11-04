<%@ page contentType="application/json;charset=UTF-8"%>


<%-- json --%>
<%-- 규칙 : 속성은 ""로 감싸야 함, 숫자는 그냥 쓰고, 문자열은 ""로 감싸야 함, 데이터가 없다는 표현으로 null을 넣을 수가 있음 --%>
<%-- 속성이 헷갈리는 이유, 자바스크립트에서는 ""를 붙여도, 안붙여도 되기 때문 --%>
<%-- 다수의 내용을 전달할 때는 배열과 그 안에 객체들로, 하나의 내용을 전달할 때는 객체 하나만 --%>
<%-- 객체 안에 또 배열&객체들이 들어갈 수 있음 --%>
<%-- 서버가 보낼 땐 문자열, jsp로 바꿀 땐 배열로 변환해서 받음 (html은 문자열로 보내고 jsp에서 문자열로 받으므로 가공이나 활용이 힘듬)--%>

[
	{"ano":1, "alocation":"독일", "ahitcount":10, "aimg":"../common/image/헤이즈짱내꺼라능1.jpg"},
	{"ano":2, "alocation":"독일", "ahitcount":20, "aimg":"../common/image/헤이즈짱내꺼라능2.jpg"},
	{"ano":3, "alocation":"독일", "ahitcount":30, "aimg":"../common/image/헤이즈짱내꺼라능3.jpg"},
	{"ano":4, "alocation":"독일", "ahitcount":40, "aimg":"../common/image/헤이즈짱내꺼라능4.jpg"}
]