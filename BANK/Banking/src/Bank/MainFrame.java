package Bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame implements ActionListener{
	
//	JFrame frame;
	static JButton exit,login;
	static JTextField username, password;
	static JLabel uname,paaswd;
	
	MainFrame(){
		 JFrame frame = new JFrame("Welcome to World Bank");
		
		 
		 JLabel title = new JLabel("Login");
		 title.setFont(new Font("Times new roman",Font.BOLD,35));
		 title.setForeground(new Color(80,80,80));
		 title.setBounds(200,10,200,50);
		 frame.add(title);
		 
		 uname = new JLabel("Username");
		 uname.setBounds(50,150,100,30);
		 uname.setFont(new Font("Times new roman",Font.PLAIN,18));
		 frame.add(uname);
		 
		 paaswd = new JLabel("Password");
		 paaswd.setFont(new Font("Times new roman",Font.PLAIN,18));
		 paaswd.setBounds(50,230,100,30);
		 frame.add(paaswd);
		 
		 username = new JTextField();
		 username.setBounds(200,150,200,30);
		 username.setFont(new Font("Times new roman",Font.PLAIN,18));
		 frame.add(username);
		 
		 password = new JTextField();
		 password.setBounds(200,230,200,30);
		 password.setFont(new Font("Times new roman",Font.PLAIN,18));
		 frame.add(password);
		 
		 
		 login = new JButton("Login");
		 login.setBackground(Color.green);
		 login.setForeground(Color.WHITE);
		 login.setBounds(100,300,100,30);
		 login.setFont(new Font("Times new roman",Font.PLAIN,18));
		 frame.add(login);
		 
		 
		 exit = new JButton("Exit");
		 exit.setBackground(Color.RED);
		 exit.setForeground(Color.WHITE);
		 exit.setBounds(250,300,100,30);
		 exit.setFont(new Font("Times new roman",Font.PLAIN,18));
		 exit.addActionListener(this);
		 frame.add(exit);
		 
		 
		 
//		frame.pack();
		frame.setLayout(null);
		frame.setSize(500,500);
		 frame.setVisible(true);
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
