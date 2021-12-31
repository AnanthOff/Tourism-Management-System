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
import com.tourism.mgt.bean.UserBean;
import com.tourism.mgt.exception.ApplicationException;
import com.tourism.mgt.exception.DuplicateRecordException;
import com.tourism.mgt.model.UserModel;
import com.tourism.mgt.util.DataUtility;
import com.tourism.mgt.util.DataValidator;
import com.tourism.mgt.util.PropertyReader;
import com.tourism.mgt.util.ServletUtility;




@WebServlet(name = "UserRegistrationCtl", urlPatterns = { "/userRegistration" })
public class UserRegistrationCtl extends BaseCtl {
	public static final String OP_SIGN_UP = "SignUp";

	private static Logger log = Logger.getLogger(UserRegistrationCtl.class);
	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	protected boolean validate(HttpServletRequest request) {
		log.debug("UserRegistrationCtl Method validate Started");

		boolean pass = true;

		String login = request.getParameter("login");

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName",
					PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName",
					PropertyReader.getValue("error.name", "First Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName",
					PropertyReader.getValue("error.require", "Last Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName",
					PropertyReader.getValue("error.name", "Last Name"));
			pass = false;
		}

		if (DataValidator.isNull(login)) {
			request.setAttribute("login",
					PropertyReader.getValue("error.require", "Login Id"));
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login",
					PropertyReader.getValue("error.email", "Login"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", PropertyReader.getValue(
					"error.require", "Confirm Password"));
			pass = false;
		}
		

		
		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password",
					PropertyReader.getValue("error.require", "Password"));
			pass = false;

		} else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password",
					PropertyReader.getValue("error.password", "Password"));
			return false;
		}else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password",
					PropertyReader.getValue("error.password", "Password"));
			return false;
		}

		if (!request.getParameter("password").equals(
				request.getParameter("confirmPassword"))
				&& !"".equals(request.getParameter("confirmPassword"))) {
			/*ServletUtility.setErrorMessage("Confirm Password did not match",
					request);*/
			request.setAttribute("confirmPassword", PropertyReader.getValue("error.confirmPassword","Confirm Password"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("mobile"))) {
			request.setAttribute("mobile", PropertyReader.getValue("error.require","Mobile No"));
			pass = false;
		}else if(!DataValidator.isPhoneNo(request.getParameter("mobile"))){
			request.setAttribute("mobile", PropertyReader.getValue("error.invalid","Mobile No"));
			pass=false;
		} 
			log.debug("UserRegistrationCtl Method validate Ended");
		return pass;
	}
	
	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("UserRegistrationCtl Method populatebean Started");

		UserBean bean = new UserBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setRoleId(2L);

		bean.setFirstName(DataUtility.getString(request
				.getParameter("firstName")));

		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));

			bean.setLogin(DataUtility.getString(request.getParameter("login")));
	
			bean.setPassword(DataUtility.getString(request.getParameter("password")));
	
			bean.setConfirmPassword(DataUtility.getString(request
					.getParameter("confirmPassword")));
	
			bean.setGender(DataUtility.getString(request.getParameter("gender")));
	
			bean.setDob(new Date());
			
			bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));
			
			populateDTO(bean, request);
	
			log.debug("UserRegistrationCtl Method populatebean Ended");
	
			return bean;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationCtl() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Contains display logic
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("StudentCtl Method doGet Started");
        System.out.println("in do get");
        String op = DataUtility.getString(request.getParameter("operation"));
        long id = DataUtility.getLong(request.getParameter("id"));

        // get model
        ServletUtility.setOpration("Add", request);
        UserModel model = new UserModel();
        if (id > 0 || op != null) {
            UserBean bean;
            try {
                bean = model.findByPK(id);
                ServletUtility.setOpration("Edit", request);
                ServletUtility.setBean(bean, request);
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            }
        }
        ServletUtility.forward(getView(), request, response);
        log.debug("StudentCtl Method doGett Ended");

	}
	/**
	 * Contains submit logic
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post method");
		log.debug("UserRegistrationCtl Method doPost Started");
	
		String op = DataUtility.getString(request.getParameter("operation"));
		// get model
		UserModel model = new UserModel();
		
		long id = DataUtility.getLong(request.getParameter("id"));
		
		
		if (OP_SAVE.equalsIgnoreCase(op)) {
			
			UserBean bean = (UserBean) populateBean(request);
			try {
				 if (id > 0) {
                	 
	                    model.update(bean);
	                    ServletUtility.setSuccessMessage("Data is successfully Updated",request);
	                    ServletUtility.setOpration("Edit", request);
	                    ServletUtility.setBean(bean, request);
	                } else {
	                    long pk = model.add(bean);
	                    ServletUtility.setSuccessMessage("Data is successfully saved",request);
	                }
				 ServletUtility.forward(getView(), request, response);
				 return;
			} catch (DuplicateRecordException e) {
				log.error(e);
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Login id already exists",
						request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				e.printStackTrace();
				return;
			}
		}else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(TMSView.USER_REGISTRATION_CTL, request, response);
			return;
		}
		log.debug("UserRegistrationCtl Method doPost Ended");
	}
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	protected String getView() {
		return TMSView.USER_REGISTRATION_VIEW;
	}

}
