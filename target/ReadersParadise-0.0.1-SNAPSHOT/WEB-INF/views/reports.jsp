<!DOCTYPE HTML>
<html lang="en-US">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2,
			onClose : function(selectedDate) {
				$("#to").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2,
			onClose : function(selectedDate) {
				$("#from").datepicker("option", "maxDate", selectedDate);
			}
		});
	});
</script>
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




<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">

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
</script>

<style>
.category {
	width: 386px;
}
.author
{
margin-left: 16px;
width: 386px;
}
.from
{
margin-left: 82px;
}
</style>

</head>
<body>

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
 	out.println("+" + session.getAttribute("firstname"));
 %>
						</B> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="ViewProfile.html">View Profile</a></li>
							<li><a href="#" data-toggle="modal"
								data-target="#loginModal">LogIn</a></li>


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
					<li><a href="admin_View_Delivery_Requests.html">Delivery
							Requests</a></li>
					<li><a href="admin_View_Return_Requests.html">Active
							Return Requests</a></li>
					<li><a href="admin_View_Active_Users.html">Active Users</a></li>
					<li><a href="admin_addSubscriptionXML.html">Add Plans</a></li>
					<li><a href="admin_booklist.html">Book Stock</a></li>
					<li><a href="admin_addbook.html">Add books</a></li>
					<li class="active"><a href="admin_Reports.html">Reports</a></li>



				</ol>

			</div>
		</div>
		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">
			<div class="col-lg-12">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<form:form action="admin_Reports.html" method="post"
					commandName="bookDetails">
					<table>
						<tr>

							<td><label for="author">Choose Author:</label> <select
								name="author" id="author" class ="author">
									<option value="all">All</option>
									<c:forEach items="${Authors}" var="Authors" varStatus="i">
										<option value="${Authors}">${Authors}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><label for="category">Choose Category:</label> <select
								name="category" id="category" class="category">
									<option value="all">All</option>
									<c:forEach items="${Categories}" var="Categories">
										<option value="${Categories}">${Categories}</option>
									</c:forEach>
							</select></td>

						</tr>

						<tr>
							<td><label for="from">From:</label> <input type="text"
								id="from" name="from" required="required" class = "from""> 
								<label for="to" style="margin-left: 14px;">to:</label> <input type="text" id="to" name="to"
								required="required"> <br> <br> <input
								type="submit" name="searchbook" class="btn btn-success"
								value="Get Reports" /> <br> <br></td>
						</tr>


					</table>
				</form:form>


				<c:if test="${not empty report}">

					<form:form action="admin_GeneratePdf.pdf" method="post">
						<input type="submit" value="Generate PDF" class="btn btn-success" />
					</form:form>

					<table id="example" class="table table-striped" cellspacing="0"
						width="100%" >
						<caption>
							<h1>Rented Books</h1>
						</caption>
						<thead>
							<tr class="danger">
								<th>Category</th>
								<th>Author</th>
								<th>Title</th>
								<th>Total Requests</th>
								<th>Cancelled</th>
								<th>Returned</th>
								<th>Delivered</th>




							</tr>
						</thead>
						<tbody>
							<c:forEach var="r" items="${report}">

								<tr class="success">

									<td>${r[0]}</td>
									<td>${r[1]}</td>
									<td>${r[2]}</td>
									<td>${r[3]}</td>
									<td>${r[4]}</td>
									<td>${r[5]}</td>
									<td>${r[6]}</td>


								</tr>

							</c:forEach>
						</tbody>
					</table>


				</c:if>
			</div>
		</div>

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
