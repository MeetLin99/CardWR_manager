package com.java.a;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class J2 extends J1 {

	JTextField t1=new JTextField(12);//¿¨ºÅ
	J2(){
		setLayout(new GridLayout(2,2));
		JLabel l1 = new JLabel("Ñ§Éú¿¨ºÅ");
		JPanel p1 = new JPanel();
		p1.add(l1);
		p1.add(t1);
		add(p1);
	}
}