package com.itwill.print; // 패키지 선언문

public class PrintMain { // 클래스 선언

	public static void main(String[] args) { // 메인 메서드
		// 여러가지 콘솔 출력 방법:
		System.out.println("print line(한 줄 출력)");
		System.out.println("1 + 2");
		System.out.println(1 + 2); // +: 숫자 덧셈 연산자
		System.out.println("이름: " + "오쌤"); // +: 문자열 이어붙이기 연산자
		System.out.println("1 + 2 = " + 3); // +: 문자열 이어붙이기 연산자
		System.out.println("1 + 2 = " + 1 + 2);
		System.out.println("1 + 2 = " + (1 + 2));
		
		System.out.print("안녕하세요."); // 출력하고 줄바꿈이 되지 않음.
		System.out.println("Hello"); // 출력하고 줄바꿈이 일어남.
		
		// formatted printing: 문자열 템플릿에 값들을 대체해서 출력.
		// 문자열 템플릿에 사용되는 기호:
		// %d: 정수로 대체
		// %f: 실수로 대체
		// %s: 문자열로 대체
		// \n: 줄 바꿈(new line)
		// \t: 탭(tab)
		System.out.printf("%d + %d = %d\n", 1, 2, 3);
		System.out.printf("문자열 템플릿: 정수(%d), 실수(%f), 문자열(%s)", 100, 3.14, "홍길동");
	}

}
