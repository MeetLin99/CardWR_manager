package com.java.a;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

class J3 extends J2 implements ActionListener{
	JButton b1,b2,b3;
	JTextField t1=new JTextField(12);
	private JScrollPane scpDemo;//������ʾ�������
	private JTableHeader jth;//��ͷ
	private JTable tabDemo;//��

	J3(){
		setLocationRelativeTo(null);
		setLayout(null);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		setSize(750,500);
		b1 = new JButton("ȡ��");
		b2 = new JButton("ȡ�����п�");
		b3 = new JButton("��ʾ����");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.scpDemo = new JScrollPane();//������ʾ�������

		p2.add(b1);//ȡ��
		p3.add(b2);
		p4.add(b3);
		p5.add(t1);//�ı���
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(this.scpDemo);

		this.scpDemo.setBounds(100,30,550,300);//x y �� ��
		p2.setBounds(200, 340, 200, 200);
		p3.setBounds(510, 390, 200, 200);
		p4.setBounds(515, 340, 200,200);
		p5.setBounds(70, 340, 200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}


	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1){
			String cid = this.t1.getText();
			JDBC x = new JDBC();//�������Ӷ���
			try {
				x.OpenConn();
				String sql = "select * from lost_record where id="+cid;
				x.rs = x.executeQuery(sql);//��ý����
				if(x.rs.next()) new J1().setTitle("ȡ���ɹ�������");
				else new J1().setTitle("ȡ��ʧ�ܣ�����");

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
			JDBC x = new JDBC();//�������Ӷ���
			try {
				x.OpenConn();
				String sql = "select * from lost_record where id="+cid;
				x.rs = x.executeQuery(sql);
				sql = "delete from lost_record ";
				System.out.println(sql);
				new J1().setTitle("ȡ���ɹ�������");
				x.execute(sql);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}


		if(obj == b3){
			JDBC x = new JDBC();//�������Ӷ���
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
				String []title= {"���","�����к�"," ʱ��","λ��","����","״̬"};
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

				// ����JTable
				this.tabDemo = new JTable(info,title);
				// ��ʾ��ͷ
				this.jth = this.tabDemo.getTableHeader();
				// ��JTable���뵽���������������
				this.scpDemo.getViewport().add(tabDemo);

			}catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
			x.closeStmt();
			x.closeConn();
		}

	}
}

