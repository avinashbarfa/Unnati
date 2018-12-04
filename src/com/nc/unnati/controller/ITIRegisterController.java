package com.nc.unnati.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nc.unnati.dao.ITIRegisterDAO;
import com.nc.unnati.dto.ITIRegister;

/**
 * Servlet implementation class ITIRegisterController
 */
@WebServlet("/ITIRegisterController")
public class ITIRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITIRegisterController() {
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
		// TODO Auto-generated method stub
		ITIRegister register = new ITIRegister();
		register.setFullName(request.getParameter("fullName"));
		register.setEmailID(request.getParameter("email"));
		register.setPassword(request.getParameter("password"));
		register.setContactNumber(Long.parseLong(request.getParameter("contactNumber")));
		register.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
		register.setState(request.getParameter("state"));
		register.setAddress(request.getParameter("address"));
		
		ITIRegisterDAO registerDao = new ITIRegisterDAO();
		boolean registered = registerDao.registerITI(register);
		
		if(registered == true) {
			System.out.println("true");
			response.sendRedirect("login.html");
			//request.getRequestDispatcher("login.html").forward(request, response);
		} else {
			System.out.println("error");
			request.getRequestDispatcher("error.html").forward(request, response);;
		}
	}

}
