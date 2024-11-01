package com.itwill.file08;

import java.io.File;

/*
 * 파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제, 이름변경, ...
 * 
 * 현재 작업 폴더(CWD: Current Working Directory):
 *   - 현재 프로그램(프로세스)가 실행되는 폴더 위치.
 *   - 이클립스에서 자바 프로그램을 실행(Run as a Java app.)할 때, 
 *   현재 작업 폴더의 위치는 프로젝트 폴더.
 * 절대 경로(absolute path):
 *   - 시스템의 루트(C:\, D:\, /)부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식.
 *   - (MS Windows 예) C:\java157\worksapce\lab-java\...txt
 *   - (Linux, MacOS 예) /users/itwill/documents/...txt
 * 상대 경로(relative path):
 *   - 현재 작업 폴더를 기준으로 파일 또는 폴더가 있는 위치를 찾아가는 방식.
 *   - (MS Windows 예) data\...txt
 *   - (Linux, MacOS 예) data/...txt
 */


public class FileMain08 {

    public static void main(String[] args) {
        // 절대 경로
        String path1 = "C:\\java157\\workspaces\\lab-java\\lab12_file\\data\\ANSI.txt";
        System.out.println(path1);
        
        // 상대 경로
//        String path2 = "data\\ANSI.txt"; // MS-Windows에서만 사용 가능한 표기법
        // File.separator: OS에 의존적인 파일 구분자(/ 또는 \)를 자동으로 선택.
        String path2 = "data" + File.separator + "ANSI.txt";
        System.out.println(path2);

        // File 클래스:
        // 파일(txt, jpg, mp4, ...)과 폴더(디렉토리)에 관련된 기능(메서드)들을 가지고 있는 클래스(타입).
        File f = new File(path2);
        System.out.println("절대 경로: " + f.getAbsolutePath());
        System.out.println("존재 여부: " + f.exists());
        System.out.println("파일 여부: " + f.isFile());
        System.out.println("폴더 여부: " + f.isDirectory());
        System.out.println("파일 크기: " + f.length());
        
        // 새 폴더 만들기
        File testFolder = new File("data", "test"); // 상대 경로 data/test
        if (testFolder.exists()) {
            System.out.println("이미 test 폴더가 존재합니다.");
        } else {
            boolean result = testFolder.mkdir();  // make directory. 폴더 생성
            if (result) {
                System.out.println("폴더 생성 성공");
            } else {
                System.out.println("폴더 생성 실패");
            }
        }
        
        // 폴더 삭제
        if (testFolder.exists()) {
            boolean result = testFolder.delete();
            if (result) {
                System.out.println("폴더 삭제 성공");
            } else {
                System.out.println("폴더 삭제 실패");
            }
        } else {
            System.out.println("test 폴더가 존재하지 않습니다.");
        }
        
    }

}
