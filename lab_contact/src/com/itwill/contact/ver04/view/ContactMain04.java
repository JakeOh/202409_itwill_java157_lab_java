package com.itwill.contact.ver04.view;

import com.itwill.contact.ver04.controller.ContactDao;
import com.itwill.contact.ver04.model.Contact;

public class ContactMain04 {

    public static void main(String[] args) {
        Contact c = new Contact(0L, "name", "phone", "email");
        ContactDao.INSTANCE.create(c);
    }

}
