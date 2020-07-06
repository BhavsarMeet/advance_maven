package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.bean.UsersBean;
import com.util.DBConnectionMysql;
import com.util.DBConnectionPostgres;

public class UsersDao 
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public boolean addUsers(UsersBean ab)
	{
		boolean flag=false;
		conn=DBConnectionPostgres.getDBConnection();
		
		if(conn!=null)
		{
			String insertSql="insert into users(uname,uage,uemail,upassword)values(?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(insertSql);
				
				pstmt.setString(1, ab.getuName());
				pstmt.setInt(2, ab.getuAge());
				pstmt.setString(3, ab.getuEmail());
				pstmt.setString(4, ab.getuPassword());
				
				int res=pstmt.executeUpdate();
				
				if(res>0)
					flag=true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return flag;
	}
	public UsersBean LoginUsers(String uEmail,String uPassword)
	{
		conn=DBConnectionPostgres.getDBConnection();
		UsersBean ub=null;
			
		if(conn!=null)
		{
			String selectSQL="select * from users where uemail=? and upassword=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, uEmail);
				pstmt.setString(2, uPassword);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					ub=new UsersBean();
					ub.setuId(rs.getInt("uid"));
					ub.setuName(rs.getString("uname"));
					ub.setuEmail(rs.getString("uemail"));
					ub.setuPassword(rs.getString("upassword"));
					ub.setuAge(rs.getInt("uage"));
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ub;
	}

}
