package com.nc.unnati.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nc.unnati.service.RegisterService;
/**
 	* Servlet implementation class FirstControllerServlet
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns={"*.html"})
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontControllerServlet() {
       // super();
        System.out.println("In Front Controller Servlet");
    }

	public void init () {
			System.out.println("In Front Controller INIT");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("path  :  "+request.getRequestURL().toString());
		String target = "/WEB-INF/index.jsp";
		String requestPage = request.getRequestURL().toString();
		if(requestPage.endsWith("index.html")) {
			target = "/WEB-INF/index.jsp";
		} else if(requestPage.endsWith("login.html")) {
			target = "/WEB-INF/login.jsp";
		} else if(requestPage.endsWith("signup.html")) {
			target = "/WEB-INF/signup.jsp";
		} else if(requestPage.endsWith("signupcomp.html")) {
			request.setAttribute("states", RegisterService.getAllStates());
			target ="/WEB-INF/signupcomp.jsp";
		} else if(requestPage.endsWith("signupiti.html")) {
			request.setAttribute("states", RegisterService.getAllStates());
			target ="/WEB-INF/signupiti.jsp";
		} else if(requestPage.endsWith("institutedashboard.html")) {
			target ="/WEB-INF/institutedashboard.jsp";
		} else if(requestPage.endsWith("logout.html")) {
			target ="/WEB-INF/logout.jsp";
		}
	//	System.out.println(target);
		RequestDispatcher dispatch = request.getRequestDispatcher(target);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
