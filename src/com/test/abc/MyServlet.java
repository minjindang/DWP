package com.test.abc;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doServ(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doServ(request,response);
	}
	
	private void doServ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("BIG5");
		PrintWriter out = response.getWriter();

		String style = request.getParameter("style");
		out.println("車款:" + style);

		String displacement[] = request.getParameterValues("displacement");
		if (displacement != null) {
			out.print("排氣量:");
			for (int i = 0; i < displacement.length; i++) {
				out.println(displacement[i]);
			}
		}
		
		String tname = request.getParameter("tname");
		System.out.println(tname);
		
	}
}
