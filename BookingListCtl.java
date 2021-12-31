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
import com.tourism.mgt.bean.BookingBean;
import com.tourism.mgt.bean.UserBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.exception.DuplicateRecordException;
import com.tourism.mgt.model.BookingModel;
import com.tourism.mgt.util.DataUtility;
import com.tourism.mgt.util.PropertyReader;
import com.tourism.mgt.util.ServletUtility;




@WebServlet(name = "BookingListCtl", urlPatterns = { "/ctl/bookingList" })
public class BookingListCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(BookingListCtl.class);

	
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("BookingListCtl populateBean method start");
		BookingBean bean = new BookingBean();

		bean.setUserName(DataUtility.getString(request.getParameter("name")));
		bean.setBookingId(DataUtility.getString(request.getParameter("bkId")));
		bean.setPkName(DataUtility.getString(request.getParameter("pkName")));

		log.debug("BookingListCtl populateBean method end");
		return bean;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("BookingListCtl doGet Start");
		List list = null;

		int pageNo = 1;

		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		BookingBean bean = (BookingBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		String[] ids = request.getParameterValues("ids");

		BookingModel model = new BookingModel();
		
		long bId=DataUtility.getLong(request.getParameter("id"));
		String st=DataUtility.getString(request.getParameter("st"));
		
		
		
		try {
			if(bId>0) {
				BookingBean bBean=model.findByPK(bId);
				bBean.setStatus(st);
				model.update(bBean);
			}
			
			UserBean uBean=(UserBean)request.getSession().getAttribute("user");
			
			if(uBean.getRoleId()==2) {
				bean.setUserName(uBean.getFirstName()+" "+uBean.getLastName());
			}
			
			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setSize(model.search(bean).size(), request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		log.debug("BookingListCtl doPOst End");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.debug("BookingListCtl doPost Start");
		
		
		List list = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		
		BookingBean bean = (BookingBean) populateBean(request);
		
		String op = DataUtility.getString(request.getParameter("operation"));
		
		String[] ids = request.getParameterValues("ids");
		
		BookingModel model = new BookingModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(TMSView.BOOKING_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					BookingBean deletebean = new BookingBean();
					for (String id : ids) {
						deletebean.setId(DataUtility.getInt(id));
						model.delete(deletebean);
					}
					ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}
			} else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(TMSView.BOOKING_LIST_CTL, request, response);
				return;

			}
			
			UserBean uBean=(UserBean)request.getSession().getAttribute("user");
			
			if(uBean.getRoleId()==2) {
				bean.setUserName(uBean.getFirstName()+" "+uBean.getLastName());
			}
			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setSize(model.search(bean).size(), request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("BookingListCtl doGet End");

	}
	
	protected String getView() {
		return TMSView.BOOKING_LIST_VIEW;
	}
}
