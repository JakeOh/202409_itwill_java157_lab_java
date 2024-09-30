package com.itwill.variable01; // 패키지 선언문

// 클래스 선언
public class VariableMain01 {
	
	// 메인 메서드
	public static void main(String[] args) {
		// 변수(variable) 선언/초기화/사용하기
		
		// 변수 선언과 동시에 초기화(변수 선언과 초기화를 한 문장으로 작성).
		// 변수타입 변수이름 = 값;
		int x = 100;
		System.out.println("x = " + x);
		
		// 자바의 기본 데이터 타입:
		// (1) 정수 타입: byte, short, int, long, char
		// (2) 실수 타입: float, double
		// (3) 논리(true/false) 타입: boolean
		long bigNumber = 2_000_000_000_000_000L;
		double pi = 3.141592;
		boolean isMarried = false;
		
		System.out.println(bigNumber);
		System.out.println(pi);
		System.out.println(isMarried);
		
		// 변수 이름 작성 문법/관습:
		// 변수 이름은 알파벳(a, ..., z), 숫자, _, $만 사용 가능.
		// 변수 이름은 대/소문자를 구분함. (예) x, X는 다른 이름의 변수.
		// 변수 이름은 숫자로 시작할 수 없음.
		// 변수 이름으로 자바의 키워드를 사용할 수 없음.
		// 변수 이름은 저장되는 값의 의미를 파악하기 쉽게 "의미 있는" 단어들을 사용해서
		// 만드는 것을 권장.
		// 변수 이름을 만들 때 2개 이상의 단어를 사용해서 만드는 경우
		// "소문자"로 시작하는 camel 표기법을 권장.
		// (예) userId, userPassword, whoAmI
		// (비교) snake 표기법: user_id, user_password, who_am_i
	}
			
}
