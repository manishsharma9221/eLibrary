<%@page import="org.hibernate.Session"%>
<%@page import="javax.print.attribute.standard.Severity"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import=" static in.co.impetus.constants.Constants.*"%>
<%
	HttpSession session = request.getSession(false);

%>

<!DOCTYPE html>
<html lang="en">

<head>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Readers Paradise</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/mytheme/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<c:url value="/resources/mytheme/css/modern-business.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/mytheme/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<style>
.loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background:
		url('${pageContext.request.contextPath}/images/page-loader.gif') 50%
		50% no-repeat rgb(249, 249, 249);
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$(".loader").fadeOut("slow");
	})
</script>




<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">

<!-- <script type="text/javascript" language="javascript" -->
<!-- 	src="http://code.jquery.com/jquery-1.10.2.min.js"></script> -->
<script src="<c:url value="/resources/mytheme/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').dataTable( {
            language: {
                searchPlaceholder: "Search within table "
            }
        } );
	});
</script><body>
	<div class="
loader"></div>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> Welcome to Readers Paradise</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="j_spring_security_logout">Logout</a></li>



					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <B> <%
 	                          out.println("+" + session.getAttribute("uname"));
                                                    %>
						</B> <b class="caret"></b></a>
						<ul class="dropdown-menu">
				
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<!-- Page Content -->
	<div class="container">

		<!-- 	<button onclick="func();">test</button> -->

		<!-- Page Heading/Breadcrumbs -->
		<div class="row clearfix">

			<div class="col-md-4 column">
				<div class="page-header">
					<h1>
						Hi,
						<%
						out.println(session.getAttribute("firstname"));
					    %>


					</h1>
				</div>
			</div>
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column"></div>
			<div class="col-lg-12">
				<ol class="nav nav-tabs">
					<li><a href="admin">Home</a></li>
					<li class="active"><a href="admin_View_Delivery_Requests.html">Delivery
							Requests</a></li>
					<li><a href="admin_View_Return_Requests.html">Active
							Return Requests</a></li>
					<li><a href="admin_View_Active_Users.html">Active Users</a></li>
					<li><a href="admin_addSubscriptionXML.html">Add Plans</a></li>
					<li><a href="admin_booklist.html">Book Stock</a></li>
					<li><a href="admin_addbook.html">Add books</a></li>
					<li><a href="admin_Reports.html">Reports</a></li>



				</ol>

			</div>
		</div>
		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">
			<div class="col-lg-12">

				<table id="example" class="display table table-striped"
					cellspacing="0" width="100% 
			cellspacing="0" >
					<caption>
						<h2>Delivery Requests</h2>
					</caption>
					<thead>
						<tr class="danger">
							<th>Requested By</th>
							<th>Title</th>
							<th>Author</th>
							<th>Category</th>
							<th>Delivery Address</th>
							<th>Requested On</th>
							<th>Request Status</th>
							<th>Accept Request</th>
							<th>Deny Request</th>
							<th></th>
							<th></th>
						
							

						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="s" items="${requests}">

							<tr class="success">
								<form action="admin_Accept_Delivery_Requests" method="POST">

									<td>${s.userName}</td>
									<td>${s.bookSearch.bookTitle}</td>
									<td>${s.bookSearch.bookAuthor}</td>
									<td>${s.bookSearch.bookCategory}</td>
									<td>${s.deliveryAddress}</td>
									<td>${s.deliveryRequestDate}</td>
									<td>${s.deliveryStatus}</td>
									<td><input type="Submit" value="Accept Request"
										name="button" class="btn btn-success btn-sm"></td>
									<td><input type="Submit" value="Deny Request"
										name="button" class="btn btn-danger btn-sm"></td>
									<td><input type="hidden" name="requestId"
										value="${ s.requestId}"></td>
									<td><input type="hidden" name="bookId"
										value="${ s.bookSearch.bookId}"></td>


								</form>
							</tr>

						</c:forEach>


					</tbody>
				</table>


			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Impetus 2000-2014</p>
				</div>
			</div>
		</footer>

	</div>

	
</body>

</html>
