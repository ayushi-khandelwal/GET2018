package GET2018.EAD.EADSession4.Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GET2018.EAD.EADSession4.Facade.Facade;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = Facade.getInstance();
		try {
			if (facade.registerUser(request.getParameter("firstName"), request.getParameter("lastName"),
					Date.valueOf(request.getParameter("dateofBirth")),
					Integer.parseInt(request.getParameter("contactNo")), request.getParameter("email"),
					request.getParameter("password"), request.getParameter("organization"))) {
				System.out.println("Entry Successfull");
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
