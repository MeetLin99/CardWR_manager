package com.java.a;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainMenu extends JFrame implements ActionListener{
	JButton s1=new JButton("查询一周未取卡");
	JButton	s2=new JButton("修改卡信息");
	mainMenu(){
		super("管理端");
		this.setLayout(null);
		setSize(900,500);
		s1.addActionListener(this);
		s2.addActionListener(this);
		s1.setBounds(150,150,200,200);
		s2.setBounds(600,150,200,200);
		add(s1);
		add(s2);
		this.setVisible(true);
	}

	public void  actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==s1) {
			new J3().setVisible(true);
			this.dispose();
		}
		if(ob==s2) {
			new J4().setVisible(true);
			this.dispose();
		}
	}
}
