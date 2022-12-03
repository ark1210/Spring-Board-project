<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="POST" action="../editok" accept-charset="utf-8">
    <form:hidden path="seq"/>
    <table id="edit">

        <tr><td>카테고리</td><td><input type="text" name="category" value="${boardVO.category}"/></td></tr>
        <tr><td>제목</td><td><input type="text" name="title" value="${boardVO.title}"/></td></tr>
        <tr><td>글쓴이</td><td><input type="text" name="writer" value="${boardVO.writer}"/></td></tr>
        <tr><td>내용</td><td><textarea cols="50" rows="5" name="content">${boardVO.content}</textarea></td></tr>
    </table>
    <input type="submit" value="수정하기"/>
    <input type="button" value="취소하기" onclick="history.back()">
    </table>
</form:form>

</body>
</html>
