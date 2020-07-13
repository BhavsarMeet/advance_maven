package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BookBean;
import com.util.DBConnectionMysql;
import com.util.DBConnectionPostgres;

public class BookDoa
{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean addBook(BookBean bb)
	{
		boolean flag=false;
		conn=DBConnectionPostgres.getDBConnection();
		
		if(conn!=null)
		{
			String insertSQL="insert into book(bname,bqty,bprice,aid)values(?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,bb.getbName() );
				pstmt.setInt(2,bb.getbQty());
				pstmt.setInt(3,bb.getbPrice());
				pstmt.setInt(4, bb.getaId());
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
	
	public ArrayList<BookBean> BookDataRetrive()
	{
		ArrayList<BookBean> dataofbooks=new ArrayList<BookBean>();
		conn=DBConnectionPostgres.getDBConnection();
		
		if(conn!=null)
		{
			String selectSQL="select bid,bname,bqty,bprice,aname from book join author on book.aid=author.aid";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					BookBean bb=new BookBean();
					bb.setbId(rs.getInt("bid"));
					bb.setbName(rs.getString("bname"));
					bb.setbPrice(rs.getInt("bprice"));
					bb.setbQty(rs.getInt("bqty"));
					bb.setaName(rs.getString("aname"));
					
					dataofbooks.add(bb);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return dataofbooks;
	}
	
	public boolean deleteBook(int bId)
	{
		boolean flag=false;
		conn=DBConnectionPostgres.getDBConnection();
		
		if(conn!=null)
		{
			String deleteSQL="delete from book where bid=?";
			try {
				pstmt=conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, bId);
				int res=pstmt.executeUpdate();
				if(res>0)
				{
					flag=true;
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}
	
	public BookBean getById(int bId)
	{
		conn=DBConnectionPostgres.getDBConnection();
		BookBean bb=null;
		if(conn!=null)
		{
			String selectSQL="select * from book where bid=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1,bId);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					bb=new BookBean();
					bb.setbId(rs.getInt("bid"));
					bb.setbName(rs.getString("bname"));
					bb.setbPrice(rs.getInt("bprice"));
					bb.setbQty(rs.getInt("bqty"));
					bb.setaId(rs.getInt("aid")); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return bb;
	}
	
	public boolean updateBook(BookBean bb)
	{
		boolean flag=false;
		conn=DBConnectionPostgres.getDBConnection();
		
		if(conn!=null)
		{
			String updateSQl="update book set bname=?,bprice=?,bqty=?,aid=? where bid=?";
			try {
				pstmt=conn.prepareStatement(updateSQl);
				pstmt.setString(1,bb.getbName());
				pstmt.setInt(2,bb.getbPrice());
				pstmt.setInt(3,bb.getbQty());
				pstmt.setInt(4, bb.getaId());
				pstmt.setInt(5, bb.getbId());
				
				
				int res=pstmt.executeUpdate();
				if(res>0)
				{
					System.out.println("done");
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		return flag;
	}
}
