package com.test.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class DefaultBean {

	public Connection getConnection() throws Exception {
		String url = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=userdb";
		String username = "sa";
		String password = "sa";
		String driver = "net.sourceforge.jtds.jdbc.Driver";
		Class.forName(driver).newInstance();
		return DriverManager.getConnection(url, username, password);
	}

	public void executeSql(String sql) throws Exception {
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		st.execute(sql);
	}
}
