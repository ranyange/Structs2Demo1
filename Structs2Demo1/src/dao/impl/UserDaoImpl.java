package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import  dao.UserDao;
import  entity.User;
import  util.DBCPUtil;
 

public class UserDaoImpl implements UserDao {
	public void insert(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try{
			//1.�������
			conn = DBCPUtil.getConnection();
			//2.���pstm
			pstm = conn.prepareStatement("insert into table_user values(seq_user.nextval,?,?,?,?)");
			//3.��user�󶨵�sql��
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getNickname());
			pstm.setString(3, user.getPassword());
			pstm.setInt(4, user.getLocked());
			//4.ִ��sql
			pstm.executeUpdate();
			
			
		}catch(Exception e){
			throw new RuntimeException("insert User�����쳣",e);
		}finally{
			//5.�ͷ���Դ  pstm
			DBCPUtil.close(null, pstm, null);
		}
		
	}

	public User queryUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		
		conn = DBCPUtil.getConnection();
		 
		String sql = "select id,username,nickname,password,locked from table_user where username = ?";
		
		try{
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("username"),rs.getString("nickname"),rs.getString("password"),rs.getInt("locked"));
			}
			
			return user;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBCPUtil.close(rs, pstm, null);
			
		}
		return user;
	}
}
