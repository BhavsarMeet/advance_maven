package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.util.DBConnectionMysql;
import com.util.DBConnectionPostgres;

public class AdminDoa
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AdminBean LoginAdmin(String aEmail,String aPassword)
	{
		conn=DBConnectionPostgres.getDBConnection();
		AdminBean ab=null;
			
		if(conn!=null)
		{
			String selectSQL="select * from admin where aemail=? and apassword=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, aEmail);
				pstmt.setString(2, aPassword);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					ab=new AdminBean();
					ab.setaId(rs.getInt("aid"));
					System.out.println(ab.getaId());
					ab.setaName(rs.getString("aname"));
					ab.setaEmail(rs.getString("aemail"));
					ab.setaPassword(rs.getString("apassword"));
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ab;
	}
}
