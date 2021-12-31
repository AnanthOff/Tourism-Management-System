<%@page import="com.tourism.mgt.ctl.EnquiriesCtl"%>
<%@page import="com.tourism.mgt.util.DataUtility"%>
<%@page import="com.tourism.mgt.util.ServletUtility"%>
<%@page import="com.tourism.mgt.ctl.UserRegistrationCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquires</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb pink lighten-4">
			<li class="breadcrumb-item"><a class="black-text"
				href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">Enquires</li>
		</ol>
	</nav>


	<div class="container">
		<div class="row">

			<div class="col-sm-8">
				<div style="margin-top: 18px">
					<h2>
						<b>Enquires</b>
					</h2>
				</div>
				<b><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></b>
				<b><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></b>
				<hr>
				<form action="<%=TMSView.ENQUIRIES_CTL%>" method="post"
					>
					<jsp:useBean id="bean" class="com.tourism.mgt.bean.EnquiriesBean"
						scope="request"></jsp:useBean>

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedBy()%>"> <input type="hidden"
						name="createdDatetime"
						value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
					<input type="hidden" name="modifiedDatetime"
						value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">



					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">Name</label> <input
								type="text" class="form-control" name="name"
								value="<%=DataUtility.getStringData(bean.getName())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("name", request)%></font>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">Email Id</label> <input
								type="text" class="form-control" name="email"
								value="<%=DataUtility.getStringData(bean.getEmail())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("email", request)%></font>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">Mobile No</label> <input
								type="text" class="form-control" name="mobileNo"
								value="<%=DataUtility.getStringData(bean.getMobileNo())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("mobileNo", request)%></font>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">Subject</label> <input
								type="text" class="form-control" name="subject"
								value="<%=DataUtility.getStringData(bean.getSubject())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("subject", request)%></font>
							</div>
						</div>
					</div>


					

				

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<textarea id="form7" class="md-textarea form-control" rows="3"
								name="description"><%=DataUtility.getStringData(bean.getDescription())%></textarea>
							<label for="form7">Description</label>
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("description", request)%></font>
							</div>
						</div>
					</div>

					<input type="submit" name="operation"
						class="btn btn-primary btn-sm btn-rounded"
						value="<%=EnquiriesCtl.OP_SAVE%>"> or <input
						type="submit" name="operation"
						class="btn btn-primary btn-sm btn-rounded"
						value="<%=EnquiriesCtl.OP_RESET%>">
				</form>

			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>