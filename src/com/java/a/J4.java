package com.java.a;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class J4  extends JFrame  implements ActionListener {
	JButton b1;
	JTextField t1=new JTextField(12);//account
	JTextField t2=new JTextField(12);//cnumber
	J4(){
		setTitle("�û���Ϣά��");
		setSize(600,300);
		setVisible(true);
		JLabel l1 = new JLabel("account");
		JLabel l2 = new JLabel("cnumber");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		b1 = new JButton("�ύ");
		p1.add(l1); p1.add(t1);
		p2.add(l2); p2.add(t2);
		this.getContentPane().add(b1);
		p1.setBounds(190, 50, 200, 200);
		p2.setBounds(20, 100, 200, 200);
		b1.setBounds(230, 120, 80, 50);
		add(p1); add(p2);
		b1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1){
			String phone1 = this.t1.getText();
			String id1 = this.t2.getText();
			JDBC x = new JDBC();//�������Ӷ���
			try {
				x.OpenConn();
				String sql = "select * from lost_users where phone="+phone1;
				x.rs = x.executeQuery(sql);//��ý����
				if(x.rs.next()) new J1().setTitle("�ύ�ɹ�������");
				else new J1().setTitle("�ύʧ�ܣ�����");

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
