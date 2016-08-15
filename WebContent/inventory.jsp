<%@ page import="com.shopping.bean.Item, java.util.HashMap" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="style.css"> -->
</head>
<body>
<table border="2">
	<tr>
		<th>Item ID</th>
		<th>Description</th>
		<th>Price</th>
		<th>Add To Cart</th>
	</tr>
		
	<%	HashMap<Integer,Item> data = (HashMap<Integer,Item>) session.getAttribute("inventory");	
	 	for (int i : data.keySet()) { 
	 		Item item = data.get(i); %>  
		<form method="post" action="updateCart">
		<tr>		
			<td align="center"><%= item.getItem_no() %></td>
			<td align="center"><%= item.getDescription() %></td>
			<td align="center"><%= item.getPrice() %></td>				
			<td align="center">
					<input type="hidden" name="item_no" value="<%= item.getItem_no() %>"/>	
					<input type="hidden" name ="action" value="add">									
					<input type="submit" value="Add to Cart"/>
			</td>
		</tr>
		</form>
		<%}
	%>						
</table>

<div>
<form action="cart.jsp" method="post">
<input type="submit" value="Proceed To Checkout"/>
</form>
</div>

<div>
<form action="logOut" method="post">
<input type="submit" value="Log Off">
</form>
</div>
</body>
</html>