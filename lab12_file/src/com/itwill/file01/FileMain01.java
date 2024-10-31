package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램이 데이터(값)을 입력받거나 출력하는 통로.
 *   (예) System.in: (콘솔) 입력 스트림 객체.
 *   (예) System.out: (콘솔) 출력 스트림 객체.
 * 
 * 프로그램 ===> OutputStream (write) ===> 출력 장치(콘솔, 모니터, 프린터, 파일, ...)
 * 프로그램 <=== InputStream (read) <=== 입력 장치(콘솔, 키보드, 마우스, 파일, ...)
 * 
 * 프로그램 ===> FileOutputStream (write) ===> 파일
 * 프로그램 <=== FileInputStream (read) <=== 파일
 * 
 * java.io.InputStream: 프로그램이 데이터를 읽어들이는 통로.
 * |__ FileInputStream: 프로그램이 파일에서 데이터를 읽어들이는 통로.
 *   (1) FileInputStream 객체 생성.
 *   (2) FIS 객체의 read 관련 메서드 호출.
 *   (3) FIS 객체를 닫음(close).
 * 
 * java.io.OutputStream: 프로그램이 데이터를 쓰는 통로.
 * |__ FileOutputStream: 프로그램이 파일에 데이터를 쓰는 통로.
 *   (1) FileOutputStream 객체 생성.
 *   (2) FOS 객체의 write 관련 메서드 호출.
 *   (3) FOS 객체를 닫음(close). 
 */

public class FileMain01 {

    public static void main(String[] args) {
        // data/hello.txt 파일의 내용을 읽고, data/hello_copy.txt 파일로 복사.
        String origin = "data/hello.txt";
        String destination = "data/hello_copy.txt";
        
        FileInputStream in = null; // 파일 읽기 통로
        FileOutputStream out = null; // 파일 쓰기 통로
        try {
            in = new FileInputStream(origin); // FIS 객체 생성
            out = new FileOutputStream(destination); // FOS 객체 생성
            
            while (true) { // 무한 반복문
                int read = in.read(); // 파일에서 1바이트를 읽음.
                if (read == -1) { // 파일 끝(EOF, end-of-file)에 도달했을 때
                    break; // 무한 반복문 종료.
                }
                //System.out.println((char) read);
                
                out.write(read); // 1바이트를 파일에 씀.
            }
            System.out.println("파일 복사 종료");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close(); // FIS 닫음.
                out.close(); // FOS 닫음.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
