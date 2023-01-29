package Bank;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class UpdateInfo implements ActionListener{
	
	JTextField name,address;
	JLabel Title,name_lbl,addr_lbl;
	JButton save,exit,delete;
	Conn con;
	String ac_no;
	JFrame frame;
	
	
	UpdateInfo(String ac_no,String cust_name,String addr){
		this.ac_no = ac_no;
		con = new Conn();
		 frame = new JFrame("Upadate Info");
		frame.setSize(500,500);
		frame.setLayout(null);
		
		Title = new JLabel("Update Customer Info");
		Title.setBounds(100,20,200,30);
		Title.setFont(new Font("times new roman",Font.BOLD,20));
		frame.add(Title);
		
		name_lbl = new JLabel("Name");
		name_lbl.setBounds(50,100,100,30);
		name_lbl.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(name_lbl);
		
		addr_lbl = new JLabel("Address");
		addr_lbl.setBounds(50,170,100,30);
		addr_lbl.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(addr_lbl);
		
		
		name = new JTextField(cust_name);
		name.setBounds(200,100,200,30);
		name.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(name);
		
		address = new JTextField(addr);
		address.setBounds(200,170,200,30);
		address.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(address);
		
		save = new JButton("Save");
		save.setBounds(70,230,100,30);
		save.setBackground(Color.GREEN);
		save.setForeground(Color.WHITE);
		save.setFont(new Font("times new roman",Font.PLAIN,18));
		save.addActionListener(this);
		frame.add(save);
		
		delete = new JButton("Delete");
		delete.setBounds(200,230,100,30);
		delete.setFont(new Font("times new roman",Font.PLAIN,18));
		delete.setBackground(Color.RED);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		frame.add(delete);
		
		exit = new JButton("Exit");
		exit.setBounds(330,230,100,30);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.addActionListener(this);
		frame.add(exit);
		
		
		this.frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()== exit) {
			this.frame.dispose();
		}
		else if(e.getSource()== save) {
			int res = con.update(this.ac_no, name.getText(), address.getText());
			if(res != 0) {
				JOptionPane.showMessageDialog(this.frame, "Upated Successfully...");
			}
		}
		else if(e.getSource()== delete) {
			int res  = con.delete(ac_no);
			if(res != 0) {
				JOptionPane.showMessageDialog(this.frame, "Customer deleted Successfully...");
			}
		}
		
	}
}
