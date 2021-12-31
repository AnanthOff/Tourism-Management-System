<%@page import="com.tourism.mgt.util.DataUtility"%>
<%@page import="com.tourism.mgt.util.ServletUtility"%>
<%@page import="com.tourism.mgt.ctl.UserRegistrationCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb pink lighten-4">
			<li class="breadcrumb-item"><a class="black-text" href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">User Registration</li>
		</ol>
	</nav>


	<div class="container">
		<div class="row">

			<div class="col-sm-8">
				<div style="margin-top: 18px">
					<h2>
						<b>User Registration</b>
					</h2>
				</div>
				<b><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></b>
				<b><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></b>
				<hr>
					<form action="<%=TMSView.USER_REGISTRATION_CTL%>" method="post">
						<jsp:useBean id="bean" class="com.tourism.mgt.bean.UserBean"
							scope="request"></jsp:useBean>

						<input type="hidden" name="id" value="<%=bean.getId()%>">
						<input type="hidden" name="createdBy"
							value="<%=bean.getCreatedBy()%>"> <input type="hidden"
							name="modifiedBy" value="<%=bean.getModifiedBy()%>"> <input
							type="hidden" name="createdDatetime"
							value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
						<input type="hidden" name="modifiedDatetime"
							value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

						<div class="form-row">
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px;">
								<label for="validationServer015">First name</label> <input
									type="text" class="form-control " name="firstName" value="<%=DataUtility.getStringData(bean.getFirstName())%>">
								<div> <font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("firstName", request)%></font></div>
							</div>
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px">
								<label for="validationServer025">Last name</label> <input
									type="text" class="form-control" name="lastName"  value="<%=DataUtility.getStringData(bean.getLastName())%>">
								<div> <font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("lastName", request)%></font></div>
							</div>

						</div>

						<div class="form-group">
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px">
								<label for="validationServerUsername55">Login</label> <input
									type="text" class="form-control" name="login"  value="<%=DataUtility.getStringData(bean.getLogin())%>">
								<div> <font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("login", request)%></font></div>
							</div>
						</div>

						<div class="form-row">
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px">
								<label for="validationServer015">Password</label> <input
									type="password" class="form-control" name="password" value="<%=DataUtility.getStringData(bean.getPassword())%>">
								<div><font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("password", request)%></font></div>
							</div>
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px">
								<label for="validationServer025">Confirm Password</label> <input
									type="password" class="form-control" name="confirmPassword" value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>">
								<div><font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></div>
							</div>

						</div>

						<div class="form-group">
							<div class="col-md-6 mb-6 md-form" style="padding-left: 0px">
								<label for="validationServerUsername55">Mobile No</label> <input
									type="text" class="form-control" name="mobile" value="<%=DataUtility.getStringData(bean.getMobileNo())%>" >
								<div> <font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("mobile", request)%></font></div>
							</div>
						</div>
						<input type="submit" name="operation"
							class="btn btn-primary btn-sm btn-rounded"
							value="<%=UserRegistrationCtl.OP_SAVE%>"> or <input type="submit" name="operation" class="btn btn-primary btn-sm btn-rounded"
					value="<%=UserRegistrationCtl.OP_RESET%>">
					</form>

			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>




	<%@ include file="Footer.jsp"%>
</body>
</html>