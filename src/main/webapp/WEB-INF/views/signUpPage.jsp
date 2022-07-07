<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        * {
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
                이름 :
                <input name="user_name" type="text"/>
            </div>
            <div>
                이메일 :
                <input name="user_email" type="email"/>
            </div>
            <div>
                아이디 :
                <input name="user_id" type="text"/>
            </div>
            <div>
                패스워드 :
                <input id="passwd_chk1" name="user_pwd" type="password"/>
            </div>
            <div>
                패스워드 확인 :
                <input id="passwd_chk2" type="password"/>
            </div>

            <button type="submit">전송</button>
            <button type="reset">지우기</button>
        </form>
    </div>
</div>
</body>
</html>