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
    <form method="get" action="doNoticeUpdate">
        <h4>제목 : <input name="title" type="text" value="<%=CmmUtil.nvl(rDTO.getTitle())%>"></h4>
        <hr>
        <div style="margin: auto; width: 800px;">작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%>
        </div>
        <hr>
        <div>
            <p>내용 :<textarea name="contents">
                <%=CmmUtil.nvl(rDTO.getContents())%>
            </p></textarea>
        </div>
        <hr>
        <div style="float: left;">
            <button onclick="location.href='getNoticeList'">뒤로</button>
        </div>
        <div style="float: left;">
            <button onclick="location.href='noticeUpdate?no=<%=rDTO.getNotice_seq()%>'">수정</button>
            <button onclick="location.href='noticeDelete?no=<%=rDTO.getNotice_seq()%>'">삭제</button>

        </div>
    </form>
</div>
</body>
</html>