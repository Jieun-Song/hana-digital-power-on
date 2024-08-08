# 6. DI(Dependency Injection)

객체들을 모아놓은 공간 → 스프링 컨테이너

DI : 의존성 주입

DI를 이용한 프로그래밍 방법과 DI에 대해 학습한다. 

## 6-1. DI란?

스프링만의 기능은 아님. OOP 프로그래밍에서 많이 쓰는 방법.

스프링에서 채택해서 효율적으로 쓰게 된것.

객체지향 프로그램 내 객체들을 이용해 원하는 기능을 구현함.

객체가 프로젝트에 구속이 되어있다고 하자. 이때 변경사항이 필요하면.. 수정이 어려움

⇒ 객체 각각이 분류되어있고 결합과 분리가 가능하면 수정이 더 쉬움

배터리를 장착하는 방법

- 배터리 일체형 : 배터리를 새로 넣는 것이 불가능 하다.
- 배터리 분리형1 : 처음 제조시 배터리가 아예 부품에 들어가 있지 않은 상태이다. 배터리가 떨어지면 setter를 이용해 배터리를 새로 넣으면 된다.
- 배터리 분리형2 : 처음 제조시 배터리가 부품에 들어가있으며 배터리가 떨어지면 Setter를 이용해 배터리를 교체하면 된다.

```java
// 배터리 일체형
public class ElectronicCarToy {
	private Battery battery;
	
	public ElectroicCarToy() {
		battery = new NormalBattery();
	}
}

// 배터리 분리형1
public class ElectronicCarToy {
	private Battery battery;
	
	public ElectronicCarTody() {
	}
	
	public void setBattery(Battery battery){
		this.battery = battery;
	}
}

// 배터리 분리형2
public class ElectronicalCarToy {
	 private Battery battery;
	 
	 public ElectronicalCarToy(Battery battery) {
		 this.battery = battery;
	 }
	 public void setBattery(Battery battery) {
		 this.battery = battery;
	 }
}
	
```

어차피 객체들은 스프링 컨테이너라는 곳에 모여있으며 그 객체들은 각각 의존하는 관계.

스프링 설정파일에 객체들이 등록되어 스프링 컨테이너에 객체들이 들어간다. 이때 get 매서드를 이용해 객체를 불러내 빈(Bean) 객체를 필요로 하는 로직에 꺼내질수있다.

![스크린샷 2024-08-08 오후 1.32.34.png](6%20DI(Dependency%20Injection)%2082e19dd98fcb426d9cd04afefbd69169/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-08-08_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_1.32.34.png)

객체를 어떤 객체에 의존 주입(삽입)만 하면 그것은 DI라고 할 수 있다.

## 6-2. 스프링 DI 설정 방법

(자바)

assembler ← 모든 서비스들을 모아서 관리

assembler안에 등록(register)서비스객체 있음.

```java
StudentAssembler assembler = new StudentAssembler();
```

(스프링에서는 applicationContext라는 xml 파일을 이용하여 등록하여 사용한다.. 아마 지금은 애노테이션얘기같음

불러낼때는  )

```java
GenericXmlApplicationContext ctx 
	= new GenericXmlApplicationContext("classpath:applicationContext.xml);
```

DAO : Data Access Object

이 객체를 이용해서 데이터베이스와 통신을 한다.

Service 

각각의 service마다 데이터베이스에 접근하기 위해 DAO를 불러내야한다.

각각의 서비스마다 각각의 DAO, 데이터베이스를 만들어낸다면 따로놀것이다.

하나의 DAO를 가지고 이용하기 위해 각 서비스에서 DAO를 불러내는 것이다.