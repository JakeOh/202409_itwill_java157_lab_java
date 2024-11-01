package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import com.itwill.file04.Product;

public class FileMain05 {

    public static void main(String[] args) {
        // Product를 원소로 하는 List를 파일에 쓰기, 읽기.
        // List가 저장하는 원소의 개수가 아주 클 때, 쓰기/읽기 속도 측정.

        final String fileName = "data/productlist.dat";
        
        // 더미 데이터
        Random random = new Random();
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            Product p = new Product(i, "Product_" + i, random.nextDouble(1_000));
            list.add(p);
        }
        System.out.println("list size = " + list.size());
        System.out.println("first: " + list.get(0)); // list.getFisrt()
        System.out.println("last: " + list.getLast());
        
        // 파일 쓰기(직렬화)
        try ( // 리소스 생성:
                // Ctrl+Shift+O: optimize imports. import 문장 정리.
                FileOutputStream in = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(in);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            long start = System.currentTimeMillis(); // 파일 쓰기 시작 시간.
            
            oos.writeObject(list); // 100만개 원소를 갖는 리스트 객체를 파일에 쓰기.
            
            long end = System.currentTimeMillis(); // 파일 쓰기 종료 시간.
            System.out.println("파일 쓰기 경과 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 List 객체 읽기:
        FileInputStream in = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            in = new FileInputStream(fileName);
            bis = new BufferedInputStream(in);
            ois = new ObjectInputStream(bis);
            
            long start = System.currentTimeMillis(); // 파일 읽기 시작 시간
            
            ArrayList<Product> result = (ArrayList<Product>) ois.readObject(); // 파일 읽기
            
            long end = System.currentTimeMillis(); // 파일 읽기 종료 시간
            System.out.println("파일 읽기 경과 시간: " + (end - start) + "ms");
            
            // 데이터 확인:
            System.out.println("first: " + result.getFirst()); // result.get(0)
            System.out.println("last: " + result.getLast());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                //-> 가장 마지막에 생성된 스트림 (리소스)만 close(해제)하면,
                // 그 스트림 리소스가 사용하고 있던 다른 리소스들은 자동으로 close가 호출됨.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
