package com.nc.unnati.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nc.unnati.dao.LoginDAO;
import com.nc.unnati.dto.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if("institute".equals(request.getParameter("login-as"))) {
			Login login = new Login();
			login.setUsername(request.getParameter("username"));
			login.setPassword(request.getParameter("password"));
			LoginDAO logindao = new LoginDAO();
			boolean loginStatus = logindao.authenticateInstitue(login);
			if(loginStatus == true) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionID", login.getUsername());
			//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/institutedashboard.html");
				response.sendRedirect("institutedashboard.html");
			//	rd.forward(request, response);
				System.out.println(request.getRequestURL().toString());
			} else
			//	request.setAttribute("message", "Incorrect Username or Password !");
				System.out.println("Wrong data entered");
			//	request.getRequestDispatcher("login.html").forward(request, response);
		} else if("company".equals(request.getParameter("login-as"))) {
			
		}
	}

}
