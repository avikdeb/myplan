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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolename = request.getParameter("role");
		
		System.out.println("Request Username = "+username);
		System.out.println("Request Password = "+password);
		System.out.println("Request Role = "+rolename);
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(username);
		String dbusername = user.getUsername();
		String dbpassword = user.getPassword();
		String dbrole = user.getRole();
		
		System.out.println("DB Username = "+dbusername);
		System.out.println("DB Role = "+dbrole);
		
		/*RoleDAO roleDAO = new RoleDAO();
		Role role = null;
		role = roleDAO.getRoleById(dbroleid);
		String dbrolename = role.getRole();
		System.out.println("DB Role name = "+dbroleid);*/
		
		if(username.equalsIgnoreCase(dbusername)) {
			if(password.equalsIgnoreCase(dbpassword)) {
				if(rolename.equalsIgnoreCase(dbrole)) {
					//Login success
					request.setAttribute("username", dbusername);
					request.setAttribute("role", dbrole);
					request.getRequestDispatcher("/plans.jsp").forward(request, response);
					//role is RM - RM landing page
					//role is PM - PM landing page
					
				} else {
					request.setAttribute("error_code", 200);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				
			} else {
				request.setAttribute("error_code", 100);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorcode", 100);
			request.getRequestDispatcher("/testingpage.jsp").forward(request, response);
		}
	}

}
