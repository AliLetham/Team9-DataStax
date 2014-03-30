package com.example.team9.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.example.team9.lib.CassandraHosts;
import com.example.team9.stores.Member;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cluster cluster;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		cluster = CassandraHosts.getCluster();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Session session = cluster.connect("keyspace2");
		String title = request.getParameter("title");
		String game = request.getParameter("game");
		String description = request.getParameter("description");
		UUID a = UUID.randomUUID();
		System.out.println("title:" + title);
		Member member = (Member) request.getSession().getAttribute("user");
		String username = member.getUsername();
		Part videoFile = request.getPart("video");
		final String writePath = "C:/WebWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DataStaxThing/files/";
		final String path = "http://localhost:8080/DataStaxThing/files/";
		
		OutputStream out = null;
		InputStream filecontent = null;
		String uuidString = a.toString();
		StringBuilder SB = new StringBuilder();
		SB.append(uuidString);
		SB.append(".mp4");
		String filename = SB.toString();
		System.out.println(filename);
		
		String videoLink = path + filename;
		try {
			System.out.println("NO FILE CONT0ENT");
			out = new FileOutputStream(new File(writePath + filename));
			System.out.println("NO FILE CONTENT");
			filecontent = videoFile.getInputStream();
			System.out.println("NO FILE CONTEN11T");
			int read = 0;
			final byte[] bytes = new byte[1024];
			System.out.println("NO FILE CON2TENT");
			while ((read = filecontent.read(bytes)) != -1) {
				System.out.println("NO FILE CONT3ENT");
				out.write(bytes, 0, read);
			}
			System.out.println("New file "+filename+" created at: "+ writePath);
		} 
		catch (FileNotFoundException fne) {
			System.out.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent "
					+ "location.");
			System.out.println("<br/> ERROR: " + fne.getMessage());

			
		}
		finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}

		PreparedStatement statement = session
				.prepare("INSERT INTO videos(videoid, date, description, downvotes, favourites, game, title, upvotes, username, videolink, views) VALUES(?,dateof(now()),?,?,?,?,?,?,?,?,?)");
		BoundStatement boundStatement = new BoundStatement(statement);
		session.execute(boundStatement.bind(a, description, 0, 0, game, title, 0, username, videoLink, 0));

		//cluster.close();
		session.close();

		response.sendRedirect("topVideos.jsp");
	
	}

}
