# 18. Controller 객체 구현

## 18-1.웹 어플리케이션 준비

## 18-2. @RequestMapping을 이용한 URL맵핑

## 18-3 요청 파라미터

```java
ID : <input type="text" name = "memId"><br/>
PW : <input type="password" name = "memPw"><br/>
```

1번 방법. HttpServletRequest 객체를 이용한 HTTP 전송 정보 얻기

```java
@RequestMapping(value="/memLogin" method=RequestMethod.POST)
public String memLogin(Model model, HttpServletRequest request){
	
	String memId = request.getParameter("memID");
	String memPw = request.getParameter("memPw");

}
```

2번 방법. @RequestParam 어노테이션을 이용한 HTTP 전송 정보 얻기

```java
@RequestMapping(value="/memLogin" method=RequestMethod.POST)
public String memLogin(Model model,
	@RequestParam("memId") String memId, @RequestParam("memPw") String memPw){
	
	//String memId = request.getParameter("memID");
	//String memPw = request.getParameter("memPw");

}
```

⭐3번 방법

member라는 커맨드 객체를 이용해 getter 사용

```java
@RequestMapping(value="/memLogin" method=RequestMethod.POST)
public String memLogin(Member member){
	
	String memId = Member.getMemId();
	String memPw = Member.getPw();

	return "memLoginOK";
}
```

```java
//memLoginOK.jsp
<body>
		ID : ${member.memId} <br/>
		PW : ${member.memPw} <br/>
</body>
```

객체를 이용해 데이터를 전달하는 것이기 때문에 나중에 불러올때도 객체를 이용할 수있다.