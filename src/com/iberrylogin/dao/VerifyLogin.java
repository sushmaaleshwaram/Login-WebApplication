package com.iberrylogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class VerifyLogin {
    public static boolean validate(String name, String pass) {
    	
    	boolean status = false;
    	try{
    	
    	System.out.print(name+pass);
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sushmatha","root","root");
    	PreparedStatement pst=con.prepareStatement("select * from user1");
    	ResultSet rs=pst.executeQuery();
    	while(rs.next()){
    	if(rs.getString(1).equalsIgnoreCase(name)&&rs.getString(2).equalsIgnoreCase(pass))
    	{
    		System.out.print(rs.getString(1));
    		System.out.print(rs.getString(2));
    		 status=true;
    		 
    	}

    	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    return status;
    }
}