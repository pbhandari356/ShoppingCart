<%@ page import="java.util.*, com.shopping.bean.Item" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="cart_item" border="2">
	<tr>
		<th>Item</th>
		<th>Description</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total Price</th>
	</tr>
<%	HashMap<Integer,Item> cart = (HashMap<Integer,Item>) session.getAttribute("cart");
	int totalPrice = 0;	
	for (int i : cart.keySet()) {				
			Item item = cart.get(i); %>   			 
 			<tr>  			
			<td align="center"><%= item.getItem_no() %></td> 
			<td align="center"><%= item.getDescription() %></td>
 			<td align="center"><%= item.getPrice() %></td> 
 			<td align="center"><%= item.getQuantity() %></td>
			<td align="center"><%= item.getQuantity()*item.getPrice()%></td>					
		 	</tr>
 			<% totalPrice +=  item.getQuantity()*item.getPrice(); %> 			
	<%}%>			
</table>

<div>
<label>Total Price: <%= totalPrice%></label>
<form>
<input type="submit" value="Log Off">
</form>
</div>

</body>
</html>