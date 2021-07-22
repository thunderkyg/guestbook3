<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./delete" method="get">
		<input type="hidden" name="guestbookNo" value="${requestScope.no}"> 
		비밀번호 <input type="text" name="password" value="">
		<button type="submit">확인</button>
		<br> <a href="./addlist">매인으로 돌아가기</a>
	</form>
</body>
</html>