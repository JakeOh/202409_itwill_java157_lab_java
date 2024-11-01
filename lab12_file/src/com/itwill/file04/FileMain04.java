package com.itwill.file04;

/*
 * 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일
 * - OOS.writeObject(): 자바 객체를 파일에 쓸 수 있는 형태로 변환(직렬화, serialization).
 * 
 * 프로그램 <== ObjectInputStream <== FileInputStream <== 파일
 * - OIS.readObject(): 파일에서 읽은 데이터를 자바 객체로 변환(역직렬화, de-serialization).
 * 
 * (주의) OIS, OOS에서 읽고 쓰는 자바 객체는 반드시 Serializable 인터페이스를 구현해야 함!
 * 
 * try-with-resource 문법:
 * - InputStream, OutputStream과 같은 객체들은 사용한 이후에 반드시 close() 메서드를 호출해서
 * 사용했던 리소스들을 해제해야 함.
 * - try-catch-finally 구문에서는 객체 생성은 try 블록에서 하고, 리소스 해제는 finally 블록에서 작성.
 * - try-catch-finally 구문의 불편함을 해소하기 위해서, 생성된 리소스들의 close() 메서드를
 * 자동으로 호출해 주는 문법이 생김.
 * 
 * try ( 리소스 생성(생성자 호출); ) {
 *     정상적인 상황에서 실행할 코드 블록;
 * } catch (예외 타입 변수 선언) {
 *     예외 처리 블록;
 * }
 * 
 * - finally 블록에서 close 하는 코드를 작성할 필요가 없음.
 * - try ()에서 생성자를 호출하는 객체들은 반드시 close() 메서드를 가지고 있어야 함.
 */

public class FileMain04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
