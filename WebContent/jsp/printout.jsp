<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Printout</title>
</head>

<body>



<style>
div{

background-color:<%= session.getAttribute("color") %>;
}

body{
background-image:url("spiration dark.png");
}
</style>
<p><div style="border-width: 4px;  border-style: inset; border-color: red; ">
 Thank you for registering: <%= session.getAttribute("firstName") %>
<%= session.getAttribute("lastName") %><br>
Confirming your details: <br> <br>
<fieldset>
<legend>Personal Information</legend>
Email address is: <%= session.getAttribute("email") %><br>
Your phone number is: <%= session.getAttribute("phoneNumber") %><br>
Make sure to write down your password: <%= session.getAttribute("password") %><br>
</fieldset><br>


You Drink <%= session.getAttribute("coffee") %> cups of coffee daily<br>
You go out to buy coffee <%= session.getAttribute("coffeeMonth") %> times a month<br>
Your favorite coffee shop is <%= session.getAttribute("coffeeShops") %> <br>
Day do you need coffee on the most is <%= session.getAttribute("daysCoffee") %> 
 </div> 
</p>

</body>
</html>