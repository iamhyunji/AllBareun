<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>findID</title>
    <link rel="stylesheet" href="../css/reset.css" type="text/css" />
    <link rel="stylesheet" href="../css/layout.css" type="text/css" />
    <link rel="stylesheet" href="../css/common/find.css" type="text/css" />
</head>
<body>
    <!-- main -->
    <main>
        <section class="main">
            <div class="page-back"><a href="./login.html"> &lt;</a></div>
            <h1>비밀번호 찾기</h1>

            <div class="find-box">
                <a href="./findId"><div class="find-id find clicked">아이디 찾기</div></a>
                <div class="find-pwd find unclicked">비밀번호 찾기</div>
            </div>
            <form class="find-pwd-page" method="post" action="changePwd">
                <div id="password-box">
                    <ul>
                        <li >새 비밀번호</li>
                        <li class="password"><input type="password" name="pwd"></li>
                        <li>비밀번호 확인</li>
                        <li class="password"><input type="password"></li>
                    </ul>
                </div>
                
                <input type="submit" class="a-input-orange-m" id="login-button" value="비밀번호 변경">
            </form>
        </section>
    </main>
</body>
</html>