package com.itwill.contact.ver04.view;

import java.util.Scanner;

import com.itwill.contact.ver04.controller.ContactDao;

public class ContactMain04 {
    
    private Scanner scanner;
    private ContactDao dao;
    
    public ContactMain04() {
        scanner = new Scanner(System.in);
        dao = ContactDao.INSTANCE;
    }

    public static void main(String[] args) {
        
    }

}
