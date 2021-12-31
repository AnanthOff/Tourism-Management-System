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
			<li class="breadcrumb-item"><a class="black-text"
				href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">Package</li>
		</ol>
	</nav>


	<div class="container">
		<div class="row">

			<div class="col-sm-8">
				<div style="margin-top: 18px">
					<h2>
						<b>Package View</b>
					</h2>
				</div>
				<b><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></b>
				<b><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></b>
				<hr>
				<form action="<%=TMSView.PACKAGE_CTL%>" method="post"
					enctype="multipart/form-data">
					<jsp:useBean id="bean" class="com.tourism.mgt.bean.PackageBean"
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
							<label for="validationServerUsername55">Type</label> <input
								type="text" class="form-control" name="type"
								value="<%=DataUtility.getStringData(bean.getType())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("type", request)%></font>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">Price</label> <input
								type="text" class="form-control" name="price"
								value="<%=DataUtility.getStringData(bean.getPrice())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("price", request)%></font>
							</div>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<textarea id="form7" class="md-textarea form-control" rows="3"
								name="detail"><%=DataUtility.getStringData(bean.getDetail())%></textarea>
							<label for="form7">Detail</label>
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("detail", request)%></font>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<textarea id="form7" class="md-textarea form-control" rows="3"
								name="feature"><%=DataUtility.getStringData(bean.getFeature())%></textarea>
							<label for="form7">Feature</label>
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("feature", request)%></font>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<textarea id="form7" class="md-textarea form-control" rows="3"
								name="location"><%=DataUtility.getStringData(bean.getLocation())%></textarea>
							<label for="form7">Location</label>
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("location", request)%></font>
							</div>
						</div>
					</div>






						<div class="form-group">
							<div class="col-md-6 mb-3 md-form" style="padding-left: 0px">
								 <input
									type="file" class="form-control" name="image"  value="<%=DataUtility.getStringData(bean.getImage())%>">
								<div> <font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("image", request)%></font></div>
							</div>
						</div>

					<input type="submit" name="operation"
						class="btn btn-primary btn-sm btn-rounded"
						value="<%=UserRegistrationCtl.OP_SAVE%>"> or <input
						type="submit" name="operation"
						class="btn btn-primary btn-sm btn-rounded"
						value="<%=UserRegistrationCtl.OP_RESET%>">
				</form>

			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>