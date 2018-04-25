package com.lanqiao.CRM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ContactsGenJinDao;
import com.lanqiao.CRM.entity.ContactsGenJin;
import com.lanqiao.CRM.service.ContactsGenJinService;



@Service
public class ContactsGenJinServiceImpl implements ContactsGenJinService{
	
	@Autowired
    private ContactsGenJinDao contactsGenJin;

	public void setContactsGenJin(ContactsGenJinDao contactsGenJin) {
		this.contactsGenJin = contactsGenJin;
	}

	@Override
	public List<ContactsGenJin> findByContacts(String contacts) {
		// TODO Auto-generated method stub
		return contactsGenJin.findByContacts(contacts);
	}

	@Override
	public void insert(ContactsGenJin contacts) {
		// TODO Auto-generated method stub
		contactsGenJin.insert(contacts);
	}

	
}
