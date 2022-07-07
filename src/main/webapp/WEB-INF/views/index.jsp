<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>실습 홈페이지</title>
    <style type="text/css">
        * {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h1>로그인 페이지</h1>
    <hr>
    <form action="">
        아이디 : <input name="user_id" type="text" size="10"/>
        <br>
        비밀번호 : <input name="user_pwd" type="password" size="10"/>
        <br>
        <input type="submit" id="" value="로그인">
        <input type="button" onclick="location.href='goSignUpPage'" value="회원가입">
    </form>
</div>
</body>
</html>