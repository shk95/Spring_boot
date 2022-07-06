<%@ page import="java.util.List" %>
<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    List<NoticeDTO> rList = (List<NoticeDTO>) request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div style="margin: auto; width: 800px;">
    <table border="1" width="100%">
        <tr>
            <td>순번</td>
            <td>제목</td>
            <td>게시자</td>
            <td>등록일</td>
        </tr>
        <% for (int i = 0; i < rList.size(); i++) { %><tr>
            <td><%=rList.get(i).getNotice_seq()%>
            </td>
            <td><%=rList.get(i).getTitle()%>
            </td>
            <td><%=rList.get(i).getReg_id()%>
            </td>
            <td><%=rList.get(i).getRegdate()%>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>