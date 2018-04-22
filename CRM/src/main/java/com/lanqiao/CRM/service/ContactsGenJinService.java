package com.lanqiao.CRM.service;

import java.util.List;

import com.lanqiao.CRM.entity.ContactsGenJin;


public interface ContactsGenJinService {

	public List<ContactsGenJin>  findByContacts(String contacts);
	public void insert(ContactsGenJin contacts);
}
