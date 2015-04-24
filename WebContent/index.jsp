<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="user" class="com.test.abc.testquery" scope="request" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>MyServlet_HomePage</title>
<style type="text/css">
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}
</style>
</head>
<body>
	<form action="MyServlet" method="post">
		<table>
			<tr>
				<input type="text" name=tname>
			</tr>
		</table>
		<table>
			<tr>
				<select name="style" size="1">
					<option>TOYOTA
					<option>MAZDA
					<option>LEXUS
					<option>FORD
				</select>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type=checkbox name=displacement value="1600 cc">
					1600 cc</td>
				<td><input type=checkbox name=displacement value="1800 cc">
					1800 cc</td>
				<td><input type=checkbox name=displacement value="2000 cc">
					2000 cc</td>
			</tr>
		</table>
		<table>
			<tr>
				<input type="hidden" name="tname">
				<input type="submit" value="Send" />
			</tr>
		</table>
		<table>
			<c:forEach var="data" items="<%=user.getDatas()%>" varStatus="vstatus">
				Count：${vstatus.count}
				<td><c:out value="${data}"/></td>
			</c:forEach>
  		</table>
		Answer：<%=user.getDatas()%>
	</form>
</body>
</html>