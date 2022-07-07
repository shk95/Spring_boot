<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String notice_seq = (String) request.getAttribute("notice_seq");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<h2>글 수정 페이지</h2>
<form action="doNoticeUpdate">
    <div>제목</div>
    <div><input type="text" name = "title"></div>
    <div>내용</div>
    <div><textarea name="contents"></textarea></div>
    <div><input type="text" name="notice_seq" hidden="hidden" value="<%=notice_seq%>"></div>
    <div><input type="submit"></div>
</form>
</body>
</html>