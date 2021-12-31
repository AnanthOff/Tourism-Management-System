package com.tourism.mgt.ctl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;

import com.tourism.mgt.util.ServletUtility;





 
@WebServlet(name = "ContactCtl", urlPatterns = { "/contact" })
public class ContactCtl extends BaseCtl {
	
	private static final long serialVersionUID = 1L;

	
	

	/**
	 * Contains display logic
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServletUtility.forward(getView(), request, response);
	
	}
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	protected String getView() {
		return TMSView.CONTACT_VIEW;
	}

}
