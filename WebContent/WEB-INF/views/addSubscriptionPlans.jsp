<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="reformed-form">
	<form method="post" name="plans" id="plans" action="subsriptionPlansInsert.htm">
		<dl>
			<dt>
				<label for="maxBooks">Maximum Books</label>
			</dt>
			<dd><input type="text" id="maxBooks" class="required  digits" name="maxBooks" /></dd>
		</dl>
		<dl>
			<dt>
				<label for="price">Price</label>
			</dt>
			<dd><input type="text" id="price" class="required  digits" name="price" /></dd>
		</dl>
		<dl>
			<dt>
				<label for="maxDays">Maximum Days</label>
			</dt>
			<dd><input type="text" id="maxDays" class="required  digits" name="maxDays" /></dd>
		</dl>
		<dl>
			<dt>
				<label for="planName">Name of plan</label>
			</dt>
			<dd><input type="text" id="planName" class="required" name="planName" /></dd>
		</dl>
		<div id="submit_buttons">
			<button type="reset">Reset</button>
			<button type="submit">Submit</button>
			
<a href="subscriptionPlansList.htm">Click here to see subscription plan details</a>
			
		</div>
		</form>
</div>



</body>
</html>