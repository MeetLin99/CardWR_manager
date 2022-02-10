package com.java.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC {
	static Connection conn = null;
	static java.sql.Statement stmt;
	static ResultSet rs;
	static String sql;

	//数据库连接操作方法
	public static void OpenConn() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cardwr?serverTimezone=UTC&characterEncoding=utf-8";
			String username = "root";
			String password = "0000";//密码是你安装mysql时的密码
			conn = DriverManager.getConnection(url,username,password);
			if(conn != null) System.out.println("数据库连接成功");
		}catch(Exception e) {
			System.err.println("数据库连接："+e.getMessage()+"\n");
		}
	}




	//执行数据查询的方法
	public ResultSet executeQuery(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			System.err.println("查询数据："+e.getMessage());
		}
		return rs;
	}




	//执行创建数据表、插入数据等操作
	public void execute(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}


	//更新数据库操作方法
	public void executeUpdate(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			conn.setAutoCommit(false);
			conn.commit();//提交
		}catch(SQLException e) {
			System.err.println("更新数据"+e.getMessage());
		}
	}


	//关闭statement对象的方法
	public void closeStmt() {
		try {
			stmt.close();
		}catch(SQLException e){
			System.err.println("释放对象"+e.getMessage());
		}
	}
	//关闭数据库的方法
	public void closeConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.err.println("释放对象"+e.getMessage());
		}
	}
}