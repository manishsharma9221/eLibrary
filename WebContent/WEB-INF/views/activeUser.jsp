
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	background: url('${pageContext.request.contextPath}/images/page-loader.gif') 50% 50% no-repeat
		rgb(249, 249, 249);
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

<!-- jQuery Version 1.11.0 -->
<script src="<c:url value="/resources/mytheme/js/jquery-1.11.0.js"/>"></script>

<script type="text/javascript" 
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
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

<script>
function userDetails(id){
    
    var checkname=id;
    console.log("chechK" +checkname);
    if(checkname!=""){
        
   
    $.ajax({
        type: "POST",
        url: "admin_customerDetails.htm",
        data: {
            userName : checkname
        },
        cache: false,
        success: function(response){
        	var obj = JSON.parse(response);
        	$("#username").html(obj.data.userName);
        	$("#firstname").html(obj.data.firstName);
        	$("#lastname").html(obj.data.lastName);
        	$("#mobilenumber").html(obj.data.mobile);
        	$("#address").html(obj.data.address);
        	$("#city").html(obj.data.city);
        	$("#state").html(obj.data.state);
        	$("#primarylanguage").html(obj.data.primaryLanguage);
        	$("#secondarylanguage").html(obj.data.secondaryLanguage);
        	
        $('#userModal').modal('toggle');

        },
        error : function(error){
            alert("error"+error);
        },
        fail : function(){
            alert("fail");
        }
        
        });
        }
        
        };

</script>

<style>
span {
    width: 150px;
    margin-left: 30px;
}


</style>

</head>

<body>

<div class=loader></div>

<!-- Modal -->
    <div class="modal fade" id="userModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true"
        style="margin-top: 180px">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background-color: rgb(29, 26, 26)">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel"><font color="white">User Details</font></h4>
                </div>
                <div class="modal-body">
                <table>
                       
                        <tr>
                            <td><B>User Name</B></td>
                            <td><span id="username"></span></td>

                        </tr>

                        <tr>
                            <td><B>First Name</B></td>
                            <td><span id="firstname"></span></td>
                        </tr>

                        <tr>
                            <td><B>Last Name</B></td>
                            <td><span id="lastname"></span></td>
                        </tr>

                        <tr>
                            <td><B>Mobile Number</B></td>
                            <td><span id="mobilenumber"></span></td>
                        </tr>



                        <tr>
                            <td><B>Address</B></td>
                            <td><span id="address"></span></td>

                        </tr>

                        <tr>
                            <td><B>City</B></td>
                            <td><span id="city"></span></td>
                        </tr>
                        <tr>
                            <td><B>State</B></td>
                            <td><span id="state"></span></td>
                        </tr>
                        <tr>
                            <td><B>Primary Language</B></td>
                            <td><span id="primarylanguage"></span></td>
                        </tr>

                        <tr>
                            <td><B>Secondary Language</B></td>
                            <td><span id="secondarylanguage"></span></td>
                        </tr>

                    

                    </table>
                
                
                
                </div>

                <div class="modal-footer">

                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>


                </div>



            </div>
        </div>
    </div>

    <!-- Modal -->


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
					<li><a href="#"><%out.println("+" + session.getAttribute("uname"));%></a></li>	
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
					<li class="active"><a href="admin_View_Active_Users.html">Active
							Users</a></li>
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
						<h2>Active Users</h2>
					</caption>
					<thead>
						<tr class="danger">
							<!--          <th>Image</th> -->
							<th>User Name</th>
							<th>Plan Subscribed</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Max Books Allowed</th>
							<th>Price</th>

						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="s" items="${results}">

							<tr class="success">
								<form action="admin_Accept_Delivery_Requests" method="POST">

									<td><button type ="button"  class="btn btn-link" onclick="userDetails('${s.userName}')">${s.userName}</button></td>
									<td>${s.planName}</td>
									<td>${s.startDate}</td>
									<td>${s.endDate}</td>
									<td>${s.maxBooks}</td>
									<td>${s.price}</td>


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
	<!-- /.container -->


	<!-- 	<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/mytheme/js/bootstrap.min.js"/>"></script>



</body>

</html>
