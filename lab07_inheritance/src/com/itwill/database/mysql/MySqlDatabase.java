package com.itwill.database.mysql;

import com.itwill.database.Database;

public class MySqlDatabase implements Database {

    @Override
    public int select() {
        System.out.println("MySQL 연결 >>> 자료 검색 >>>");
        return 1;
    }

    @Override
    public int insert(String name, String phone) {
        System.out.println("MySQL 연결 >>> 자료 저장 >>>");
        return 1;
    }

}
