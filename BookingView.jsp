<%@page import="com.tourism.mgt.model.PackageModel"%>
<%@page import="com.tourism.mgt.bean.PackageBean"%>
<%@page import="com.tourism.mgt.ctl.BookingCtl"%>
<%@page import="com.tourism.mgt.ctl.IssuesCtl"%>
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
<title>Issues</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb pink lighten-4">
			<li class="breadcrumb-item"><a class="black-text"
				href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">Booking</li>
		</ol>
	</nav>
	
	<!-- News jumbotron -->
<div class="jumbotron text-center hoverable p-4">

  <!-- Grid row -->
  <div class="row">

    <!-- Grid column -->
    <div class="col-md-4 offset-md-1 mx-3 my-3">
						<% Long pId=(Long)session.getAttribute("pId");
							PackageBean pBean=new PackageModel().findByPK(DataUtility.getLong(String.valueOf(pId)));
						%>
      <!-- Featured image -->
      <div class="view overlay">
        <img src="<%=TMSView.IMAGE_FOLDER+pBean.getImage()%>" class="img-fluid" alt="Sample image for first version of blog listing">
        <a>
          <div class="mask rgba-white-slight"></div>
        </a>
      </div>

    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-md-7 text-md-left ml-3 mt-3">
				<b><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></b>
				<b><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></b>
      <!-- Excerpt -->
      <a href="#!" class="green-text">
        <h6 class="h6 pb-1">Price - <%=pBean.getPrice()%></h6>
      </a>

      <h4 class="h4 mb-4"><%=pBean.getName()%></h4>

      <p class="font-weight-normal"><%=pBean.getDetail()%></p>
      <p class="font-weight-normal"><strong>Feature - </strong><%=pBean.getFeature()%></p>
      <p class="font-weight-normal"><strong>Type - </strong><%=pBean.getType()%></p>
      <p class="font-weight-normal"><strong>Location - </strong><%=pBean.getLocation()%></p>

		<form action="<%=TMSView.BOOKING_CTL%>" method="post"
					>
					<jsp:useBean id="bean" class="com.tourism.mgt.bean.BookingBean"
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
							<label for="validationServerUsername55">To Date</label> <input
								type="text" class="form-control" name="toDate"
								value="<%=DataUtility.getDateString(bean.getToDate())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("toDate", request)%></font>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-9 mb-4 md-form" style="padding-left: 0px">
							<label for="validationServerUsername55">From Date</label> <input
								type="text" class="form-control" name="fromDate"
								value="<%=DataUtility.getDateString(bean.getFromDate())%>">
							<div>
								<font color="red" style="font-size: 13px"><%=ServletUtility.getErrorMessage("fromDate", request)%></font>
							</div>
						</div>
					</div>

					<input type="submit" name="operation"
						class="btn btn-success"
						value="<%=BookingCtl.OP_SAVE%>"> 
				</form>


    </div>
    <!-- Grid column -->

  </div>
  <!-- Grid row -->

</div>
<!-- News jumbotron -->

	<%@ include file="Footer.jsp"%>
</body>
</html>