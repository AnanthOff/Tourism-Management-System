package com.tourism.mgt.ctl;

public interface TMSView {
	
	public String APP_CONTEXT = "/Tourism-Management";

	public String LAYOUT_VIEW = "/BaseLayout.jsp";
	public String PAGE_FOLDER = "/jsp";
	public String IMAGE_FOLDER = APP_CONTEXT+"/images/";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/Error.jsp";

	
	
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";	
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	
	
	public String PACKAGE_VIEW = PAGE_FOLDER + "/PackageView.jsp";	
	public String PACKAGE_LIST_VIEW = PAGE_FOLDER + "/PackageListView.jsp";
	
	public String USER_PACKAGE_VIEW = PAGE_FOLDER + "/UserPackageView.jsp";	
	
	public String ISSUES_VIEW = PAGE_FOLDER + "/IssuesView.jsp";	
	public String ISSUES_LIST_VIEW = PAGE_FOLDER + "/IssuesListView.jsp";
	
	public String BOOKING_VIEW = PAGE_FOLDER + "/BookingView.jsp";	
	public String BOOKING_LIST_VIEW = PAGE_FOLDER + "/BookingListView.jsp";
	
	public String ENQUIRIES_VIEW = PAGE_FOLDER + "/EnquiriesView.jsp";	
	public String ENQUIRIES_LIST_VIEW = PAGE_FOLDER + "/EnquiriesListView.jsp";
	
	
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";

	
	public String CONTACT_VIEW = PAGE_FOLDER + "/ContactView.jsp";
	
	public String ABOUTUS_VIEW = PAGE_FOLDER + "/AboutUsView.jsp";

	public String ERROR_CTL = "/ctl/ErrorCtl";


	
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/facultyList";
	
	public String PACKAGE_CTL = APP_CONTEXT + "/ctl/package";
	public String PACKAGE_LIST_CTL = APP_CONTEXT + "/ctl/packageList";
	
	public String ISSUES_CTL = APP_CONTEXT + "/ctl/issues";
	public String ISSUES_LIST_CTL = APP_CONTEXT + "/ctl/issuesList";
	
	public String USER_PACKAGE_CTL = APP_CONTEXT + "/userPackage";
	
	public String ENQUIRIES_CTL = APP_CONTEXT + "/enquiries";
	public String ENQUIRIES_LIST_CTL = APP_CONTEXT + "/ctl/enquiriesList";
	
	public String BOOKING_CTL = APP_CONTEXT + "/ctl/booking";
	public String BOOKING_LIST_CTL = APP_CONTEXT + "/ctl/bookingList";
	
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/userRegistration";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	
	public String CONTACT_CTL = APP_CONTEXT + "/contact";
	
	public String ABOUTUS_CTL = APP_CONTEXT + "/aboutUs";
	
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String LOGOUT_CTL = APP_CONTEXT + "/login";
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/changePassword";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/myProfile";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
}
