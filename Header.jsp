<%@page import="com.tourism.mgt.ctl.LoginCtl"%>
<%@page import="com.tourism.mgt.ctl.TMSView"%>
<%@page import="com.tourism.mgt.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
	rel="stylesheet">

<!-- JQuery -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
</head>
<body>
	<!--Main Navigation-->
	<header>

		<%
			UserBean userBean = (UserBean) session.getAttribute("user");

		boolean userLoggedIn = userBean != null;

		String welcomeMsg = "Hi, ";

		if (userLoggedIn) {
			welcomeMsg += userBean.getFirstName();
		} else {
			welcomeMsg += "Guest";
		}
		%>

		<nav class="navbar navbar-expand-lg navbar-dark default-color">
			<a class="navbar-brand" href="#"><strong
				style="font-family: cursive; color: darkgreen;">Online
					Tourism System</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="<%=TMSView.WELCOME_CTL%>">Home
							<span class="sr-only">(current)</span>
					</a></li>

					<%
						if (userLoggedIn) {
					%>
					<%
						if (userBean.getRoleId() == 1) {
					%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Tour Package</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="<%=TMSView.PACKAGE_CTL%>">Tour
								Package</a> <a class="dropdown-item"
								href="<%=TMSView.PACKAGE_LIST_CTL%>">Tour Package List</a>
						</div></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.USER_LIST_CTL%>">Users</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=TMSView.ISSUES_LIST_CTL%>">Issues</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.ENQUIRIES_LIST_CTL%>">Enquires</a></li>
						<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.BOOKING_LIST_CTL%>">Booking History</a></li>
					<%
						} else if (userBean.getRoleId() == 2) {
					%>
					<li class="nav-item"><a class="nav-link" href="<%=TMSView.USER_PACKAGE_CTL%>">Tour
							Package</a></li>
							
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.ENQUIRIES_CTL%>">Enquires</a></li>
						
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.ISSUES_CTL%>">Issue</a></li>
						
						<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.BOOKING_LIST_CTL%>">Booking History</a></li>

					<%
						}
					%>

					<%
						} else {
					%>

					<li class="nav-item"><a class="nav-link" href="<%=TMSView.USER_PACKAGE_CTL%>">Tour
							Package</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=TMSView.ABOUTUS_CTL%>">AboutUs</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="<%=TMSView.CONTACT_CTL%>">Contact</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.ENQUIRIES_CTL%>">Enquires</a></li>

					<%
						}
					%>
				</ul>
				<ul class="navbar-nav nav-flex-icons">
					<%
						if (userLoggedIn) {
					%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><%=welcomeMsg%></a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="<%=TMSView.MY_PROFILE_CTL%>">My
								Profile</a> <a class="dropdown-item"
								href="<%=TMSView.CHANGE_PASSWORD_CTL%>">Change Password</a> <a
								class="dropdown-item"
								href="<%=TMSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOG_OUT%>">Logout</a>
						</div></li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.LOGIN_CTL%>">SignIn</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=TMSView.USER_REGISTRATION_CTL%>">SignUp</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</nav>

	</header>
	<!--Main Navigation-->
</body>
</html>

