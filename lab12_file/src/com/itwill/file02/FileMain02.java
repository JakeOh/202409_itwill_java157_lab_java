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
            int b = in.read(); // 파일에서 1바이트를 읽음.
            if (b == -1) { // 파일 끝(EOF)
                break;
            }
            out.write(b); // 파일에 1바이트를 씀.
        }
        
        long end = System.currentTimeMillis(); // 파일 복사 종료 시간 측정.
        System.out.println("파일 복사 시간: " + (end - start) + "ms");
        
        in.close(); // FIS 닫음(리소스 해제).
        out.close(); // FOS 닫음(리소스 해제).
    }

}
