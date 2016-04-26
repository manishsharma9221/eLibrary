<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Readers Paradise</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/mytheme/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<c:url value="/resources/mytheme/css/modern-business.css" />"
	rel="stylesheet">

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


<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/mytheme/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css">

<!-- <script type="text/javascript" language="javascript" -->
<!--    src="http://code.jquery.com/jquery-1.10.2.min.js"></script> -->
<script src="<c:url value="/resources/mytheme/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
    $('#example').dataTable({
           "processing" : true,
           "serverSide" : true,
           "ajax" : {
                 "url" : "admin_BooksPagination",
                 "dataType" : "json"
           },
           "columns": [
                        { "data": "bookImage" ,
                        	  "mRender" : function ( data, type, full ) {
                        		    return '<img src="${pageContext.request.contextPath}/images/'+data+'"height="140px" width="120px" align="middle"/>';}

                        },
                       { "data": "bookCategory" },
                       { "data": "bookTitle" },
                       { "data": "bookId" },
                       { "data": "bookAuthor" },
                       { "data": "bookDescription" },
                       { "data": "bookPublisher" },
                       { "data": "bookAvailablity" },
                       { "data": "sno" },
                       { "data": "bookId",
                    	    "mRender" : function ( data, type, full ) {
                    	    return '<a href="admin_bookedit.html?bookId='+data+'"><img src="images/edit-icon.png" style="width: 70px; height: 30px;"/></a>';}
                    	
                       },
                       { "data": "bookId" ,
                           "mRender" : function ( data, type, full ) {
                           return '<a href="admin_bookdelete.html?bookId='+data+'"><img src="images/delete.png" style="width: 30px; height: 30px;"/></a>';}
                       
                      },
                      ],
           
                     
    });
});


</script>




</head>
<body>
	<!-- <div class = "loader"></div> -->

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


					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>


	<!-- Page Content -->
	<div class="container">

		<!--    <button onclick="func();">test</button> -->

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
					<li class="active"><a href="admin_booklist.html">Book
							Stock</a></li>
					<li><a href="admin_addbook.html">Add books</a></li>
					<li><a href="admin_Reports.html">Reports</a></li>



				</ol>

			</div>
		</div>
		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">

			<div class="col-lg-12">

				<div class="alert alert-default">
					<a href="#" class="close" data-dismiss="alert"> &times; </a> <B>
						${deleteResult} </B>
					<%
					    session.setAttribute("deleteResult", null);
					%>
				</div>
				<center>


				

						<table id="example" class="display table table-striped"
							cellspacing="0" width="100%">
							<caption>
								<h2>Books Stock</h2>
							</caption>
							<thead>
								<tr class="danger">
									<th>Image</th>
									<th>Category</th>
									<th>Title</th>
									<th>ID</th>
									<th>Author</th>
									<th>Description</th>
									<th>Publisher</th>
									<th>Copies Available</th>
									<th>sno</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>
							</thead>
					
						</table>


				



				</center>
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
