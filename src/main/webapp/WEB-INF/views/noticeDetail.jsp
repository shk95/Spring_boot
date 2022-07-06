<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%
    NoticeDTO rDTO = (NoticeDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset=kopo.poly.util.CmmUtil"utf-8">
    <title></title>
</head>
<body>
    <div style="margin: auto; width: 800px;">
        <h4><%=CmmUtil.nvl(rDTO.getTitle())%></h4>
        <hr>
        <div style="margin: auto; width: 800px;">작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%></div>
        <div>
            <P>
                <%=CmmUtil.nvl(rDTO.getContents())%>
            </P>
        </div>
        <hr>
        <div style="margin: auto; width: 800px;">
            <button onclick="location.href='getNoticeList'">뒤로</button>
        </div>
    </div>
</body>
</html>