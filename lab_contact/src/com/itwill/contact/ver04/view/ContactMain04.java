package com.itwill.contact.ver04.view;

import java.util.ArrayList;
import java.util.List;

import com.itwill.contact.ver04.model.Contact;
import com.itwill.contact.ver04.util.FileUtil;

public class ContactMain04 {

    public static void main(String[] args) {
        FileUtil.initializeDataDir();
        
        Contact c = new Contact(0L, "name", "1234", "@");
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(c);
        Contact c2 = new Contact();
        contacts.add(c2);
        FileUtil.writeDataToFile(contacts);
        
        List<Contact> list = FileUtil.readDataFromFile();
        System.out.println(list);
    }

}
