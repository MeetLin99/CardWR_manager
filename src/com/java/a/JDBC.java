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

	//���ݿ����Ӳ�������
	public static void OpenConn() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cardwr?serverTimezone=UTC&characterEncoding=utf-8";
			String username = "root";
			String password = "0000";//�������㰲װmysqlʱ������
			conn = DriverManager.getConnection(url,username,password);
			if(conn != null) System.out.println("���ݿ����ӳɹ�");
		}catch(Exception e) {
			System.err.println("���ݿ����ӣ�"+e.getMessage()+"\n");
		}
	}




	//ִ�����ݲ�ѯ�ķ���
	public ResultSet executeQuery(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			System.err.println("��ѯ���ݣ�"+e.getMessage());
		}
		return rs;
	}




	//ִ�д������ݱ��������ݵȲ���
	public void execute(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}


	//�������ݿ��������
	public void executeUpdate(String sql) {
		stmt = null; rs = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			conn.setAutoCommit(false);
			conn.commit();//�ύ
		}catch(SQLException e) {
			System.err.println("��������"+e.getMessage());
		}
	}


	//�ر�statement����ķ���
	public void closeStmt() {
		try {
			stmt.close();
		}catch(SQLException e){
			System.err.println("�ͷŶ���"+e.getMessage());
		}
	}
	//�ر����ݿ�ķ���
	public void closeConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.err.println("�ͷŶ���"+e.getMessage());
		}
	}
}