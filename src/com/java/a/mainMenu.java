package com.java.a;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.ImageIcon;


public class mainMenu extends JFrame implements ActionListener{
	JButton s1=new JButton("������¼����");
	JButton	s2=new JButton("�û���Ϣά��");
	JButton	s3=new JButton("��Ϣ���͹���");
	mainMenu(){
		super("����һ��ͨʧ������ϵͳ");
		this.setLayout(null);
		setSize(700,290);//500 300
		s1.addActionListener(this);
		s2.addActionListener(this);
		s2.addActionListener(this);
		s1.setBounds(110,70,130,100);
		s2.setBounds(280,70,130,100);
		s3.setBounds(450,70,130,100);
		add(s1);
		add(s2);
		add(s3);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void  actionPerformed(ActionEvent e) {//��Ӧ��
		Object ob=e.getSource();
		if(ob == s1) {
			new J3().setVisible(true);
			//this.dispose();
		}
		else if(ob == s2) {
			new J4().setVisible(true);
			//this.dispose();
		}
		//else if(ob == s3) {
			//new J4().setVisible(true);
			//this.dispose();
		//}
	}
}
