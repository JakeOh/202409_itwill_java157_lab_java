package com.itwill.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 파일 ==> FileInputStream ==> BufferedInputStream ==> 프로그램
 * FIS: 하드디스크에 저장된 파일을 직접 접근해서 데이터를 읽고 메모리(RAM)에 적재.
 * BIS: 메모리(RAM)에 있는 파일 내용을 읽는(read) 메서드를 제공.
 * (1) FIS 객체 생성. (2) BIS 객체 생성. (3) 프로그램에서는 BIS의 read 메서드만 호출하면 됨.
 * 
 * 파일 <== FileOutputStream <== BufferedOutputStream <== 프로그램
 * FOS: 하드디스크의 파일에 데이트 씀.
 * BOS: 메모리(RAM)에 데이터를 쓰는(write) 메서드를 제공.
 * (1) FOS 객체 생성. (2) BOS 객체 생성. (3) 프로그램에서는 BOS의 write 메서드만 호출하면 됨.
 */

public class FileMain03 {

    public static void main(String[] args) {
        // BIS, BOS을 사용한 파일 복사

        final String origin = "data/ratings.dat";
        final String destination = "data/ratings_copy2.dat";
        
        FileInputStream in = null;
        BufferedInputStream bin = null;
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        try {
            in = new FileInputStream(origin);
            bin = new BufferedInputStream(in);
//            bin = new BufferedInputStream(new FileInputStream(origin));
            
            out = new FileOutputStream(destination);
            bout = new BufferedOutputStream(out);
            
            long start = System.currentTimeMillis(); // 복사 시작 시간
            
            while (true) {
                byte[] buffer = new byte[4 * 1024]; // 4KB 배열
                int b = bin.read(buffer); // RAM(메모리)에서 파일 내용을 배열에 읽음.
                if (b == -1) { // EOF(파일 끝)
                    break;
                }
                
                bout.write(buffer, 0, b); // RAM(메모리)에 파일 내용(배열)을 씀.
            }
            
            long end = System.currentTimeMillis(); // 복사 종료 시간
            System.out.println("복사 경과 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 리소스 해제 순서는 나중에 만들어진 리소스를 먼저 해제하고, 
                // 이전에 만들어진 리소스를 나중에 해제해야 함. (생성자 호출 순서의 반대로 close호출)
                // 가장 마지막에 생성된 스트림 객체만 close를 하면, 
                // 이전에 생성된 스트림 객체들도 순서대로 close가 됨.
                bin.close(); //-> FIS은 자동으로 close.
                bout.close(); //-> FOS은 자동으로 close.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
