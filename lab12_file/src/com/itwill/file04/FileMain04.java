package com.itwill.file04;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        final String fileName = "data/product.dat";
        
        // Product 타입 객체를 파일에 쓰기(write. 직렬화, serialization):
        try (// 리소스 생성
                FileOutputStream out = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(out);
        ) {
            // 파일에 쓸 Product 타입의 객체를 생성:
            Product p = new Product(1, "스마트폰", 100_000);
            
            // 자바 객체를 직렬화해서 파일에 씀.
            oos.writeObject(p);
            
            oos.writeObject(new Product(2, "장난감", 1_000));
            
            System.out.println("파일 작성 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 작성된 파일에서 데이터를 읽고 자바 객체로 변환(역직렬화, de-serialization):
        try ( // 리소스 생성
                FileInputStream in = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(in);
        ) {
//            Product p1 = (Product) ois.readObject();
//            System.out.println(p1);
//            
//            Product p2 = (Product) ois.readObject();
//            System.out.println(p2);
            
            while (true) {
                Product p = (Product) ois.readObject();
                //-> OIS.readObject() 메서드는 파일 끝에서 EOFException을 던짐.
                System.out.println(p);
            }
            
        } catch (EOFException e) {
            System.out.println("--- 파일 끝 ---");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
