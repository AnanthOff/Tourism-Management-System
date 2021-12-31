package com.tourism.mgt.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tourism.mgt.bean.BaseBean;
import com.tourism.mgt.bean.PackageBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.model.PackageModel;
import com.tourism.mgt.util.DataUtility;
import com.tourism.mgt.util.PropertyReader;
import com.tourism.mgt.util.ServletUtility;




@WebServlet(name = "UserPackageCtl", urlPatterns = { "/userPackage" })
public class UserPackageCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(UserPackageCtl.class);

	
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("PackageListCtl populateBean method start");
		PackageBean bean = new PackageBean();

		bean.setName(DataUtility.getString(request.getParameter("firstName")));

		log.debug("PackageListCtl populateBean method end");
		return bean;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("PackageListCtl doGet Start");
		List list = null;

		

		PackageBean bean = (PackageBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		String[] ids = request.getParameterValues("ids");

		PackageModel model = new PackageModel();
		try {
			list = model.list();
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setSize(model.search(bean).size(), request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("PackageListCtl doPOst End");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected String getView() {
		return TMSView.USER_PACKAGE_VIEW;
	}
}
