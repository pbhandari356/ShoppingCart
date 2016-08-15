<%@ page import="java.util.*, com.shopping.bean.Item" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

function deleteRow(r){
	var table = document.getElementById("cart_item")
	var i = r.parentNode.parentNode.rowIndex;	
	table.deleteRow(i);	
}

</script>

<div class="table" align="center">
<form action="checkout" method="post">
<table id="cart_item" border="2">
	<tr>
		<th>Item</th>
		<th>Description</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Remove</th>
	</tr>
<%	HashMap<Integer,Item> cart = (HashMap<Integer,Item>) session.getAttribute("cart");%>	
	<% for (int i : cart.keySet()) {				
			Item item = cart.get(i); %>   			 
 			<tr>  			
			<td align="center"><%= item.getItem_no() %></td> 
			<td align="center"><%= item.getDescription() %></td>
 			<td align="center"><%= item.getPrice() %></td> 
 			<td align="center"><select name="<%= item.getItem_no() %>"><% for (int numb = 1; numb <= item.getQuantity(); numb++) {%>
 				<option><%= numb %><%}%></option> 			
 			</select></td>
			<td align="center">
				<input type="hidden" name = "<%= item.getItem_no()%>">							
				<button onclick="deleteRow(this)">Delete Item</button></td>
		 	</tr> 			
	<%}%>			
</table>
<input type="submit" value="Confirm Checkout"/>
<input type="submit" formaction="displayInventory" value="Add More Items"/>
</form>
</div>

<div>


</div>

<div>
<form>
<input type="submit" value="Log Off">
</form>
</div>


</body>
</html>