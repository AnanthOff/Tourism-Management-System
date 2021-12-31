package com.tourism.mgt.ctl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tourism.mgt.bean.BaseBean;
import com.tourism.mgt.bean.BookingBean;
import com.tourism.mgt.bean.PackageBean;
import com.tourism.mgt.bean.UserBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.exception.DuplicateRecordException;
import com.tourism.mgt.model.BookingModel;
import com.tourism.mgt.model.PackageModel;
import com.tourism.mgt.util.DataUtility;
import com.tourism.mgt.util.DataValidator;
import com.tourism.mgt.util.PropertyReader;
import com.tourism.mgt.util.ServletUtility;

/**
 * Servlet implementation class BookingCtl
 */

@WebServlet(name = "BookingCtl", urlPatterns = { "/ctl/booking" })
public class BookingCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(BookingCtl.class);

	protected boolean validate(HttpServletRequest request) {

		log.debug("BookingCtl Method validate Started");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("toDate"))) {
			request.setAttribute("toDate", PropertyReader.getValue("error.require", "To Date"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("fromDate"))) {
			request.setAttribute("fromDate", PropertyReader.getValue("error.require", "From Date"));
			pass = false;
		}
		
		log.debug("BookingCtl Method validate Ended");
		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("BookingCtl Method populatebean Started");

		BookingBean bean = new BookingBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setToDate(DataUtility.getDate(request.getParameter("toDate")));
		bean.setFromDate(DataUtility.getDate(request.getParameter("fromDate")));
		populateDTO(bean, request);

		log.debug("BookingCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("BookingCtl Method doGet Started");
		long pId =DataUtility.getLong(request.getParameter("pkId"));
		if(pId>0) {
			request.getSession().setAttribute("pId",pId);
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("BookingCtl Method doGet Ended");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("BookingCtl Method doPost Started");
		String op = DataUtility.getString(request.getParameter("operation")); // get model
		BookingModel model = new BookingModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op)) {
			BookingBean bean = (BookingBean) populateBean(request);
			try {
				if (id > 0) {
					model.update(bean);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
				} else {
					UserBean uBean=(UserBean)request.getSession().getAttribute("user");
					PackageBean pBean=new PackageModel().findByPK(DataUtility.getLong(String.valueOf(request.getSession().getAttribute("pId"))));
					bean.setPkId(pBean.getId());
					bean.setPkName(pBean.getName());
					bean.setUserName(uBean.getFirstName()+" "+uBean.getLastName());
					bean.setbDate(new Date());
					bean.setBookingId(DataUtility.getRandom());
					bean.setStatus("Processing");
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
			BookingBean bean = (BookingBean) populateBean(request);
			try {
				model.delete(bean);
				ServletUtility.redirect(TMSView.BOOKING_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(TMSView.BOOKING_LIST_CTL, request, response);
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(TMSView.BOOKING_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("BookingCtl Method doPostEnded");
	}

	@Override
	protected String getView() {
		return TMSView.BOOKING_VIEW;
	}

}
