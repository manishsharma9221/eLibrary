<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

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

<!-- Bootstrap Core JavaScript -->
<%--     <script src="${pageContext.request.contextPath}/resources/mytheme/js/bootstrap.min.js"></script> --%>

<!-- jQuery Version 1.11.0 -->
<!--      <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> -->

<%--     <script src="${pageContext.request.contextPath}/resources/mytheme/assets/js/script.js"></script> --%>


<!-- Our CSS stylesheet file -->
<%--         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mytheme/assets/css/styles.css" /> --%>

<!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<style>
.loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('WebContent/images/page-loader.gif') 50% 50% no-repeat
		rgb(249, 249, 249);
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$(".loader").fadeOut("slow");
	})
</script>



</head>

<body>
	<div class="loader"></div>

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
				<a class="navbar-brand" href="#">Welcome to Readers
					Paradise</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1"></div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Welcome to <I>READERS PARADISE</I>
				</h1>
				<ol class="breadcrumb">
					<li><a href="/BookLibrary/">Home</a></li>

				</ol>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-8" style="border-right: solid">

				<table class="table table-striped" cellspacing="0"
					width="100% 
			cellspacing="0" >
					<caption>
						<h1>New Arrivals</h1>
					</caption>
					<thead>
						<tr class="danger">
							<!--          <th>Image</th> -->
							<th>Book Image</th>
							<th>Title</th>
							<th>Author</th>
							<th>Publisher</th>
							<th>Category</th>

							<th>Description</th>


						</tr>
					</thead>
					<tbody>

						<c:forEach var="r" items="${recentBooksList}">
							<tr>

								<td><img
									src="${pageContext.request.contextPath}/images/<c:out value="${r.bookImage}" />"
									height="140px" width="120px" align="middle"></td>
								<td>${r.bookTitle}</td>
								<td>${r.bookAuthor}</td>
								<td>${r.bookPublisher}</td>
								<td>${r.bookCategory}</td>
								<td>${r.bookDescription}</td>


							</tr>

						</c:forEach>

					</tbody>
				</table>


			</div>

			<div class="col-md-4">
				<div class="panel panel-default">

					<div id="formContainer">

						<c:if test="${not empty LoginForm}">

							<div class="well">
					<h4>Login</h4>
					<form action="<c:url value='j_spring_security_check' />" method="post">
						<div class="control-group form-group">
							<div class="controls">
								<input type="email" class="form-control" name="user_name" required
									placeholder="Email">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="control-group form-group">
							<div class="controls">
								<input type="password" class="form-control" name="user_password"
									required placeholder="Password">
								<p class="help-block"></p>
							</div>
						</div>
						<div>
						<p style="color: red">${message}</p>
						</div>
						<center>
						<button type="submit" value="Login" class="btn btn-primary">Login</button>
						</center>
					</form>
					<div>
						<p><a href="Recover.html">Forgot Password?</a></p>
					</div>
					<div>
						<p>New User? <a href="registrationForm.html">Sign
													Up here </a></p>
					</div>
					
				</div>
</c:if>
						

						<c:if test="${not empty Recover}">
							<div class="panel-heading">
								<h4>Recover Password</h4>
							</div>

							<center>
							
								<table>
									<form id="recover" method="post" action="RecoverMail.html">
							
										<tr>
											<td><input type="email" name="recoverEmail"
												id="recoverEmail" placeholder="Enter your registered email_id" required="required"
												style="width: 260px" /></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td><input type="submit" name="submit" value="Recover"
												class="btn btn-success btn-sm" /></td>
										</tr>

										<tr>
											<td>Already a member? <a href="loginform.html">Sign
													In</a></td>
										</tr>
										<tr>
											<td>New User? <a href="registrationForm.html">Register
													here</a></td>
										</tr>
									</form>
								</table>
							</center>
						</c:if>

						<c:if test="${not empty RecoverContinue}">
							<center>
								<table>
									<tr>
										<td>${Msg}</td>
									</tr>
									<tr>
										<td>Already a member? <a href="loginform.html">Sign
												In</a></td>
									</tr>
									<tr>
										<td>New User? <a href="registrationForm.html">Register
												here</a></td>
									</tr>
									<tr>

										<td><a href="Recover.html">Retry ?</a></td>

									</tr>

								</table>
							</center>
						</c:if>


					</div>


				</div>
			</div>

		</div>
		<!-- /.row -->





		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!--     jQuery Version 1.11.0 -->
	<!--     <script src="js/jquery-1.11.0.js"></script> -->



	<!-- JavaScript includes -->
	<!-- 		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> -->


</body>

</html>
