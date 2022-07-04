<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


    <title></title>
</head>
<body class="container">
<div class="jumbotron">
    <h1>Form</h1>
    <p>폼을 통해 데이터 전송해봅시다.</p>
</div>
<form action="/getNoticeData" method="post">
    <div class="form-group">
        <label>게시판 제목</label>
        <input name="title" type="text" class="form-control"/>
    </div>
    <div class="form-group">
        <label>게시판 내용</label>
        <textarea name="contents" class="form-control" style="height: 500px"/></textarea>
    </div>
    <button type="submit" class="btn btn-primary">전송</button>
</form>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
