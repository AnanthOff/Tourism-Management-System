<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.tourism.mgt.bean.PackageBean"%>
<%@page import="com.tourism.mgt.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tour Packages</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb pink lighten-4">
			<li class="breadcrumb-item"><a class="black-text"
				href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">Tour Packages</li>
		</ol>
	</nav>
	<br>
	<b><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></b>
		<b><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></b>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="row row-cols-1 row-cols-md-3">
				
				<%
				PackageBean bean = null;
				List list = ServletUtility.getList(request);
				Iterator<PackageBean> iterator = list.iterator();
				while (iterator.hasNext()) {
					bean = iterator.next();
				%>
					<div class="col mb-4">
						<!-- Card -->
						<div class="card">
							<!--Card image-->
							<div class="view overlay">
								<img class="card-img-top"
									src="<%=TMSView.IMAGE_FOLDER+bean.getImage()%>"
									alt="Card image cap"> <a href="#!">
									<div class="mask rgba-white-slight"></div>
								</a>
							</div>

							<!--Card content-->
							<div class="card-body">

								<!--Title-->
								<h4 class="card-title"><%=bean.getName()%></h4>
								<p>Type :- <%=bean.getType()%></p>
								<p>Feature :- <%=bean.getFeature()%></p>
								<h6 style="color: orange;">Price :- <%=bean.getPrice()%></h6>
								<p class="card-text"><%=bean.getDetail()%></p>
								<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
								<%if(userLoggedIn){%>
								<a href="<%=TMSView.BOOKING_CTL%>?pkId=<%=bean.getId()%>" class="btn btn-light-blue btn-md">Book</a>
								<%}else{%>
								<a href="<%=TMSView.LOGIN_CTL%>" class="btn btn-light-blue btn-md">Book</a>
								<%} %>
							</div>
						</div>
						<!-- Card -->
					</div>
					<%} %>
				</div>
			</div>
		</div>
</div>

		<%@ include file="Footer.jsp"%>
</body>
</html>