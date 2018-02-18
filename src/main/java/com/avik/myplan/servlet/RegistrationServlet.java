package com.avik.myplan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avik.myplan.beans.Role;
import com.avik.myplan.beans.User;
import com.avik.myplan.dao.RoleDAO;
import com.avik.myplan.dao.UserDAO;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String organization = request.getParameter("organization");
		String role = request.getParameter("role");
		
		/*RoleDAO roleDAO = new RoleDAO();
		Role role = roleDAO.getRoleByName(rolename);
		int roleid = role.getIdrole();*/
		
		User user = new User();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setOrganization(organization);
		user.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(user);
		
		System.out.println("New user created!");
		request.setAttribute("username", username);
		request.setAttribute("role", role);
		
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		
		
	}

}
