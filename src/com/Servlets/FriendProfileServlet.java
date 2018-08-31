package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Facade.Facade;
import com.Model.UserInfoPojo;

public class FriendProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id=(int) session
				.getAttribute("userId");
		Facade facade = Facade.getInstance();
		List<UserInfoPojo> userDetailsList = new ArrayList<UserInfoPojo>();
		try {
			userDetailsList = facade.getUserInfo(Integer.parseInt(request.getParameter("hiddenFriendId")));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response = generateHtml(response, userDetailsList, id);
	}

	public HttpServletResponse generateHtml(HttpServletResponse response,
			List<UserInfoPojo> userInfoList, int id) throws IOException {
		response.setContentType("text/html");
		PrintWriter fileWriter = response.getWriter();
		fileWriter
				.print("<img name = 'imageOfUser'src=''<a href=''><input type='hidden' name='hiddenId' value='"+id+"'/>Friends</a><a href=''>Logout</a> ");
		fileWriter.print("<form action='' id=''>"
				+ "<h1 align=''center>Profile</h1><br />"
						+ "<table cellpadding='5'><tr>"
								+ "<th align='left'>First Name :</th>"
									+ "<td><input type='text' name = 'firstName' value= '"+userInfoList.get(0)+"' readonly/></td></tr>"
								+ "<th align='left'>Last Name :</th>"
									+ "<td><input type='text' name = 'lastName' value= '"+userInfoList.get(1)+"' readonly/></td></tr>"
								+ "<tr><th align='left'>Age :</th>"
									+ "<td><input type='' name = 'dateOfBirth' value='"+userInfoList.get(2)+"' readonly/></td></tr>"
								+ "<tr><th align='left'>Contact No. :</th>"
									+ "<td><input type='number' name='contact' value='"+userInfoList.get(3)+"' readonly/></td></tr>"
								+ "<tr><th align='left'>Email :</th>"
									+ "<td><input type='email' name='email' value='"+userInfoList.get(4)+"' readonly/></td></tr>"
								+ "<tr><th align='left'>Company/Institute :</th>"
									+ "<td><input type='text' name = 'company' value='"+userInfoList.get(6)+"' readonly /></td>"
								+ "</tr><tr><td><input type='submit' value='Back'></td></tr></table>"
								+ "<input type='hidden' name='userId' value='"+id+"'/></form>)");
		return response;
	}
}
