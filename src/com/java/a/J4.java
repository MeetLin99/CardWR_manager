package com.java.a;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class J4  extends JFrame  implements ActionListener {
	JButton b1;
	JTextField t1=new JTextField(12);//account
	JTextField t2=new JTextField(12);//cnumber
	J4(){

		setTitle("修改卡信息");
		setSize(900,500);

		//getContentPane().setBackground(Color.red);
		//getContentPane().setVisible(true);//如果改为true那么就变成了红色。
		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		this.setLayout(null);
		JLabel l1 = new JLabel("学号：");
		JLabel l2 = new JLabel("新卡序列号：");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		b1 = new JButton("提交");

		p1.add(l1);
		p1.add(t1);

		p2.add(l2);
		p2.add(t2);
		add(p1);
		add(p2);

		this.getContentPane().add(b1);
		p1.setBounds(200, 180, 400, 30);
		p2.setBounds(200, 220, 400, 30);
		b1.setBounds(400, 270, 80, 30);
		b1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1){
			String phone1 = this.t1.getText();
			String id1 = this.t2.getText();
			JDBC x = new JDBC();//创建连接对象
			try {
				x.OpenConn();
				String sql = "select * from lost_users where phone="+phone1;
				x.rs = x.executeQuery(sql);//获得结果集
				if(x.rs.next()) new J1().setTitle("提交成功！！！");
				else new J1().setTitle("提交失败！！！");

				sql="update lost_users set id='"+id1+"'"+"where phone="+phone1;
				System.out.println(sql);
				x.executeUpdate(sql);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}

	}
}
