package Bank;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class NewCust implements ActionListener{
	
	JTextField name,address,branch;
	JLabel Title,name_lbl,addr_lbl,br_lbl;
	JButton save,exit;
	Conn con;
	JFrame frame;
	
	
	NewCust(){
		
		con = new Conn();
		 frame = new JFrame("New Customer");
		frame.setSize(500,500);
		frame.setLayout(null);
		
		Title = new JLabel("Create New Customer");
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
		
		br_lbl = new JLabel("Branch");
		br_lbl.setBounds(50,240,100,30);
		br_lbl.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(br_lbl);
		
		
		name = new JTextField();
		name.setBounds(200,100,200,30);
		name.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(name);
		
		address = new JTextField();
		address.setBounds(200,170,200,30);
		address.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(address);
		
		branch = new JTextField();
		branch.setBounds(200,240,200,30);
		branch.setFont(new Font("times new roman",Font.PLAIN,18));
		frame.add(branch);
		
		save = new JButton("Save");
		save.setBounds(100,290,100,30);
		save.setBackground(Color.GREEN);
		save.setForeground(Color.WHITE);
		save.setFont(new Font("times new roman",Font.PLAIN,18));
		save.addActionListener(this);
		frame.add(save);

		
		exit = new JButton("Exit");
		exit.setBounds(230,290,100,30);
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
			int res = con.Create(branch.getText(), name.getText(), address.getText());
			if(res != 0) {
				JOptionPane.showMessageDialog(this.frame, "User Created Successfully...\n Your Accont Number is "+res);
			}
			else {
				JOptionPane.showMessageDialog(this.frame, "An error occured. Try again...");
			}
		}
		
		}
		
	}

