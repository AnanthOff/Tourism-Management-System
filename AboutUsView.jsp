<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AboutUs</title>
</head>
<body>
<%@ include file="Header.jsp"%>
	<br>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb pink lighten-4">
			<li class="breadcrumb-item"><a class="black-text"
				href="<%=TMSView.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active">AboutUs</li>
		</ol>
	</nav>

<div class="about-section paddingTB60 gray-bg">
                <div class="container">
                    <div class="row">
						<div class="col-md-7 col-sm-6">
							<div class="about-title clearfix">
								<h1>About <span>Us</span></h1>
								<h3>Welcome to our Booking Portal </h3>
								<p class="about-paddingB"> Why do people plan and go on a tour? To enjoy, create memories, relax themselves and explore. Manually handling a tour is difficult, hectic and swallows a lot of time and energy. That's where we come in. Our web application not only saves your time, but also helps you explore new places at your own will. </p>
								<p> Enjoy your travel. Bon Voyage!</p>
						<div class="about-icons"> 
	        </div>
							</div>
						</div>
						<div class="col-md-5 col-sm-6">
							<div class="about-img">
								<img src="https://devitems.com/preview/appmom/img/mobile/2.png" alt="">
							</div>
						</div>	
                    </div>
                </div>
            </div>
<%@ include file="Footer.jsp"%>
</body>
</html>