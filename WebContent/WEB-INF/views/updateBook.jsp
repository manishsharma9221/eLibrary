<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- necessary reformed CSS -->
<!--[if IE]>
    <link rel="stylesheet" type="text/css" href="reformed/css/ie_fieldset_fix.css" />
<![endif]-->

<link
	href="<c:url value="/resources/mytheme/reformed/css/uniform.aristo.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/mytheme/reformed/css/ui.reformed.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/mytheme/reformed-form-ui-lightness/jquery-ui-1.8.7.custom.css" />"
	rel="stylesheet">


<script src="<c:url value="/resources/mytheme/js/jquery-1.4.4.js" />"></script>
<script src="<c:url value="/resources/mytheme/js/jquery-ui.js" />"></script>

<script
	src="<c:url value="/resources/mytheme/reformed/js/jquery.uniform.min.js" />"></script>
<script
	src="<c:url value="/resources/mytheme/reformed/js/jquery.validate.min.js" />"></script>
<script
	src="<c:url value="/resources/mytheme/reformed/js/jquery.ui.reformed.min.js" />"></script>


<!-- end necessary reformed js -->



</head>



<script type="text/javascript">
	$(function() { //on doc ready
		//set validation options
		//(this creates range messages from max/min values)
		$.validator.autoCreateRanges = true;
		$.validator.setDefaults({
			highlight : function(input) {
				$(input).addClass("ui-state-highlight");
			},
			unhighlight : function(input) {
				$(input).removeClass("ui-state-highlight");
			},
			errorClass : 'error_msg',
			wrapper : 'dd',
			errorPlacement : function(error, element) {
				error.addClass('ui-state-error');
				error.prepend('<span class="ui-icon ui-icon-alert"></span>');
				error.appendTo(element.closest('dl.ui-helper-clearfix').effect(
						'highlight', {}, 2000));
			}
		});

		//call reformed and the validation library on your form
		$('#books').reformed().validate();
	});

	$('#book').reformed({
		styleFileInputs : true, //use the uniform plugin to style file input boxes
		styleRadios : true, //style radios with uniform plugin
		styleCheckboxes : true, //style checkboxes with uniform plugin
		styleSelects : true, //style selects with uniform plugin
		styleButtonsWithUniform : false, //style all form buttons with uniform (false = styled by jquery UI)
		styleDatepicker : true
	//use jqueryUI datepicker
	}).validate();
</script>

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


					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>


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
					<li><a href="admin_Reports.html">Reports</a></li>



				</ol>

			</div>
		</div>
		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">
			<div class="col-lg-12">
				<p>
					<font color="RED"> ${Msg1}</font> <font color="GREEN">
						${Msg}</font>
				</p>

				<div class="reformed-form">
					<form method="post" name="books" id="books"
						action="admin_bookinsert.html " enctype="multipart/form-data">
						<dl>
							<dt>
								<label for="bookCategory">Category</label> <span><font
									color="red">*</font></span>

							</dt>
							<dd>
								<input type="text" id="bookCategory" class="required"
									name="bookCategory"
									value="<c:out value="${book.bookCategory}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookTitle">Title</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="text" id="bookTitle" class="required"
									name="bookTitle" value="<c:out value="${book.bookTitle}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookId">Book ID</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="text" id="bookId" class="required" name="bookId"
									value="<c:out value="${book.bookId}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookAuthor">Author</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="text" id="bookAuthor" class="required"
									name="bookAuthor" value="<c:out value="${book.bookAuthor}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookDescription">Description</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="text" id="bookDescription" name="bookDescription"
									value="<c:out value="${book.bookDescription}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookPublisher">Publisher</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="text" id="bookPublisher" name="bookPublisher"
									value="<c:out value="${book.bookPublisher}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="bookAvailablity">Copies</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="number" min ="0" id="bookAvailablity" name="bookAvailablity"
									value="<c:out value="${book.bookAvailablity}"/>" />
							</dd>
						</dl>
						<dl>
							<dt>
								<label for="sno"></label>
							</dt>
							<dd>
								<input type="hidden" id="sno" name="sno"
									value="<c:out value="${book.sno}"/>" />
							</dd>
						</dl>



						<dl>
							<dt>
								<label for="bookImage">Book Image</label> <span><font
									color="red">*</font></span>
							</dt>
							<dd>
								<input type="file" id="file" name="file" />
							</dd>
						</dl>
						<div id="submit_buttons">
							<button type="submit">Submit</button>
							<button type="reset">Reset</button>

						</div>
					</form>
				</div>
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