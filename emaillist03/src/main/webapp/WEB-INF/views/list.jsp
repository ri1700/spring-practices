<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<c:forEach items="${list }" var="vo">
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<td>성</td>
				<td>${vo.firstName }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${vo.lastName }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${vo.email }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/delete/${vo.id }">삭제</a>
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	<p>
		<a href="${pageContext.request.contextPath}/add">메일등록</a>
	</p>
	<br>
</body>
</html>