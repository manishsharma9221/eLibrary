<%@ page language="java" contentType="text/html; charset=UTF-8"  
 pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title> Registration Form</title>  


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

<!-- necessary reformed CSS -->
<!--[if IE]>
    <link rel="stylesheet" type="text/css" href="reformed/css/ie_fieldset_fix.css" />
<![endif]-->

<link href="<c:url value="/resources/mytheme/reformed/css/uniform.aristo.css" />" rel="stylesheet">
<link href="<c:url value="/resources/mytheme/reformed/css/ui.reformed.css" />" rel="stylesheet">
<link href="<c:url value="/resources/mytheme/reformed-form-ui-lightness/jquery-ui-1.8.7.custom.css" />" rel="stylesheet">


<script src="<c:url value="/resources/mytheme/js/jquery-1.4.4.js" />"></script>
<script src="<c:url value="/resources/mytheme/js/jquery-ui.js" />"></script>

<script src="<c:url value="/resources/mytheme/reformed/js/jquery.uniform.min.js" />"></script>
<script src="<c:url value="/resources/mytheme/reformed/js/jquery.validate.min.js" />"></script>
<script src="<c:url value="/resources/mytheme/reformed/js/jquery.ui.reformed.min.js" />"></script>


<!-- end necessary reformed js -->
                        
 <style>
dt {
    width: 150px;
    display: inline-block;
    margin-right: 20px;
}

dd {
    display: inline-block;
    width: 150px;
}
</style>
                        
                        
</head>



<script type="text/javascript">

function checkPass()
{
	
    //Store the password field objects into variables ...
    var password = document.getElementById('userPassword');
    var confirmpassword = document.getElementById('confirmpassword');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(password.value == confirmpassword.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        confirmpassword.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        confirmpassword.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  



$(function()
		{ //on doc ready
    //set validation options
    //(this creates range messages from max/min values)
    $.validator.autoCreateRanges = true;
    $.validator.setDefaults({
        highlight: function(input) {
            $(input).addClass("ui-state-highlight");
        },
        unhighlight: function(input) {
            $(input).removeClass("ui-state-highlight");
        },
        errorClass: 'error_msg',
        wrapper : 'dd',
        errorPlacement : function(error, element) {
            error.addClass('ui-state-error');
            error.prepend('<span class="ui-icon ui-icon-alert"></span>');
            error.appendTo(element.closest('dl.ui-helper-clearfix').effect('highlight', {}, 2000));
        }
    });
    function validate(form) {
    	  var e = form.elements;

    	  /* Your validation code. */

    	  if(e['password'].value != e['confirm-password'].value) {
    	    alert('Your passwords do not match. Please type more carefully.');
    	    return false;
    	  }
    	  return true;
    	}
    //call reformed and the validation library on your form
    $('#users').reformed().validate();
});

                        
  	$('#users').reformed({
                styleFileInputs : true, //use the uniform plugin to style file input boxes
                styleRadios : true, //style radios with uniform plugin
                styleCheckboxes : true, //style checkboxes with uniform plugin
                styleSelects : true, //style selects with uniform plugin
                styleButtonsWithUniform : false, //style all form buttons with uniform (false = styled by jquery UI)
                styleDatepicker : true //use jqueryUI datepicker
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
							<li><a href="user_ViewProfile.html">View Profile</a></li>
							<li><a href="user_upgradeplan.htm">Upgrade Plan</a></li>


						</ul></li>
				</ul>
			</div>
			</div>
			</nav>
			
			
	<!-- Page Content -->
	<div class="container">
	
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
			<div class="col-md-4 column">
				<form name="searchform" method="get" action="BookSearchHelper">

					<p>&nbsp;</p>
					<p>
						<input size="40" type="text" required="required"
							placeholder="Search by Category, Author or Book Title "
							name="searchCriteria"> <br>
					</p>
					<button type="submit" class="btn  btn-info">Search Books</button>
				</form>


			</div>
			<div class="col-lg-12">
				<ol class="nav nav-tabs">

					<%-- 					<c:if test="${not empty showSearchedBooks}"> --%>
					<li class="active"><a href="#">My
							Home</a></li>
					<li><a href="user_showBookShelf.html">My
							BookShelf</a></li>
					<li><a href="user_showRequestedBooks.html">Requested Books</a></li>
					<li><a href="user_showHoldingBooks.html">Books Holding</a></li>
					<li><a href="user_ViewHistory">Books Returned(History)</a></li>
					<li><a href="user_Recommendations.html">Books Recommended for
							You</a></li>
					<li><a href="user_SubscriptionHistory">Subscriptions History</a></li>
			


				</ol>

			</div>
		</div>
		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">
			
			<div class="col-lg-12">
	


 <center>  
  
  <div style="color: teal; font-size: 30px"> 
   Edit Profile</div>  
  
  
  
 <div class="reformed-form">
	<form method="post" name="users" id="users" action="user_updateUser.htm">
	
	
		<dl>
		
			<dt>
				<label for="firstName">First Name</label>
			</dt>
			
			<dd><input type="text" id="firstName" class="required lettersonly" name="firstName" value="<c:out value="${user.firstName}"/>" /></dd>
		</dl>
		
		
		<dl>
			<dt>
				<label for="lastName">Last Name</label>
			</dt>
			<dd><input type="text" id="lastName" class="required  lettersonly" name="lastName" value="<c:out value="${user.lastName}"/>" /></dd>
		</dl>
		<dl>
			<dt>
				<label for="userName">Email Id (Username)</label>
			</dt>
			<dd><input type="text" id="userName" class="required  email" name="userName" value="<c:out value="${user.userName}"/>" readonly="readonly" /></dd>
		</dl>
		<dl>
			<dt>
				<label for="userPassword">Password</label>
			</dt>
			<dd><input type="password" id="userPassword" class="required  alphanumunderscorehyphen" name="userPassword"  maxlength="16" value="<c:out value="${user.userPassword}"/>" /></dd>
		</dl>
		
		<!-- <dl>
			<dt>
				<label for="dateOfBirth">Date of Birth</label>
			</dt>
			<dd><input type="text" id="dateOfBirth" class="datepicker required  date" name="dateOfBirth" /></dd>
		</dl> -->
		
		
	<dl> 
			<dt>
				<label for="confirm_password">Confirm Password</label>
			</dt>
			<dd><input type="password" id="confirmpassword" class="required  alphanumunderscorehyphen" name="confirmpassword"  maxlength="16" onkeyup="checkPass(); return false;"/></dd>
		     <span id="confirmMessage" class="confirmMessage"></span>
		
		</dl>
		<dl>
			<dt>
				<label for="state">state</label>
			</dt>
			<dd><input type="text" id="state" class="required " name="state" value="<c:out value="${user.state}"/>" /></dd>
		</dl>
		
		
		<dl>
			<dt>
				<label for="city">city</label>
			</dt>
			<dd><input type="text" id="city" class="required " name="city" value="<c:out value="${user.city}"/>" /></dd>
		</dl>
		
		
	
		<dl>
			<dt>
				<label for="mobile">Mobile No.</label>
			</dt>
			<dd><input type="text" id="mobile" class="required  digits" name="mobile" value="<c:out value="${user.mobile}"/>"  /></dd>
		</dl>
		<dl>
			<dt>
				<label for="primaryLanguage">Primary Language</label>
			</dt>
			<dd>
				<select size="1" name="primaryLanguage" id="primaryLanguage" class="required" value="<c:out value="${user.primaryLanguage}"/>" >
					<option value="English">English</option>
					<option value="Hindi">Hindi</option>
					<option value="French">French</option>
					<option value="German">German</option>
					<option value="Spainish">Spainish</option>
				</select>
			</dd>
		</dl>
		<dl>
			<dt>
				<label for="secondarylanguage">Secondary Language</label>
			</dt>
			<dd>
				<select size="1" name="secondaryLanguage" id="secondaryLanguage" value="<c:out value="${user.secondaryLanguage}"/>" >
					<option value="Hindi">Hindi</option>
					<option value="English">English</option>
					<option value="French">French</option>
					<option value="German">German</option>
					<option value="Spainish">Spainish</option>
				</select>
			</dd>
		</dl>
		
		 			
		<dl>
			<dt>
				<label for="address">Address</label>
			</dt>
			<dd><textarea id="address" class="required" name="address" rows="3" cols="30" >
			<c:out value="${user.address}"/>
</textarea></dd>
		</dl>
		<dl>
			<dt>
				<label for="pincode">Pincode</label>
			</dt>
			<dd><input type="text" id="pincode" class="required  digits" name="pincode"  maxlength="12" value="<c:out value="${user.pincode}"/>"/></dd>
		</dl>
				
		
		<div id="submit_buttons">
		<button type="submit">Submit</button>
			<button type="reset">Reset</button>
			
		</div>
		</form>
</div>
  
  
 </center>  
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
	<!-- /.container -->
 

</body>  
</html>  