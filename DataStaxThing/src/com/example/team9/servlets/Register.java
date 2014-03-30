package com.example.team9.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.example.team9.lib.CassandraHosts;
import com.example.team9.stores.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Register/*")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Cluster cluster;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		cluster = CassandraHosts.getCluster();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		Session session = cluster.connect("keyspace2");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PreparedStatement statement = session.prepare("INSERT INTO users(username, email, password) VALUES(?,?,?)");
		BoundStatement boundStatement = new BoundStatement(statement);
		session.execute(boundStatement.bind(username, email, password));
		
		session.close();
		//cluster.close();
		
		response.sendRedirect("login.jsp");
			
		}
		}
	


