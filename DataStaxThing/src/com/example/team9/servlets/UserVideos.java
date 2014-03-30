package com.example.team9.servlets;

import java.io.IOException;
import java.util.ArrayList;

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
import com.example.team9.stores.Videos;

/**
 * Servlet implementation class UserVideos
 */
@WebServlet("/UserVideos")
public class UserVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private Cluster cluster;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVideos() {
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
		
		Session session = cluster.connect("keyspace2");
		Member currentMember = (Member)request.getSession().getAttribute("user");
		String username = currentMember.getUsername();
		ArrayList<Videos> usersVids = new ArrayList<Videos>();
		
		PreparedStatement statement = session.prepare("SELECT videolink, title from videos WHERE username = ?");
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs = session.execute(boundStatement.bind(username));
		if (rs.isExhausted()) {
			request.getRequestDispatcher("/userHub.jsp").forward(request, response);
			return;
		}
		else{
			for(Row row : rs){
				Videos userVideo=new Videos();  
				userVideo.setVideoLink(row.getString("videolink"));  
				userVideo.setTitle(row.getString("title"));   
				usersVids.add(userVideo);
				
			}
			
		}
		
		session.close();
		//cluster.close();
		
		request.setAttribute("usersVideos", usersVids);
		request.getRequestDispatcher("/yourVideos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
