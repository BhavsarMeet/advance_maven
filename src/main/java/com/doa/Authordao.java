package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.AuthorBean;
import com.util.DBConnectionMysql;
import com.util.DBConnectionPostgres;

public class Authordao 
{
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public ArrayList<AuthorBean> authorlist()
	{
		ArrayList<AuthorBean> authorList=new ArrayList<AuthorBean>();
		
		conn=DBConnectionPostgres.getDBConnection();
		if(conn!=null)
		{
			String selectSQL="select * from author";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					AuthorBean ab=new AuthorBean();
					ab.setaId(rs.getInt("aid"));
					ab.setaName(rs.getString("aname"));
					authorList.add(ab);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return authorList;
	}
}
