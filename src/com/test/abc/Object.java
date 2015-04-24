package com.test.abc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Object extends DefaultBean {
	
	private String first_name;
	private String last_name;
	private String gender;
	private String city;

	public List<User> query() throws Exception
	{
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from User");
		List<User> Users = new ArrayList<User>();
		while(rs.next())
		{
			String fname = rs.getString("first_name");
			String lname = rs.getString("last_name");
			String gender = rs.getString("gender");
			String city = rs.getString("city");
			
			
			User m = new User();
			m.setFirst_name(fname);
			m.setLast_name(lname);
			m.setGender(gender);
			m.setCity(city);
			Users.add( m );
		}
		return Users;
	}
	
	public void insert(Object user) throws Exception
	{
		String newFirstname = user.getFirst_name();
		String newLastname = user.getLast_name();
		if(null!=newFirstname)
		{
			String sql = "insert into User (First_name,Last_name) values ('"+newFirstname+"',"+newLastname+")";
			System.out.println(sql);
			executeSql(sql);
		}
	}
	
	public void update(Object user) throws Exception
	{
		String newFirstname = user.getFirst_name();
		String newGender = user.getGender();

		if(null!=newFirstname)
		{
			String sql = "update User set Gender = "+newGender+" where First_name = '"+newFirstname+"'";
			System.out.println(sql);
			executeSql(sql);
		}
	}
	
	public void delete(Object user) throws Exception
	{
		String newUsername = user.getFirst_name();
		//Integer newAge = user.getAge();

		if(null!=newUsername)
		{
			String sql = "delete from User where username = '"+newUsername+"'";
			System.out.println(sql);
			executeSql(sql);
		}
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}