package biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import  biz.ContactBiz;
import  dao.ContactDao;
import  dao.impl.ContactDaoImpl;
import  entity.Contact;
import  util.DBCPUtil;
 

public class ContactBizImpl implements ContactBiz {

	public void updateContact(Contact contact) {
		//不甘心这样,轻易被你掌握,天下我已经唾手可得;
		Connection conn = null;
		ContactDao contactDao = new ContactDaoImpl();
		
		
		conn = DBCPUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			contactDao.alterContact(contact);
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			DBCPUtil.close(null,null,conn);
		}
		
		
		
		
		
	}

	public void insertContact(Contact contact) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ContactDao contactDao = new ContactDaoImpl();
		conn = DBCPUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			contactDao.addContact(contact);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			DBCPUtil.close(null,null,conn);
		}
	}

	public void delContact(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = DBCPUtil.getConnection();
		ContactDao contactDao = new ContactDaoImpl();
		try {
			conn.setAutoCommit(false);
			contactDao.deleteContactById(id);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBCPUtil.close(null, null, conn);
		}
		
	}

	public List<Contact> queryAllContact() {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = DBCPUtil.getConnection();
		ContactDao contactDao = new ContactDaoImpl() ;
		
			 
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactDao.listAll();
		DBCPUtil.close(null, null, conn);
		return contacts;
	}
	
	
}
