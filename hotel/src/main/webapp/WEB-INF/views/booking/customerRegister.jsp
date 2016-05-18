<%@ include file="../header.jsp" %>

	<h1>Customer Registration</h1>
	<form action="/hotel/saveCustomer"  method="post">
		
			<table border="0">
			
			<tr>
				<td>First Name:</td><td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Last Name:</td><td><input type="text" name="lname" /></td> 
			</tr>
			<tr>
				<td>Email:</td><td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Phone:</td><td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Street:</td><td><input type="text" name="street" /></td>
			</tr>
			<tr>
				<td>City:</td><td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>State:</td><td><input type="text" name="state" /></td>
			</tr>
			</table>
			<p><input type="submit" value="Register"/></p>	
	</form>

<%@ include file="../footer.jsp" %>