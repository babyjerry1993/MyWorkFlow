<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>showUser_jstl的用法</title>
</head>
<body>
	<h1>Success_____查看所有用户</h1>
	<hr />
	<table>
		<thead>
			<tr>
				<th width="200">userId</th>
				<th width="200">userName</th>
				<th width="200">userPassword</th>
				<th width="200">userEmail</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="item">
				<tr>
					<td width="200">${item["userid"]}</td>
					<td width="200">${item["username"]}</td>
					<td width="200">${item["userpassword"]}</td>
					<td width="200">${item["useremail"]}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>