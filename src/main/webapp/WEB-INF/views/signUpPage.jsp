<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        .wrapper {
            text-align: center;
        }

        p {
            display: inline-block;
            text-align: left;
        }

        input {
            text-align: right;
            display: inline-block;
        }

    </style>
    <script type="text/javascript">
        function formSubmit() {
            let psw1 = document.getElementById('passwd_chk1').value;
            let psw2 = document.getElementById('passwd_chk2').value;
            if (psw1 != psw2) {
                alert("비밀번호가 다릅니다.");
            }

            return false;
        }

    </script>
</head>
<body>
<div class="wrapper">
    <div>
        <h1>회원가입</h1>
    </div>
    <div>
        <form action="/doSignUp" method="post" id="form" onsubmit="formSubmit();">
            <div>
                <p>이름 :</p>
                <input name="user_name" type="text"/>
            </div>
            <div>
                <p>이메일 :</p>
                <input name="user_email" type="email"/>
            </div>
            <div>
                <p>아이디 :</p>
                <input name="user_id" type="text"/>
            </div>
            <div>
                <p>패스워드 :</p>
                <input id="passwd_chk1" name="user_pwd" type="password" onclick="select()"/>
            </div>
            <div>
                <p>패스워드 확인 :</p>
                <input id="passwd_chk2" type="password" onclick="select()"/>
            </div>

            <button type="submit">전송</button>
            <button type="reset">지우기</button>
        </form>
    </div>
</div>
</body>
</html>