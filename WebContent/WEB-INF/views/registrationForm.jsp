<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>


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



function hideDiv() {
    document.getElementById("plan").style.display = 'none';   
    
  }

$(document).ready(function(){

$('.radiobutton').click(function() {

			var getId = $(this).attr('value');
			$('#planid').val(getId);
		})

$("#plan_id").click(function(){
 document.getElementById("plan").style.display = 'block';    
});
});




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
<script type="text/javascript">

function userIdAvailable(){
  		
  		var checkname=$('#userName').val();
  		console.log("chechK" +checkname);
  		if(checkname!=""){
  			
  		$("#user").show();
  		$.ajax({
  			type: "POST",
  			url: "checkavailability.htm",
  			data: {
  				userName : checkname
  			},
  			cache: false,
  			success: function(response){
  			var result=(response);
  			if(result=="true"){
  			document.getElementById("user").style.color="green";
  			$("#user").html('<span/>Username Avaliable !');
  			document.getElementById("submit").disabled=false;
  			}
  			else
		
  			{
  			document.getElementById("user").style.color="red";
  			$("#user").html('<span class="glyphicon glyphicon-remove-sign" /> This Username is Already Taken');
  			document.getElementById("submit").disabled=true;
  			}
  			},
  			error : function(error){
  				alert(error);
  			},
  			fail : function(){
  				alert("fail");
  			}
  			
  			});
  			}else{
  			$("#user").html('');
  			}
  			
  			};

        </script>



<body onload="hideDiv()">


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
			<a class="navbar-brand" href="index.html">Welcome to Readers
				Paradise</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li></li>
				<li></li>
				<li></li>
				<li class="dropdown">

					<ul class="dropdown-menu">
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</li>
				<li class="dropdown">

					<ul class="dropdown-menu">
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</li>
				<li class="dropdown">

					<ul class="dropdown-menu">
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</li>
				<li><a href="loginform.html"><b>Login</b></a></li>

				<li><a href="registrationForm.html"><b>Register </b></a></li>
			</ul>

		</div>

		<!-- /.navbar-collapse -->

	</div>
	</nav>
	<!-- Page Content -->
	<div class="container">



		<!-- Page Heading/Breadcrumbs -->
		<div class="row clearfix">
			<div class="col-lg-8">

				<center>

					<div style="color: teal; font-size: 30px">&nbsp;&nbsp;&nbsp;&nbsp;</div>




					<div class="reformed-form">
						<form method="post" name="users" id="users" action="Register.htm">


							<dl>

								<dt>
									<label for="firstName">First Name</label> <span><font
										color="red">*</font></span>
								</dt>

								<dd>
									<input type="text" id="firstName" class="required lettersonly"
										name="firstName" value="<c:out value="${user.firstName}"/>" />
								</dd>
							</dl>

							<dl>
								<dt>
									<label for="lastName">Last Name</label> <span><font
										color="red">*</font></span>

								</dt>
								<dd>
									<input type="text" id="lastName" class="required  lettersonly" 
										name="lastName" />
								</dd>
							</dl>
							<dl>
								<dt>
									<label for="userName">Email Id (Username)<font
                                        color="red">*</font></label> 
								</dt>
								<dd>
									<input type="text" id="userName" class="required  email" placeholder ="abc@xyz.com"
										name="userName" onblur="userIdAvailable()" /> 

								</dd>
								<span id="user"></span>
							</dl>
							<dl>
								<dt>
									<label for="userPassword">Password</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<input type="password" id="userPassword"
										class="required  alphanumunderscorehyphen" name="userPassword"
										maxlength="16" />
								</dd>
							</dl>


							<dl>
								<dt>
									<label for="confirm_password">Confirm Password</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<input type="password" id="confirmpassword"
										class="required  alphanumunderscorehyphen"
										name="confirmpassword" maxlength="16"
										onkeyup="checkPass(); return false;" />
								</dd>
								<span id="confirmMessage" class="confirmMessage"></span>

							</dl>

							<dl>
								<dt>
									<label for="state">state</label> <span><font color="red">*</font></span>
								</dt>
								<dd>
									<input type="text" id="state" class="required " name="state" />
								</dd>
							</dl>


							<dl>
								<dt>
									<label for="city">city</label> <span><font color="red">*</font></span>
								</dt>
								<dd>
									<input type="text" id="city" class="required " name="city" />
								</dd>
							</dl>



							<dl>
								<dt>
									<label for="mobile">Mobile No.</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<input type="text" id="mobile" class="required  digits" placeholder ="9999999999"
										name="mobile" minlength="10" maxlength="10" />
								</dd>
							</dl>
							<dl>
								<dt>
									<label for="primaryLanguage">Primary Language</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<select size="1" name="primaryLanguage" id="primaryLanguage"
										class="required">
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
									<label for="secondarylanguage">Secondary Language <font
                                        color="red">*</font></label> <span></span>
								</dt>
								<dd>
									<select size="1" name="secondaryLanguage"
										id="secondaryLanguage">
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
									<label for="planId">Select Plan</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<input type="text" id="planid" readonly="readonly" required="required"
										name="planId" />


								</dd>
								<dd>
									<input name="commit" type="button" value="Browse Plan"
										id="plan_id" class="btn btn-xs btn-success" />


								</dd>
							</dl>

							<dl>
								<dt>
									<label for="address">Address</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<textarea id="address" class="required" name="address" rows="3"
										cols="20">
                                   </textarea>
								</dd>
							</dl>
							<dl>
								<dt>
									<label for="pincode">Pincode</label> <span><font
										color="red">*</font></span>
								</dt>
								<dd>
									<input type="text" id="pincode" class="required  digits"
										name="pincode" minlength="6" maxlength="12" />
								</dd>
							</dl>

							<div id="submit_buttons">
								<button type="submit">Submit</button>
								<button type="reset">Reset</button>
							</div>
						</form>
					</div>

				</center>

			</div>
			<div id="plan" class="col-sm-3 col-md-2 sidebar">
				<p>&nbsp;</p>
				<p>&nbsp;</p>

				<c:if test="${!empty plansList}">
					<table id="example" class="table table-striped" cellspacing="0"
						width="100% 
			      cellspacing="0">
						<caption>
							<h2>Subscriptions Plans</h2>
						</caption>
						<thead>
							<tr class="danger">



								<th>PlanName</th>
								<th>Maximum Books</th>
								<th>Price</th>
								<th>Maximum Days</th>
								<th>Subscribe</th>
								<th></th>


							</tr>
						</thead>
						<tbody>
							<c:forEach items="${plansList}" var="plans">
								<tr>

									<td><c:out value="${plans.planName}" /></td>
									<td><c:out value="${plans.maxBooks}" /></td>
									<td><c:out value="${plans.price}" /></td>
									<td><c:out value="${plans.maxDays}" /></td>
									<td><input type="radio" name="planRadio" id="radio_value"
										class="radiobutton" value="${plans.planId}"></td>



									<td><input type="hidden" name="planId"
										value="${plans.planId}"></td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</c:if>

			</div>
		</div>
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
