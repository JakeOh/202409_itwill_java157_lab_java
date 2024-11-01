package com.itwill.file07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * IO Stream: 바이트 스트림(byte stream). 읽기/쓰기의 기본 단위는 바이트.
 * - 모든 종류의 파일(txt, jpg, png, mp3, mp4, pdf, ...)에서 사용 가능.
 * InputStream
 * |__ FileInputStream, BufferedInputStream, ObjectInputStream, ...
 * OutputStream
 * |__ FileOutputStream, BufferedOutputStream, ObjectOutputStream, ...
 * 
 * Reader/Writer: 문자 스트림(character stream). 읽기/쓰기의 기본 단위는 문자.
 * - 텍스트 파일 형식(txt, csv, ...)에서만 사용 가능.
 * Reader
 * |__ InputStreamReader, BufferedReader
 *     |__ FileReader
 * Writer
 * |__ OutputStreamWriter, BufferedWriter
 *     |__ FileWriter
 * 
 * 인코딩(encoding): 문자열을 그 문자에 매핑된 코드(정수) 값으로 변환. (예) 'A' -> 65
 * 디코딩(decoding): 문자 코드(정수)를 그 코드에 매핑된 문자로 변환. (예) 65 -> 'A'
 * 운영체제(OS)의 기본 인코딩 방식:
 *   - Linux, MacOS, Unix: UTF-8
 *   - 한글 MS-Windows: MS949(CP949, EUC-KR), 영문 MS-Windows: CP1252, ...
 */

public class FileMain07 {

    public static void main(String[] args) throws Exception {
        // 파일 이름들
        final String utf8File = "data/UTF-8.txt";
        final String ansiFile = "data/ANSI.txt";
        
        // Java 11 이전 버전에서 문자 스트림과 인코딩 방식을 다루는 방법:
        // 1. FileInputStream 객체(바이트 스트림)를 생성
        FileInputStream fis = new FileInputStream(ansiFile);
        
        // 2. 인코딩 방식을 설정한 InputStreamReader 객체(문자 스트림)를 생성
        InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
        
        // 3. 읽기 속도를 빠르게 하기 위해서 버퍼(메모리)를 사용 - BufferedReader 생성.
        BufferedReader br = new BufferedReader(isr);
        
        while (true) {
            int read = br.read(); // 파일에서 1글자를 읽음.
            if (read == -1) { // 파일 끝(EOF)
                break;
            }
            System.out.print((char) read); // 읽은 글자를 출력
        }
        
        // 가장 마지막에 생성한 리소스만 해제(close).
        br.close();
        
        // Java 11 버전부터 문자 스트림과 인코딩 방식을 다루는 방법:
        
    }

}
