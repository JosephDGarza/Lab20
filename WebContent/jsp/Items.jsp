<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "coffeeshopdb";
String userId = "gcjdbc";
String password = "gcjdbc";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Welcome to our store!</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="e81328">
<td><b>ItemId</b></td>
<td><b>ItemName</b></td>
<td><b>Description</b></td>
<td><b>Quantity</b></td>
<td><b>Price</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM coffeeshopdb.items";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#4ea8b1">

<td><%=resultSet.getString("ItemId") %></td>
<td><%=resultSet.getString("ItemName") %></td>
<td><%=resultSet.getString("Description") %></td>
<td><%=resultSet.getString("Quantity") %></td>
<td><%=resultSet.getString("Price") %></td>

</tr>

<% 
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>