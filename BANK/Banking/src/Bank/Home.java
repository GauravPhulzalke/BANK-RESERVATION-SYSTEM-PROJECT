package Bank;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Home implements ActionListener, KeyListener {

    JLabel search_label, details, name_label, name, address_lbl, address, ac_no_label, ac_no, branch_label, branch;
    JTextField serachbar;
    JButton Search, create_new, view_balance, Credit, debit, update_info;
    String acc_no,cust_name,addr;
    Conn con;
    JFrame frame;
    

    Home() {
    	con = new Conn();
        frame = new JFrame("Home");

        search_label = new JLabel("Search Account Number");
        search_label.setBounds(100, 50, 300, 30);
        search_label.setFont(new Font("Times new roman", Font.PLAIN, 20));
        search_label.setForeground(Color.DARK_GRAY);
        frame.add(search_label);

        serachbar = new JTextField();
        serachbar.setBounds(50, 100, 300, 30);
        serachbar.addKeyListener(this);
        frame.add(serachbar);

        Search = new JButton("Search");
        Search.setBounds(400, 100, 100, 30);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        Search.addActionListener(this);
        frame.add(Search);

        create_new = new JButton("New Customer");
        create_new.setBounds(550, 100, 150, 30);
        create_new.setBackground(Color.GREEN);
        create_new.setForeground(Color.WHITE);
        create_new.addActionListener(this);
        frame.add(create_new);

        details = new JLabel("Account Holder Information");
        details.setBounds(200, 200, 400, 30);
        details.setForeground(Color.MAGENTA);
        details.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        frame.add(details);

        // The Acoount heolder's Information
        name_label = new JLabel("Name");
        name_label.setBounds(100, 250, 100, 30);
        name_label.setForeground(Color.RED);
        name_label.setFont(new Font("Times new roman", Font.PLAIN, 20));
        frame.add(name_label);

        address_lbl = new JLabel("Address");
        address_lbl.setBounds(100, 300, 100, 30);
        address_lbl.setForeground(Color.RED);
        address_lbl.setFont(new Font("Times new roman", Font.PLAIN, 20));
        frame.add(address_lbl);

        ac_no_label = new JLabel("Account No");
        ac_no_label.setBounds(100, 350, 100, 30);
        ac_no_label.setForeground(Color.RED);
        ac_no_label.setFont(new Font("Times new roman", Font.PLAIN, 20));
        frame.add(ac_no_label);

        branch_label = new JLabel("Branch");
        branch_label.setBounds(100, 400, 100, 30);
        branch_label.setForeground(Color.RED);
        branch_label.setFont(new Font("Times new roman", Font.PLAIN, 20));
        frame.add(branch_label);

        // info labels

        name = new JLabel("NAME HERE");
        name.setBounds(300, 250, 300, 30);
        name.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        frame.add(name);

        address = new JLabel("address HERE");
        address.setBounds(300, 300, 300, 30);
        address.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        frame.add(address);

        ac_no = new JLabel("ac_no HERE");
        ac_no.setBounds(300, 350, 300, 30);
        ac_no.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        frame.add(ac_no);

        branch = new JLabel("branch HERE");
        branch.setBounds(300, 400, 300, 30);
        branch.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        frame.add(branch);

        // Action Buttons view_balance, Credit, debit, update_info
        view_balance = new JButton("View Bal");
        view_balance.setBounds(100, 500, 100, 30);
        view_balance.setBackground(Color.BLACK);
        view_balance.setForeground(Color.WHITE);
        view_balance.addActionListener(this);
        frame.add(view_balance);

        Credit = new JButton("Credit");
        Credit.setBounds(250, 500, 100, 30);
        Credit.setBackground(Color.GREEN);
        Credit.setForeground(Color.WHITE);
        Credit.addActionListener(this);
        frame.add(Credit);

        debit = new JButton("Debit");
        debit.setBounds(400, 500, 100, 30);
        debit.setBackground(Color.RED);
        debit.setForeground(Color.WHITE);
        debit.addActionListener(this);
        frame.add(debit);

        update_info = new JButton("Update info");
        update_info.setBounds(550, 500, 100, 30);
        update_info.setBackground(Color.MAGENTA);
        update_info.setForeground(Color.WHITE);
        update_info.addActionListener(this);
        frame.add(update_info);

        // frame.pack();
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {

        // TODO Auto-generated method stub
        if (e.getKeyCode() == 10) {
        	 this.acc_no = serachbar.getText();
           
            ResultSet rs = this.con.search(this.acc_no);
            
           try {
			if(rs.next()) {
				this.cust_name = rs.getString("name");
				this.addr = rs.getString("address");
				name.setText(rs.getString("name"));
				address.setText(rs.getString("address"));
				ac_no.setText(rs.getString("ac_no"));
				branch.setText(rs.getString("branch"));
			}
			else {
					JOptionPane.showMessageDialog(this.frame, "Customer Not Found...");
				}
		} catch (Exception e2) {
			// TODO: handle exception
		}
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if(e.getSource() == view_balance) {
    	
    		String bal = this.con.getBalance(this.acc_no);
    		JOptionPane.showMessageDialog(this.frame, "Your Balanace is : "+bal); 
    	}
    	if(e.getSource() == Credit) {
    		   String amt = JOptionPane.showInputDialog("Enter Amount To Credit ");
    		   int res = con.credit(this.acc_no, amt);
    		   if(res != 0) {
    			   JOptionPane.showMessageDialog(this.frame, "Amount Credited SuccessFully...");
    		   }
    	}
    	
    	if(e.getSource() == debit) {
 		   String amt = JOptionPane.showInputDialog("Enter Amount To Debit ");
 		   int res = con.debit(this.acc_no, amt);
 		   if(res == -404) {
 			  JOptionPane.showMessageDialog(this.frame, "Insufficient Balance...");
 		   }
 		   else if(res != 0 && res != -404) {
 			   JOptionPane.showMessageDialog(this.frame, "Amount Debited SuccessFully...");
 		   }
 		   
 	}
    	else if (e.getSource() == Search) {
			      	 this.acc_no = serachbar.getText();
	            
	            ResultSet rs = this.con.search(this.acc_no);
	            
	           try {
				if(rs.next()) {
					this.cust_name = rs.getString("name");
					this.addr = rs.getString("address");
					name.setText(rs.getString("name"));
					address.setText(rs.getString("address"));
					ac_no.setText(rs.getString("ac_no"));
					branch.setText(rs.getString("branch"));
				}
				else {
					JOptionPane.showMessageDialog(this.frame, "Customer Not Found...");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
	        }
    	
    	
    	else if(e.getSource()== update_info) {
    		if(this.acc_no != "")
    		new UpdateInfo(this.acc_no,this.cust_name,this.addr);
    		
    	}
    	
    	
    	else if(e.getSource()== create_new ) {
    		
    		new NewCust();
    		
    	}

    }

}
