<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script>
        alert("<%=msg%>")
        location.href="<%=url%>"
    </script>
</head>
<body>

</body>
</html>