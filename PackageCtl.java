
package com.tourism.mgt.ctl;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.tourism.mgt.bean.BaseBean;
import com.tourism.mgt.bean.PackageBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.exception.DuplicateRecordException;
import com.tourism.mgt.model.PackageModel;
import com.tourism.mgt.util.DataUtility;
import com.tourism.mgt.util.DataValidator;
import com.tourism.mgt.util.PropertyReader;
import com.tourism.mgt.util.ServletUtility;

/**
 * Servlet implementation class PackageCtl
 */

@WebServlet(name = "PackageCtl", urlPatterns = { "/ctl/package" })
@MultipartConfig(maxFileSize = 16177215)
public class PackageCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(PackageCtl.class);

	protected boolean validate(HttpServletRequest request) {

		log.debug("AssignFacultyCtl Method validate Started");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getValue("error.require", "Type"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "Location"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("feature"))) {
			request.setAttribute("feature", PropertyReader.getValue("error.require", "Feature"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "Price"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("feature"))) {
			request.setAttribute("feature", PropertyReader.getValue("error.require", "Feature"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("detail"))) {
			request.setAttribute("detail", PropertyReader.getValue("error.require", "Detail"));
			pass = false;
		}
		
		Part part = null;
		try {
			part = request.getPart("image");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if (DataValidator.isNull(fileName)) {
			request.setAttribute("image", PropertyReader.getValue("error.require", "Image"));
			pass = false;
		}

		log.debug("PackageCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("PackageCtl Method populatebean Started");

		PackageBean bean = new PackageBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setType(DataUtility.getString(request.getParameter("type")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setFeature(DataUtility.getString(request.getParameter("feature")));
		bean.setDetail(DataUtility.getString(request.getParameter("detail")));
		bean.setPrice(DataUtility.getString(request.getParameter("price")));

		populateDTO(bean, request);

		log.debug("PackageCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("StudentCtl Method doGet Started");

		String op = DataUtility.getString(request.getParameter("operation")); 

		PackageModel model = new PackageModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {

			PackageBean bean;
			try {
				bean = model.findByPK(id);

				ServletUtility.setBean(bean, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("StudentCtl Method doGet Ended");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("PackageCtl Method doPost Started");
		String op = DataUtility.getString(request.getParameter("operation")); // get model
		PackageModel model = new PackageModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op)) {
			PackageBean bean = (PackageBean) populateBean(request);
			bean.setImage(ServletUtility.subImage(request, response, bean.getName()));
			try {
				if (id > 0) {
					model.update(bean);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
				} else {
					long pk = model.add(bean);
					ServletUtility.setSuccessMessage("Data is successfully saved", request);
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(), request);
			}
			ServletUtility.forward(getView(), request, response);
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			PackageBean bean = (PackageBean) populateBean(request);
			try {
				model.delete(bean);
				ServletUtility.redirect(TMSView.PACKAGE_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(TMSView.PACKAGE_LIST_CTL, request, response);
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(TMSView.PACKAGE_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("PackageCtl Method doPostEnded");
	}

	@Override
	protected String getView() {
		return TMSView.PACKAGE_VIEW;
	}

}
