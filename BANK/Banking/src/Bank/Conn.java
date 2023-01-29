package Bank;

import java.sql.*;
import java.util.Random;

public class Conn {

    Connection con;

    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///Bank", "root", "Pass@123");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int Login(String user,String pass) {

        try {
            String query = "select * from user where username = ? and password = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, user);
            psmt.setString(2, pass);
            
            ResultSet res = psmt.executeQuery();
            if(res.next()) {
            	return 1;
            }
            return 0;
            		
        } catch (Exception e) {
            return 0;
        }

    }

    public ResultSet search(String id) {

        try {
            String query = "Select * from Customers where AC_NO = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            ResultSet rs = psmt.executeQuery();
            return rs;

        } catch (SQLException e) {
        		System.out.println("Error Occured");
        		e.printStackTrace();
        }
        return null;
    }

    
    public String getBalance(String AC_No) {
    	
    	 try {
             String query = "select Balance from customers where Ac_no = ?";
             PreparedStatement psmt = con.prepareStatement(query);
             psmt.setString(1, AC_No);
             ResultSet res = psmt.executeQuery();
             if(res.next()) {
            	 return res.getString(1);
             }
      
         } catch (SQLException e) {
        	 e.printStackTrace();
             return "0";
             
         }
    	
    	return "0";
    }
    
    public int credit(String acc, String amount) {
    	
    	try {
    		
    		String q1  = "Select Balance from customers where ac_no = ?";
    		PreparedStatement stmt = con.prepareStatement(q1);
    		stmt.setString(1, acc);
    		ResultSet res = stmt.executeQuery();
    		
    		if(res.next()) {
    			int bal = Integer.parseInt(res.getString("Balance"));
    			int new_amt = bal + Integer.parseInt(amount);
    			Integer obj = new Integer(new_amt);
    			try {
    				
    				String q2 = "Update customers set balance = ? where ac_no = ?";
    				PreparedStatement psmt = con.prepareStatement(q2);
    				psmt.setString(1, obj.toString());
    				psmt.setString(2, acc);
    				int final_res = psmt.executeUpdate();
    				return final_res;
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	return 0;
    }
    
public int debit(String acc, String amount) {
    	
    	try {
    		
    		String q1  = "Select Balance from customers where ac_no = ?";
    		PreparedStatement stmt = con.prepareStatement(q1);
    		stmt.setString(1, acc);
    		ResultSet res = stmt.executeQuery();
    		
    		if(res.next()) {
    			int bal = Integer.parseInt(res.getString("Balance"));
    			if(bal < Integer.parseInt(amount)) {
    				return -404;
    			}
    			int new_amt = bal - Integer.parseInt(amount);
    			Integer obj = new Integer(new_amt);
    			try {
    				
    				String q2 = "Update customers set balance = ? where ac_no = ?";
    				PreparedStatement psmt = con.prepareStatement(q2);
    				psmt.setString(1, obj.toString());
    				psmt.setString(2, acc);
    				int final_res = psmt.executeUpdate();
    				return final_res;
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	return 0;
    }
   
    public int delete(String id) {
        try {
            String query = "Delete from customers where Ac_no = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            int res = psmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            return 0;
        }

    }
    
    
    public int update(String acc,String name,String addr) {
        try {
            String query = "update customers set name = ?, address = ? where Ac_no = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, name);
            psmt.setString(2,addr);
            psmt.setString(3, acc);
            int res = psmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            return 0;
        }

    }
    
    
    public int Create(String Branch,String name,String addr) {
        try {
        	Random rand = new Random();
        	int ac = rand.nextInt(999999);
            String query = "insert into customers values(?,?,?,?,0)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, ac);
            psmt.setString(2, name);
            psmt.setString(3,addr);
            psmt.setString(4, Branch);
            int res = psmt.executeUpdate();
            if(res != 0)
            	return ac;
            return res;
        } catch (SQLException e) {
        	e.printStackTrace();
            return 0;
        }

    }

}
