package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

    public static void main(String[] args) {
        Random random = new Random();
        
        // Student 타입 객체 100만개를 저장하는 ArrayList 더미 데이터를 생성.
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            int korean = random.nextInt(101);
            int english = random.nextInt(101);
            int math = random.nextInt(101);
            Score score = new Score(korean, english, math);
            Student student = new Student(i, "Name_" + i, score);
            list.add(student);
        }
        
        System.out.println("list size = " + list.size());
        System.out.println("first: " + list.getFirst());
        System.out.println("last: " + list.getLast());
        int index = random.nextInt(1_000_000);
        System.out.println("[" + index + "] " + list.get(index));
        
        // 파일 이름 상수:
        final String fileName = "data/studentlist.dat";
        
        // 더미 데이터를 파일에 쓰면서 경과 시간을 측정.
        FileOutputStream out = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bos);
            
            long start = System.currentTimeMillis();
            
            oos.writeObject(list);
            
            long end = System.currentTimeMillis();
            System.out.println("파일 쓰기 경과 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // 파일에서 데이터를 읽고, 경과 시간을 측정. 데이터 확인.
        try ( // 리소스 생성 -> 자동으로 close() 메서드가 호출.
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(in);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            long start = System.currentTimeMillis();
            
            ArrayList<Student> result = (ArrayList<Student>) ois.readObject();
            
            long end = System.currentTimeMillis();
            System.out.println("파일 읽기 경과 시간: " + (end - start) + "ms");
            
            System.out.println("first: " + result.getFirst());
            System.out.println("last: " + result.getLast());
            System.out.println("[" + index + "] " + result.get(index));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
