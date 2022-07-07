<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        *{
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <div>
        <h1>회원가입</h1>
    </div>
    <div>
        <form action="/doSignUp" method="post">
            <div>
                <label>이름</label>
                <input name="user_name" type="text"/>
            </div>
            <div>
                <label>이메일</label>
                <input name="user_email" type="email"/>
            </div>
            <div>
                <label>아이디</label>
                <input name="user_id" type="text"/>
            </div>
            <div>
                <label>페스워드</label>
                <input name="user_pwd" type="password"/>
            </div>
            <button type="submit">전송</button>
            <button type="reset">지우기</button>
        </form>
    </div>
</div>
</body>
</html>