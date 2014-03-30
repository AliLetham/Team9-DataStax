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
@WebServlet("/Login/*")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Cluster cluster;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		Session session = cluster.connect("keyspace2");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String selectPass = "";
		
		PreparedStatement statement = session.prepare("SELECT password from users WHERE username = ?");
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs = session.execute(boundStatement.bind(username));
		if (rs.isExhausted()) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else{
			for(Row row : rs){
				 selectPass = row.getString("password");
				
			}
			
		}
		//cluster.close();
		session.close();
		
		System.out.println("selectPass = "+selectPass);
		if (selectPass.equals(password)){
			System.out.println("got through");
		Member myman = new Member();
		myman.setUsername(username);
		request.getSession().setAttribute("user", myman);
		response.sendRedirect("userHub.jsp");
		}
		else{
			System.out.println("NOT YET");
			response.sendRedirect("login.jsp");
			
		}
		}
	}


