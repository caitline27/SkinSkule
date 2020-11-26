package com.mie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.*;
import com.mie.dao.*;

/**
 * Servlet implementation for LoginController.
 * 
 * This class handles the login servlet and assigns session attributes for users
 * who succesfully log into the system.
 */
public class SignupController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered email and password from the signup.jsp form.
		 */
		Member member = new Member();
		member.setName(request.getParameter("n"));
		member.setEmail(request.getParameter("em"));
		member.setPassword(request.getParameter("pw"));
		member.setSkinType_ID(request.getParameter("sk"));
		

		try {
			//Checks if email is unique
			/**
			 * Try to see if the member exist.
			 */
			boolean uniqueemail = MemberDao.checkemail(member);
			boolean emailisvalid = MemberDao.checkemailvalid(member);
			boolean goodpassword = MemberDao.checkpassword(member);
			
			//If email already exists in database, ask them to login instead or redirect to login page
			
			/**
			 * If the isValid value is true, assign session attributes to the
			 * current member.
			 */
		if (!uniqueemail) {

//				HttpSession session = request.getSession(true);
//				session.setAttribute("currentSessionmember", member);
//				session.setAttribute("username", member.getUsername());
//				session.setAttribute("firstname", member.getFirstName());
//				session.setAttribute("lastname", member.getLastName());
				/**
				 * Redirect to the login page.
				 */
				response.sendRedirect("login.jsp");

				/**
				 * Set a timeout variable of 900 seconds (15 minutes) for this
				 * member who has logged into the system.
				 */
				//session.setMaxInactiveInterval(900);
			} else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
				//If email is unique, 
				//check if email is in an email form e.g. has an @, no spaces
				//check password requirements are met
			
			
			if (goodpassword && emailisvalid){
				//insert into db
				MemberDao.adduser(member);
				response.sendRedirect("successfulaccountcreation.jsp");
			} 
			
			if (!emailisvalid){
				//display error message
				response.sendRedirect("bademail.jsp");
			}
			
			if (!goodpassword){ //if passw not good
				//display error message
				response.sendRedirect("badpassword.jsp");
			}
			
			}
			
			
		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
}
