package com.lanqiao.CRM.dao;

import java.util.List;
import com.lanqiao.CRM.entity.ContactsGenJin;

public interface ContactsGenJinDao {
	public List<ContactsGenJin>  findByContacts(String contacts);
	public void insert(ContactsGenJin contacts);
}
