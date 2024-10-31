package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain02 {

    public static void main(String[] args) throws IOException {
        // 대용량 파일 복사:
        // data/ratings.dat 파일(23MB)을 읽고, data/ratings_copy.dat 파일에 복사.
        // (1) FIS.read(), FOS.write(int b) 메서드를 사용할 때 시간 측정.
        // (2) 다른 read/write 메서드를 사용할 때 시간 측정.
        // try-catch-finally 대신에 main 메서드에서 throws 선언을 추가.
        
        final String origin = "data/ratings.dat"; // 원본 파일 이름.
        final String destination = "data/ratings_copy.dat"; // 복사할 파일 이름.

        FileInputStream in = new FileInputStream(origin); // 파일 읽기 통로.
        FileOutputStream out = new FileOutputStream(destination); // 파일 쓰기 통로.
        
        long start = System.currentTimeMillis(); // 파일 복사 시작 시간 측정.
        
        while (true) {
            // int b = in.read(); // (1) 파일에서 1바이트를 읽음.
            
            byte[] buffer = new byte[4 * 1024]; // 4KB의 메모리.
            int b = in.read(buffer); // (2) read(byte[] buf) 메서드 사용.
            //-> 파라미터 buffer: 파일에서 읽은 내용을 저장하기 위한 바이트 배열.
            //-> 리턴 값 b: 파일에서 실제로 읽은 바이트 수. buffer의 길이보다 작거나 같음.
            
            if (b == -1) { // 파일 끝(EOF)
                break;
            }
            
            // out.write(b); // (1) 파일에 1바이트를 씀.
            
            // out.write(buffer); // (2) write(byte[] buf) 메서드 사용.
            out.write(buffer, 0, b); // (2) write(byte[] buff, int offset, int length)
            //-> 파라미터 byte[] buffer: 파일에 쓸 데이터를 가지고 있는 바이트 배열.
            //-> 파라미터 int offset: 배열에서 읽기 시작할 인덱스.
            //-> 파라미터 int length: 배열에서 실제로 파일에 쓸 바이트 길이(개수).
        }
        
        long end = System.currentTimeMillis(); // 파일 복사 종료 시간 측정.
        System.out.println("파일 복사 시간: " + (end - start) + "ms");
        
        in.close(); // FIS 닫음(리소스 해제).
        out.close(); // FOS 닫음(리소스 해제).
    }

}
