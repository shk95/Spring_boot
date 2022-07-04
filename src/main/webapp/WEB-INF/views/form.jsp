<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style type="text/css">
        .div1 {
            display: inline-flex;
        }
    </style>

    <title></title>
</head>
<body class="container">
<div class="jumbotron">
    <h1>Form</h1>
    <p>폼을 통해 데이터 전송해봅시다.</p>
</div>
<div>
    <div class="div1">
        <form action="/getNoticeData" method="get">
            <div class="form-group">
                <label>게시판 제목 [get 방식]</label>
                <input name="title" type="text" class="form-control"/>
            </div>
            <div class="form-group">
                <label>게시판 내용</label>
                <textarea name="contents" class="form-control" style="height: 500px"/></textarea>
            </div>
            <div class="form-group">
                <label>작성자</label>
                <input name="author" type="text" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">전송</button>
            <button type="reset" class="btn btn-primary">취소</button>
        </form>
    </div>
    <div class="div1">
        <form action="/postNoticeData" method="post">
            <div class="form-group">
                <label>게시판 제목 [post 방식]</label>
                <input name="title" type="text" class="form-control"/>
            </div>
            <div class="form-group">
                <label>게시판 내용</label>
                <textarea name="contents" class="form-control" style="height: 500px"/></textarea>
            </div>
            <div class="form-group">
                <label>작성자</label>
                <input name="author" type="text" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">전송</button>
            <button type="reset" class="btn btn-primary">취소</button>
        </form>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
