package com.java.a;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


class J3 extends J2 implements ActionListener{
	JButton b1,b2,b3;
	JTextField t1=new JTextField(12);
	private JScrollPane scpDemo;//数据显示滚动面板
	private JTableHeader jth;//表头
	private JTable tabDemo;//表

	J3(){

		setLayout(new FlowLayout());
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		b1 = new JButton("取卡");
		b2 = new JButton("取出所有卡");
		b3 = new JButton("显示数据");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.scpDemo = new JScrollPane();//数据显示滚动面板

		p2.add(b1);
		p3.add(b2);
		p4.add(b3);
		p5.add(t1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(this.scpDemo);

		this.scpDemo.setBounds(400,30,450,300);//x y 宽 高
		p2.setBounds(250, 50, 80, 200);
		p3.setBounds(700, 340, 200, 200);
		p4.setBounds(440,340 , 200,200);
		p5.setBounds(50, 50, 200, 200);

		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}


	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1){
			String cid = this.t1.getText();
			JDBC x = new JDBC();//创建连接对象
			try {
				x.OpenConn();
				String sql = "select * from lost_record where id="+cid;
				x.rs = x.executeQuery(sql);//获得结果集
				if(x.rs.next()) new J1().setTitle("取出成功！！！");
				else new J1().setTitle("取出失败！！！");

				sql = "delete from lost_record where id="+cid;
				System.out.println(sql);
				x.execute(sql);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}

		if(obj == b2){
			String cid = this.t1.getText();
			JDBC x = new JDBC();//创建连接对象
			try {
				x.OpenConn();
				String sql = "select * from lost_record where id="+cid;
				x.rs = x.executeQuery(sql);
				sql = "delete from lost_record ";
				System.out.println(sql);
				new J1().setTitle("取出成功！！！");
				x.execute(sql);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}


		if(obj == b3){
			JDBC x = new JDBC();//创建连接对象
			try {
				x.OpenConn();
				String sql = "select * from lost_record";
				x.rs = x.executeQuery(sql);

				int count = 0;

				while(x.rs.next())
				{

					count++;
					System.out.println(x.rs.getInt("id"));
				}

				Object[][] info = new Object[count][6];
				String []title= {"id","cardid"," title","content","type_code","status"};
				count = 0;

				while(x.rs.previous())
				{
					info[count][0] = Integer.valueOf( x.rs.getInt("id"));
					info[count][1] = Integer.valueOf( x.rs.getInt("cardid"));
					info[count][2] = x.rs.getString("title");
					info[count][3] = x.rs.getString("content");
					info[count][4] = Integer.valueOf( x.rs.getInt("type_code"));
					info[count][5] = Integer.valueOf( x.rs.getInt("status"));
					count++;


				}

				// 创建JTable
				this.tabDemo = new JTable(info,title);
				// 显示表头
				this.jth = this.tabDemo.getTableHeader();
				// 将JTable加入到带滚动条的面板中
				this.scpDemo.getViewport().add(tabDemo);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}

	}
}

