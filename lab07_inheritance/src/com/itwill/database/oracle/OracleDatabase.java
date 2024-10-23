package com.itwill.database.oracle;

import com.itwill.database.Database;

public class OracleDatabase implements Database {

    @Override
    public int select() {
        System.out.println("Oracle DB 연결 >>> 자료 검색 >>>");
        return 0;
    }

    @Override
    public int insert(String name, String phone) {
        System.out.println("Oracle DB 연결 >>> name 저장 >>> phone 저장 >>>");
        return 0;
    }

}
